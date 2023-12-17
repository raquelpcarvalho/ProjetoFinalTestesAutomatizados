package com.ada.ProjetoFinalProgramacaoWeb2.controller;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.UserRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.UserResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.exception.PasswordValidationError;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.exception.UserNotFoundException;
import com.ada.ProjetoFinalProgramacaoWeb2.model.User;
import com.ada.ProjetoFinalProgramacaoWeb2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping
    public ResponseEntity<Page<UserResponse>> getUser(
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0"
            ) int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10"
            ) int size,
            @RequestParam(
            value = "direction",
            required = false,
            defaultValue = "ASC"
            ) String direction
    ){
        return ResponseEntity.ok(userService.getUsers(page, size, direction));
    }

    @PostMapping
    public ResponseEntity<UserResponse> saveUser(
            @Valid @RequestBody UserRequest userDTO
    ) throws PasswordValidationError {
        UserResponse user =  userService.saveUser(userDTO);
        return ResponseEntity.created(URI.create("/user/" + user.getId())).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Integer id){
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email) throws UserNotFoundException {
//        try {
//            return ResponseEntity.ok(userService.findUserByEmail(email));
//        } catch (UserNotFoundException ex) {
//            throw ex; // Deixe a exceção ser tratada globalmente pelo manipulador apropriado
//        }

        return ResponseEntity.ok(userService.findUserByEmail(email));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<UserResponse>> getAllUserByName(@PathVariable String name, @PathVariable Integer id){
        return ResponseEntity.ok(userService.getAllByName(name));
    }


    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<UserResponse> getUserByCpf(@PathVariable String cpf){
        return ResponseEntity.ok(userService.findUserByCpf(cpf));
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Integer id,
            @RequestBody UserRequest userRequest
    ){
        return  ResponseEntity.ok(userService.updateUser(id, userRequest));
    }

}
