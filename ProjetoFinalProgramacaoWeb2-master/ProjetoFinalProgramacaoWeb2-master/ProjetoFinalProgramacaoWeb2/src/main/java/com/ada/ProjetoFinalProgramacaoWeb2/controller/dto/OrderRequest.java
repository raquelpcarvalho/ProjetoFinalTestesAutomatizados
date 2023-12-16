package com.ada.ProjetoFinalProgramacaoWeb2.controller.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class OrderRequest {
    private Integer userId;
    private List<Integer> productsIds;

    public void setUserId(Integer id) {
    }

    public void setProductsIds(List<Integer> productIds) {
    }
}
