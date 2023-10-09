package com.ada.ProjetoFinalProgramacaoWeb2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelthCheck {
    @RequestMapping("/")
    public String helthCheck(){
        return "Application Running";
    }
}
