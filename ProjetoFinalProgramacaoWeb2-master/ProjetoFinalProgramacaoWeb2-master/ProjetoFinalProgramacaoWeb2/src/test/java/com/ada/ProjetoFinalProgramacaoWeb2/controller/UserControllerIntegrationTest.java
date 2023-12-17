package com.ada.ProjetoFinalProgramacaoWeb2.controller;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.UserResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.exception.UserNotFoundException;
import com.ada.ProjetoFinalProgramacaoWeb2.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void find_user_by_email_ok() throws Exception{
        String email = "exemplo@email.com";

        UserResponse userResponse = new UserResponse();
        userResponse.setId(1);
        userResponse.setName("Usuário Exemplo");
        userResponse.setEmail(email);

        Mockito.when(userService.findUserByEmail(Mockito.eq(email)))
                .thenReturn(userResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/user/email/{email}", email))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Usuário Exemplo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(email));
    }

    @Test
    public void find_user_by_email_exception() throws Exception {
        String email = "exemplo@email.com";

        Mockito.when(userService.findUserByEmail(Mockito.eq(email)))
                .thenThrow(new UserNotFoundException("Usuário não encontrado"));

        mockMvc.perform(MockMvcRequestBuilders.get("/user/email/{email}", email))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string("Usuário não encontrado"));
    }
}
