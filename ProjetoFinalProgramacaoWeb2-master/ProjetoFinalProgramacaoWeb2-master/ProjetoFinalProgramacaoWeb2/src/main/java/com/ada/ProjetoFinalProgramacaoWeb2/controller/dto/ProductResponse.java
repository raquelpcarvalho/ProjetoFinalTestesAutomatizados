package com.ada.ProjetoFinalProgramacaoWeb2.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductResponse {
    private Integer id;
    private String name;
    private BigDecimal price;
    private TypeProductResponse type;

}
