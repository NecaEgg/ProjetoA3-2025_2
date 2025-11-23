package br.com.safeline.modules.auth.service;


import br.com.safeline.modules.user.model.AccessToken;
import br.com.safeline.modules.user.model.RefreshToken;
import br.com.safeline.modules.user.model.Role;
import br.com.safeline.modules.user.model.User;
import br.com.safeline.modules.user.repository.AccessTokenRepository;
import br.com.safeline.modules.user.repository.RefreshTokenRepository;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JwtTokenService {

    @Value("${app.jwt.secret}")
    private String secret;

    @Value("${app.jwt.access-expiration-ms}")
    private long accessTokenExpirationMs;

    @Value("${app.jwt.refresh-expiration-ms}")
    private long refreshTokenExpirationMs;


    private final AccessTokenRepository accessTokenRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    // =============================
    //        CHAVE JWT
    // =============================
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(this.secret.getBytes(StandardCharsets.UTF_8));
    }

    // =============================
    //        GERAR ACCESS TOKEN
    // =============================
    public String generateAccessToken(User user, RefreshToken refreshToken) {

        Instant now = Instant.now();
        Instant expires = now.plus(15, ChronoUnit.MINUTES);

        String jwt = Jwts.builder()
                .subject(user.getEmail())
                .issuedAt(Date.from(now))
                .expiration(Date.from(expires))
                .claim("email", user.getEmail())
                .claim("roles", user.getRoles().stream().map(Role::getName).toList())
                .signWith(this.getSigningKey(), SignatureAlgorithm.HS256)
                .compact();

        var accessToken = AccessToken.builder()
                .token(jwt)
                .user(user)
                .refreshToken(refreshToken)
                .expiresAt(expires)
                .build();

        this.accessTokenRepository.save(accessToken);

        return jwt;
    }

    // =============================
    //       GERAR REFRESH TOKEN
    // =============================
    public RefreshToken generateRefreshToken(User user) {

        String tokenValue = UUID.randomUUID().toString();

        var refreshToken = RefreshToken.builder()
                .token(tokenValue)
                .user(user)
                .expiresAt(Instant.now().plusMillis(this.refreshTokenExpirationMs))
                .isRevoked(false)
                .build();

        return this.refreshTokenRepository.save(refreshToken);
    }

    // =============================
    //       VALIDAR TOKEN JWT
    // =============================
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(this.getSigningKey())     // chave correta
                    .build()
                    .parseSignedClaims(token);       // método correto
            return true;

        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // =============================
    //       REVOGAR TOKEN
    // =============================
    public void revokeAccessToken(String token) {
        this.accessTokenRepository.findByToken(token).ifPresent(accessToken -> {
            accessToken.setRevoked(true);
            this.accessTokenRepository.save(accessToken);
        });
    }

    // =============================
    //   RENOVAR / REFRESH TOKEN
    // =============================
    public String refreshAccessToken(String refreshTokenId) {

        RefreshToken refreshToken = this.refreshTokenRepository.findById(UUID.fromString(refreshTokenId))
                .orElseThrow(() -> new RuntimeException("Refresh token não encontrado."));

        var  lastToken = this.accessTokenRepository
                .findFirstByRefreshTokenOrderByCreatedAtDesc(refreshToken)
                .orElseThrow(() -> new RuntimeException("Nenhum access token encontrado."));

        if (lastToken.getExpiresAt().isAfter(Instant.now())) {
            throw new RuntimeException("Access Token ainda é válido, não é necessário renovar.");
        }

        return this.generateAccessToken(lastToken.getUser(), refreshToken);
    }

    public String extractUsername(String jwt) {
        return Jwts.parser()
                .verifyWith(this.getSigningKey())   // chave correta
                .build()
                .parseSignedClaims(jwt)        // parse seguro
                .getPayload()
                .getSubject();                 // subject = id do usuário
    }

}
