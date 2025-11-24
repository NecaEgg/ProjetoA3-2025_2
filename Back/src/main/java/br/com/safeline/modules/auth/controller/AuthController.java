package br.com.safeline.modules.auth.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.safeline.config.CookieService;
import br.com.safeline.modules.auth.dto.AuthRequestDTO;
import br.com.safeline.modules.auth.service.AuthService;
import br.com.safeline.modules.auth.service.JwtTokenService;
import br.com.safeline.modules.response.BaseResponse;
import br.com.safeline.modules.user.dto.UserRequestDTO;
import br.com.safeline.modules.user.exception.UsernameNotFoundException;
import br.com.safeline.modules.user.model.AccessToken;
import br.com.safeline.modules.user.model.User;
import br.com.safeline.modules.user.repository.AccessTokenRepository;
import br.com.safeline.modules.user.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth") 
@Tag(name = "Autenticação", description = "Endpoints para Login, Redefinição de Senha, Refresh e Logout")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private CookieService cookieService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    AccessTokenRepository accessTokenRepository;

    @Value("${app.jwt.cookie-name}")
    private String accessTokenCookieName;

    @Operation(summary = "Autentica um usuário",
            description = "Realiza o login, retorna o email e define cookies seguros (access e refresh).")
    @PostMapping("/login")
    public ResponseEntity<BaseResponse<String>> authenticate(
            @Valid @RequestBody AuthRequestDTO authRequestDTO,
            HttpServletResponse response,
            HttpServletRequest request) {

        var serviceResponse = this.authService.authenticate(
                authRequestDTO, response, request);
        return ResponseEntity.status(serviceResponse.getStatusCode()).body(serviceResponse);
    }


    @Operation(summary = "Renova o token de acesso (Access Token)", description = "Usa o 'refresh_token' (lido do cookie HttpOnly).")
    @PostMapping("/refresh") 
    public ResponseEntity<BaseResponse<String>> refreshAccessToken(
            HttpServletResponse response,
            HttpServletRequest request) {

        var serviceResponse = this.authService.refreshAccessToken(
                response, request);
        return ResponseEntity.status(serviceResponse.getStatusCode()).body(serviceResponse);
    }

    @Operation(summary = "Desloga o usuário",
            description = "Revoga os tokens no banco de dados e limpa os cookies.")
    @PostMapping("/logout") 
    public ResponseEntity<BaseResponse<String>> logout(
            HttpServletResponse response,
            HttpServletRequest request) {

        var serviceResponse = this.authService.logout(request, response);
        return ResponseEntity.status(serviceResponse.getStatusCode()).body(serviceResponse);
    }

    @GetMapping("/me")
    public ResponseEntity<BaseResponse<UserRequestDTO>> me(
            HttpServletRequest request) {
        try {
            String accessToken = cookieService.getTokenFromCookie(request, accessTokenCookieName);

            if (accessToken == null || accessToken.isEmpty()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(BaseResponse.error("Token não encontrado"));
            }

          
            String email = jwtTokenService.extractUsername(accessToken);

            if (email == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(BaseResponse.error("Token inválido"));
            }

      
            User user = userRepository.findByEmail(email)
                    .orElseThrow(UsernameNotFoundException::new);

         
            Optional<AccessToken> accessTokenOpt = accessTokenRepository.findByToken(accessToken);
            if (accessTokenOpt.isEmpty() || accessTokenOpt.get().isRevoked()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(BaseResponse.error("Token revogado"));
            }

       
            UserRequestDTO userDTO = UserRequestDTO.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .userId(user.getIdUser())
                    .build();

            return ResponseEntity.ok(BaseResponse.success("Usuário autenticado", userDTO, 200));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(BaseResponse.error("Falha na autenticação: " + e.getMessage()));
        }
    }
}