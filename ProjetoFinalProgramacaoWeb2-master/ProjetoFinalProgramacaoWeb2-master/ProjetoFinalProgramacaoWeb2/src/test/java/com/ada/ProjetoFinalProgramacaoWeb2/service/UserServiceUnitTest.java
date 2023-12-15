package com.ada.ProjetoFinalProgramacaoWeb2.service;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.UserRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.UserResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.exception.PasswordValidationError;
import com.ada.ProjetoFinalProgramacaoWeb2.model.User;
import com.ada.ProjetoFinalProgramacaoWeb2.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class UserServiceUnitTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;




    @Test
    public void find_user_by_cpf_user_not_exist_should_return_null(){
        Mockito.when(userRepository.findUserByCpf(Mockito.anyString())).thenReturn(null);

        UserResponse found = userService.findUserByCpf("unit-test");

        Assertions.assertNull(found);

        //Assertions.assertThrows(RuntimeException.class, () -> userService.findUserByCpf("unit-test"));

    }

}
