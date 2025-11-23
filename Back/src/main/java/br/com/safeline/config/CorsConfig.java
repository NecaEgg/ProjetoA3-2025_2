package br.com.safeline.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

 @Override
 public void addCorsMappings(CorsRegistry registry) {

  // Define as configurações de CORS para todos os endpoints (/**)
  registry.addMapping("/**")

    // Permite a origem específica do seu frontend
    .allowedOrigins("http://localhost:5173")

    // Permite todos os métodos HTTP (GET, POST, PUT, DELETE, etc.)
    .allowedMethods("*")

    // Permite todos os cabeçalhos na requisição (incluindo Authorization)
    .allowedHeaders("*")

    // Muito importante para requisições com credenciais (cookies, headers de
    // autorização)
    .allowCredentials(true)

    // Define por quanto tempo (em segundos) o navegador pode armazenar em cache a
    // resposta do preflight
    .maxAge(3600);
 }
}