package br.com.safeline.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.safeline.modules.auth.service.JwtTokenService;
import br.com.safeline.modules.user.repository.AccessTokenRepository;
import br.com.safeline.modules.user.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component 
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private CookieService cookieService;

    @Autowired
    @Lazy  
    private UserService userService;

    @Autowired
    private AccessTokenRepository accessTokenRepository;

    @Value("${app.jwt.cookie-name}")
    private String accessTokenCookieName;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        final String path = request.getServletPath(); 

        try {
            String jwt = this.cookieService.getTokenFromCookie(request, this.accessTokenCookieName);

            if (!StringUtils.hasText(jwt) ||
                    SecurityContextHolder.getContext().getAuthentication() != null) {
                filterChain.doFilter(request, response);
                return;
            }

            String username = this.jwtTokenService.extractUsername(jwt);
            var userDetails = this.userService.loadUserByUsername(username);

            boolean isTokenValid = this.accessTokenRepository.findByToken(jwt)
                    .map(token -> !token.isRevoked()) 
                    .orElse(false);                   

            if (isTokenValid) {

                var authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,       
                        userDetails.getAuthorities() 
                );

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }

        } catch (Exception e) {

            JwtFilter.log.warn(
                    "Falha ao autenticar via JWT (rota protegida): {}. Token ignorado.",
                    e.getMessage()
            );

            SecurityContextHolder.clearContext();
        }
        filterChain.doFilter(request, response);
    }
}
