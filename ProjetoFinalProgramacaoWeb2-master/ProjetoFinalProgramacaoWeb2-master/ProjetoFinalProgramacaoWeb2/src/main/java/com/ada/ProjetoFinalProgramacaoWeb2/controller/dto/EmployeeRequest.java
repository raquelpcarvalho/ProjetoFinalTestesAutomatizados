package com.ada.ProjetoFinalProgramacaoWeb2.controller.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class EmployeeRequest {
    //private LocalDate admissionDate;

    private String address;
    private BigDecimal salary;
    private Integer userId;


}
