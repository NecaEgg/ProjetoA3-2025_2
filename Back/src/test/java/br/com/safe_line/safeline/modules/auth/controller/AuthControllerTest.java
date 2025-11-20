package br.com.safe_line.safeline.modules.auth.controller;

import br.com.safe_line.safeline.modules.auth.service.AuthService;
import br.com.safe_line.safeline.modules.response.BaseResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @Mock
    private AuthService authService;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private AuthController authController;

    @Test
    void authenticate_returnsServiceStatus() {
        var dto = new AuthRequestDTO("u@test.com", "pass");

        when(authService.authenticate(dto, response, request))
                .thenReturn(BaseResponse.<String>success("ok", "ok", 200));

        ResponseEntity<BaseResponse<String>> resp = authController.authenticate(dto, response, request);

        assertEquals(org.springframework.http.HttpStatus.OK, resp.getStatusCode());
        assertNotNull(resp.getBody());
        assertTrue(resp.getBody().isSuccess());
    }

}
