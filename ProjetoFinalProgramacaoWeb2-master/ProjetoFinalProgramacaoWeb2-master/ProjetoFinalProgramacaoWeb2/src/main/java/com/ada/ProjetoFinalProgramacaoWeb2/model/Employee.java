package com.ada.ProjetoFinalProgramacaoWeb2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@Setter
@Where(clause = "active is true")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matricula;

    //@Column(name = "admissionDate", nullable = false)
    //private LocalDate admissionDate;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;


    @OneToOne
    private User user;

    private Boolean active;


}
