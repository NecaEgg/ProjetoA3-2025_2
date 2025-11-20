package br.com.safe_line.safeline.modules.user.service;

import br.com.safe_line.safeline.modules.report.service.ReportService;
import br.com.safe_line.safeline.modules.response.BaseResponse;
import br.com.safe_line.safeline.modules.user.dto.UserRequestDTO;
import br.com.safe_line.safeline.modules.user.model.User;
import br.com.safe_line.safeline.modules.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private ReportService reportService;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createdUser_success() {
        var req = new UserRequestDTO("Nome", "email@test.com", "senha1234");

        when(userRepository.findByEmail(req.email())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(req.password())).thenReturn("encoded");
        when(userRepository.save(org.mockito.ArgumentMatchers.any(User.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        BaseResponse<?> resp = userService.createdUser(req);

        assertNotNull(resp);
        assertTrue(resp.isSuccess());
        assertEquals(201, resp.getStatusCode());
    }

    @Test
    void getByEmail_notFound_throws() {
        when(userRepository.findByEmail("no@one.com")).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> userService.getByEmail("no@one.com"));
    }

}
