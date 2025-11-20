package br.com.safe_line.safeline.modules.auth.service;

import br.com.safe_line.safeline.config.CookieService;
import br.com.safe_line.safeline.modules.auth.controller.AuthRequestDTO;
import br.com.safe_line.safeline.modules.response.BaseResponse;
import br.com.safe_line.safeline.modules.user.model.User;
import br.com.safe_line.safeline.modules.user.repository.AccessTokenRepository;
import br.com.safe_line.safeline.modules.user.repository.RefreshTokenRepository;
import br.com.safe_line.safeline.modules.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
        var email = "u@test.com";
        var rawPassword = "pass";
        var hashed = "hashed";

        User user = User.builder().email(email).password(hashed).build();

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(rawPassword, hashed)).thenReturn(true);
        when(jwtTokenService.generateRefreshToken(user)).thenReturn(org.mockito.Mockito.mock(br.com.safe_line.safeline.modules.user.model.RefreshToken.class));
        when(jwtTokenService.generateAccessToken(org.mockito.Mockito.eq(user), org.mockito.Mockito.any())).thenReturn("tok");

        AuthRequestDTO reqDto = new AuthRequestDTO(email, rawPassword);

        BaseResponse<String> resp = authService.authenticate(reqDto, response, request);

        assertNotNull(resp);
        assertTrue(resp.isSuccess());
    }

    @Test
    void refreshAccessToken_noCookie_returnsError() {
        when(cookieService.getTokenFromCookie(request, org.mockito.Mockito.anyString())).thenReturn(null);

        BaseResponse<String> resp = authService.refreshAccessToken(response, request);

        assertNotNull(resp);
        assertFalse(resp.isSuccess());
    }

}
