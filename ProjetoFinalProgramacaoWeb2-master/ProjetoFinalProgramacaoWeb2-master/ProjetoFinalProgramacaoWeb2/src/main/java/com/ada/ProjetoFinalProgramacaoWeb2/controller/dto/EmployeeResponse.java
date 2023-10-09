package com.ada.ProjetoFinalProgramacaoWeb2.controller.dto;

import com.ada.ProjetoFinalProgramacaoWeb2.model.User;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeResponse {
    private Integer matricula;
    private UserResponse user;
    private String address;
    private BigDecimal salary;

    //private LocalDate admissionDate;
}
