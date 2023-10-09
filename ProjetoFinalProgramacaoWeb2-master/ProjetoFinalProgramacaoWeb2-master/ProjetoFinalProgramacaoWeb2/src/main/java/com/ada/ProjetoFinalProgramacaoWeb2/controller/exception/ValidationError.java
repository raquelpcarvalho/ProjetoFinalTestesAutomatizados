package com.ada.ProjetoFinalProgramacaoWeb2.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//padrão para exceção lançada
@Getter
@Setter
@AllArgsConstructor
public class ValidationError {
    private String field; //campo
    private String message;
}
