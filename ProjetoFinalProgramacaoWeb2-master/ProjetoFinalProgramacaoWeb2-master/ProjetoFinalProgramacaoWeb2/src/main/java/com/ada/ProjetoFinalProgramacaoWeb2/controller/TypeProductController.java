package com.ada.ProjetoFinalProgramacaoWeb2.controller;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.TypeProductRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.TypeProductResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/type-product")
public class TypeProductController {

    @Autowired
    TypeProductService typeProductService;

    @GetMapping
    public ResponseEntity<List<TypeProductResponse>> getAllTypeProduct(){
        return ResponseEntity.ok(typeProductService.getAllTypeProducts());
    }

    @PostMapping
    public ResponseEntity<TypeProductResponse> saveTypeProduct(@RequestBody TypeProductRequest typeProductRequest   ){ //@RequestBody informa que os dados virão do "body" da requisição
        TypeProductResponse typeProductResponse = typeProductService.saveTypeProduct(typeProductRequest);
        return ResponseEntity.created(URI.create("/type-product/"+typeProductResponse.getId())).body(typeProductResponse);
    }

    @DeleteMapping("/{id}")
    public void deleteTypeProduct(@PathVariable Integer id){
        typeProductService.deleteTypeProduct(id);
    }
}
