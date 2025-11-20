package br.com.safe_line.safeline.modules.user.controller;

import br.com.safe_line.safeline.modules.response.BaseResponse;
import br.com.safe_line.safeline.modules.user.dto.UserRequestDTO;
import br.com.safe_line.safeline.modules.user.dto.UserResponseDTO;
import br.com.safe_line.safeline.modules.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void createUserController_returnsCreated() {
        var req = new UserRequestDTO("n","e","p");
        when(userService.createdUser(req)).thenReturn(BaseResponse.success("ok", UserResponseDTO.builder().email("e").build(), 201));

        ResponseEntity<BaseResponse<UserResponseDTO>> resp = userController.createUserController(req);

        assertEquals(org.springframework.http.HttpStatus.CREATED, resp.getStatusCode());
        assertNotNull(resp.getBody());
    }

    @Test
    void getUserController_returnsList() {
        when(userService.getAllUsers()).thenReturn(BaseResponse.success("ok", Set.of(UserResponseDTO.builder().email("e").build()), 200));

        ResponseEntity<BaseResponse<Set<UserResponseDTO>>> resp = userController.getUserController();

        assertEquals(org.springframework.http.HttpStatus.OK, resp.getStatusCode());
        assertNotNull(resp.getBody());
    }

}
