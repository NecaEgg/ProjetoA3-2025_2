package br.com.safeline.modules.user.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UserRequestDTO (

     String name,
     String email,
     String password,
     UUID userId

    ){}

