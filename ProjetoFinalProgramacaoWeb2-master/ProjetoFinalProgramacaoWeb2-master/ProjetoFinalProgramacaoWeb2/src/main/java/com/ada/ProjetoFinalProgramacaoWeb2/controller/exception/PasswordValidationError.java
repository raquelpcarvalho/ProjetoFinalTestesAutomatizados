package com.ada.ProjetoFinalProgramacaoWeb2.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PasswordValidationError extends Exception {
    private String description;
}
