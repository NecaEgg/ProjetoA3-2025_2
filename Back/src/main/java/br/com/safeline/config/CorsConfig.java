package br.com.safeline.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

 @Override  // ← ADICIONE @Override
 public void addCorsMappings(CorsRegistry registry) {
  registry.addMapping("/api/v1/**")  // ← MUDE para /api/v1/**
          .allowedOrigins("http://localhost:5173")
          .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH") // ← Adicione PATCH
          .allowedHeaders("*")
          .allowCredentials(true)
          .maxAge(3600);

  // ADICIONE também um mapeamento global para garantir
  registry.addMapping("/**")
          .allowedOrigins("http://localhost:5173")
          .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
          .allowedHeaders("*")
          .allowCredentials(true)
          .maxAge(3600);
 }
}