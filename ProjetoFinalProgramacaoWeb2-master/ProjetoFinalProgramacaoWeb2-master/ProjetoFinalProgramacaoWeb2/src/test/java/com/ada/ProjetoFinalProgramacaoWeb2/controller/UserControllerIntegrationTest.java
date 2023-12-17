package com.ada.ProjetoFinalProgramacaoWeb2.controller;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.UserRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.UserResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.exception.UserNotFoundException;
import com.ada.ProjetoFinalProgramacaoWeb2.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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

    @Test
    public void create_user() throws Exception {
        UserRequest userRequest = new UserRequest(
                "Novo Usuário",
                "novo_usuario@email.com",
                "!Password123",
                "00000000001");

        UserResponse userResponse = new UserResponse();
        userResponse.setId(1);
        userResponse.setName(userRequest.getName());
        userResponse.setEmail(userRequest.getEmail());

        Mockito.when(userService.saveUser(Mockito.any(UserRequest.class)))
                .thenReturn(userResponse);


        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"Novo Usuário\", \"email\": \"novo_usuario@email.com\", \"password\": \"senha123\" }"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(userRequest.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(userRequest.getEmail()));
    }

    @Test
    public void update_user() throws Exception {
        int userId = 1;

        UserRequest userRequest = new UserRequest(
                "Novo Nome",
                "novo_email@email.com",
                "!Password321",
                "10000000000" );


        UserResponse userResponse = new UserResponse();
        userResponse.setId(userId);
        userResponse.setName(userRequest.getName());
        userResponse.setEmail(userRequest.getEmail());

        Mockito.when(userService.updateUser(Mockito.eq(userId), Mockito.any(UserRequest.class)))
                .thenReturn(userResponse);


        mockMvc.perform(MockMvcRequestBuilders.put("/user/{id}", userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"Novo Nome\", \"email\": \"novo_email@email.com\" }"))

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(userId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(userRequest.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(userRequest.getEmail()));
    }

    @Test
    public void delete_user() throws Exception {
        // Defina o ID do usuário a ser excluído
        int userId = 1;

        // Simule o serviço para excluir um usuário
        Mockito.doNothing().when(userService).deleteUser(Mockito.eq(userId));

        // Realize a requisição DELETE ao endpoint /user/{id}
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/{id}", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                // Verifique se o status da resposta é NO_CONTENT (204), indicando exclusão bem-sucedida
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));

        Mockito.verify(userService, Mockito.times(1)).deleteUser(Mockito.eq(userId));

    }


}
