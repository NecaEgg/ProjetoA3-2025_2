package br.com.safeline.modules.user.dto;

import lombok.Builder;

@Builder
public record UserRequestDTO (

     String name,
     String email,
     String password

    ){}

