package br.com.safeline.modules.auth.service;

import br.com.safeline.modules.user.model.AccessToken;
import br.com.safeline.modules.user.model.RefreshToken;
import br.com.safeline.modules.user.model.User;
import br.com.safeline.modules.user.repository.AccessTokenRepository;
import br.com.safeline.modules.user.repository.RefreshTokenRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JwtTokenServiceTest {

    @Mock
    private AccessTokenRepository accessTokenRepository;

    @Mock
    private RefreshTokenRepository refreshTokenRepository;

    @InjectMocks
    private JwtTokenService jwtTokenService;

    @Test
    void generateRefreshToken_callsRepository() {
        User user = User.builder().email("x@x.com").build();
        // ensure roles is non-null to avoid NPE in generateAccessToken when invoked
        user.setRoles(new java.util.HashSet<>());
        RefreshToken saved = RefreshToken.builder().token("abc").user(user).build();

        when(refreshTokenRepository.save(org.mockito.Mockito.any(RefreshToken.class))).thenReturn(saved);

        RefreshToken result = jwtTokenService.generateRefreshToken(user);

        assertNotNull(result);
        assertEquals("abc", result.getToken());
    }

    @Test
    void revokeAccessToken_whenFound_setsRevoked() {
        AccessToken token = AccessToken.builder().token("t").build();
        when(accessTokenRepository.findByToken("t")).thenReturn(Optional.of(token));
        when(accessTokenRepository.save(token)).thenReturn(token);

        jwtTokenService.revokeAccessToken("t");

        assertTrue(token.isRevoked());
    }

}
