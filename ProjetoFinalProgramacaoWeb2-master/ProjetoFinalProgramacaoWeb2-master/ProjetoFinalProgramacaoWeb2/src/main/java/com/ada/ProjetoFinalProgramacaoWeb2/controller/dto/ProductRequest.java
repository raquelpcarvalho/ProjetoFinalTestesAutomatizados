package com.ada.ProjetoFinalProgramacaoWeb2.controller.dto;

import com.ada.ProjetoFinalProgramacaoWeb2.model.TypeProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductRequest {
    private String name;
    private BigDecimal price;
    private Integer typeId;
}
