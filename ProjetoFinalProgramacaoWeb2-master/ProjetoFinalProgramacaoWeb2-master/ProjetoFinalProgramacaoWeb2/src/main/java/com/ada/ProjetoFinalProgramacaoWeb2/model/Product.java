package com.ada.ProjetoFinalProgramacaoWeb2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter @Setter
public class Product {

    @Id// informando para o JPA qual será o identificador único da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)//gera o id; IDENTITY -> auto incremento
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    //pode ter muitos produtos de 1 tipo

    @ManyToOne
    private TypeProduct type;

//    @Column(name = "description", nullable = false)
//    private String description;


//    @Column(name = "barcode", nullable = false)
//    private String barcode;
}
