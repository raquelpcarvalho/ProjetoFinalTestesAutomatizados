package com.ada.ProjetoFinalProgramacaoWeb2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal totalPrice;

    //pode ter muitos pedidos de 1 usuário(user)

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Product> products;
}
