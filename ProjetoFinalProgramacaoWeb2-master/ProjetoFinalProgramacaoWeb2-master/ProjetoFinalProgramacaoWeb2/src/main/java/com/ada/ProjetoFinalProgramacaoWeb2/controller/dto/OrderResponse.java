package com.ada.ProjetoFinalProgramacaoWeb2.controller.dto;

import com.ada.ProjetoFinalProgramacaoWeb2.model.Product;
import com.ada.ProjetoFinalProgramacaoWeb2.model.User;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private Integer id;
    private BigDecimal totalPrice;
    private User user;
    private List<Product> products;
}
