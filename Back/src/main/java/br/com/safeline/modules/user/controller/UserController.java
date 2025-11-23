package br.com.safeline.modules.user.controller;


import br.com.safeline.modules.response.BaseResponse;
import br.com.safeline.modules.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.safeline.modules.user.dto.UserRequestDTO;
import br.com.safeline.modules.user.dto.UserResponseDTO;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<UserResponseDTO>> createUserController(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createdUser(userRequestDTO));
    }

    @GetMapping("/alluser")
    public ResponseEntity<BaseResponse<Set<UserResponseDTO>>> getUserController() {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getAllUsers());
    }

}