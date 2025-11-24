package br.com.safeline.modules.user.service;


import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.safeline.modules.report.service.ReportService;
import br.com.safeline.modules.response.BaseResponse;
import br.com.safeline.modules.user.dto.UserRequestDTO;
import br.com.safeline.modules.user.dto.UserResponseDTO;
import br.com.safeline.modules.user.exception.EmailAlreadyExistsException;
import br.com.safeline.modules.user.model.User;
import br.com.safeline.modules.user.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ReportService reportService;

    public BaseResponse<UserResponseDTO> createdUser(UserRequestDTO userRequestDTO) {

        this.userRepository.findByEmail(userRequestDTO.email()).ifPresent(user -> {
            throw new EmailAlreadyExistsException();
        });
        var encoded = this.passwordEncoder.encode(userRequestDTO.password());

        var userSaved = this.userRepository.save(User.builder().name(userRequestDTO.name()).email(userRequestDTO.email())
                .password(encoded).build());

        return BaseResponse.success("usuário cadastrado com sucesso!", UserResponseDTO.builder()
                .name(userSaved.getName()).email(userSaved.getEmail()).createdAt(userSaved.getCreatedAt())
                        .build(), HttpStatus.CREATED.value());
    }

    public BaseResponse<Set<UserResponseDTO>> getAllUsers(){
        var users = this.userRepository.findAll().stream().map(user ->  UserResponseDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt()).build()).collect(Collectors.toSet());
        return BaseResponse.success("usuários encontrados com sucesso", users, HttpStatus.OK.value());
    }

    public User getByEmail(String email) {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o email: " + email));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.getByEmail(username);
    }

}