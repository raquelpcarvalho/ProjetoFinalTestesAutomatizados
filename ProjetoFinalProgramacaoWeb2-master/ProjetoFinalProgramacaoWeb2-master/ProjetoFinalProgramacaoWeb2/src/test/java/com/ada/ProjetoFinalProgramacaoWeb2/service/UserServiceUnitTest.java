package com.ada.ProjetoFinalProgramacaoWeb2.service;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.UserResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.model.User;
import com.ada.ProjetoFinalProgramacaoWeb2.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(SpringExtension.class)
public class UserServiceUnitTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    public void setup(){
        user = new User(0,"Test", "emailtest@email.com", "!Password123", true,"12345678901");

    }

    @Test
    public void find_user_by_cpf(){
        Mockito.when(userRepository.findUserByCpf(user.getCpf())).thenReturn(user);

        UserResponse userResponse = userService.findUserByCpf(user.getCpf());

        Assertions.assertNotNull(userResponse);

    }

    @Test
    public void find_user_by_id() {
        Mockito.when(userRepository.findById(anyInt())).thenReturn(Optional.of(user));

        UserResponse result = userService.findUserById(1);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(user.getName(), result.getName());
    }

}

