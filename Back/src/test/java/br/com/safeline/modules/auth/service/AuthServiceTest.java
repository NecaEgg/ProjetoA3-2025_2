package br.com.safeline.modules.auth.service;

import br.com.safeline.config.CookieService;
import br.com.safeline.modules.auth.dto.AuthRequestDTO;
import br.com.safeline.modules.response.BaseResponse;
import br.com.safeline.modules.user.model.RefreshToken;
import br.com.safeline.modules.user.model.User;
import br.com.safeline.modules.user.repository.AccessTokenRepository;
import br.com.safeline.modules.user.repository.RefreshTokenRepository;
import br.com.safeline.modules.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private CookieService cookieService;

    @Mock
    private AccessTokenRepository accessTokenRepository;

    @Mock
    private RefreshTokenRepository refreshTokenRepository;

    @Mock
    private JwtTokenService jwtTokenService;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private AuthService authService;

    @Test
    void authenticate_success() {
        // Arrange
        var email = "u@test.com";
        var rawPassword = "pass";
        var hashed = "hashed";

        User user = User.builder().email(email).password(hashed).build();

        // Mock do RefreshToken com ID não nulo
        RefreshToken mockRefreshToken = mock(RefreshToken.class);
        when(mockRefreshToken.getIdRefreshToken()).thenReturn(UUID.randomUUID());

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(rawPassword, hashed)).thenReturn(true);
        when(jwtTokenService.generateRefreshToken(user)).thenReturn(mockRefreshToken);
        when(jwtTokenService.generateAccessToken(eq(user), any(RefreshToken.class))).thenReturn("tok");
        when(refreshTokenRepository.save(any(RefreshToken.class))).thenReturn(mockRefreshToken);

        AuthRequestDTO reqDto = new AuthRequestDTO(email, rawPassword);

        // Act
        BaseResponse<String> resp = authService.authenticate(reqDto, response, request);

        // Assert
        assertNotNull(resp);
        assertTrue(resp.isSuccess());

        // Verifica se os métodos foram chamados corretamente
        verify(userRepository).findByEmail(email);
        verify(passwordEncoder).matches(rawPassword, hashed);
        verify(jwtTokenService).generateRefreshToken(user);
        verify(jwtTokenService).generateAccessToken(eq(user), any(RefreshToken.class));
        verify(refreshTokenRepository).save(any(RefreshToken.class));
    }

    @Test
    void refreshAccessToken_noCookie_returnsError() {
        // Arrange
        when(cookieService.getTokenFromCookie(eq(request), anyString())).thenReturn(null);

        // Act
        BaseResponse<String> resp = authService.refreshAccessToken(response, request);

        // Assert
        assertNotNull(resp);
        assertFalse(resp.isSuccess());

        // Verifica se o método foi chamado corretamente
        verify(cookieService).getTokenFromCookie(eq(request), anyString());
    }

    // Teste para quando o cookie existe mas o token não é encontrado
    @Test
    void refreshAccessToken_invalidToken_returnsError() {
        // Arrange
        String tokenId = UUID.randomUUID().toString();
        UUID tokenUUID = UUID.fromString(tokenId);

        when(cookieService.getTokenFromCookie(eq(request), anyString())).thenReturn(tokenId);
        // CORREÇÃO: Usando findById que é o método padrão do JpaRepository
        when(refreshTokenRepository.findById(eq(tokenUUID))).thenReturn(Optional.empty());

        // Act
        BaseResponse<String> resp = authService.refreshAccessToken(response, request);

        // Assert
        assertNotNull(resp);
        assertFalse(resp.isSuccess());

        // Verifica as chamadas
        verify(cookieService).getTokenFromCookie(eq(request), anyString());
        verify(refreshTokenRepository).findById(eq(tokenUUID));
    }

    // Teste para fluxo de sucesso no refresh token
    @Test
    void refreshAccessToken_success() {
        // Arrange
        String tokenId = UUID.randomUUID().toString();
        UUID tokenUUID = UUID.fromString(tokenId);

        User user = User.builder().email("u@test.com").password("hashed").build();
        RefreshToken refreshToken = mock(RefreshToken.class);
        when(refreshToken.getIdRefreshToken()).thenReturn(tokenUUID);
        when(refreshToken.getUser()).thenReturn(user);

        when(cookieService.getTokenFromCookie(eq(request), anyString())).thenReturn(tokenId);
        // CORREÇÃO: Usando findById
        when(refreshTokenRepository.findById(eq(tokenUUID))).thenReturn(Optional.of(refreshToken));
        when(jwtTokenService.generateAccessToken(eq(user), eq(refreshToken))).thenReturn("new-access-token");

        // Act
        BaseResponse<String> resp = authService.refreshAccessToken(response, request);

        // Assert
        assertNotNull(resp);
        assertTrue(resp.isSuccess());

        // Verifica as chamadas
        verify(cookieService).getTokenFromCookie(eq(request), anyString());
        verify(refreshTokenRepository).findById(eq(tokenUUID));
        verify(jwtTokenService).generateAccessToken(eq(user), eq(refreshToken));
    }
}