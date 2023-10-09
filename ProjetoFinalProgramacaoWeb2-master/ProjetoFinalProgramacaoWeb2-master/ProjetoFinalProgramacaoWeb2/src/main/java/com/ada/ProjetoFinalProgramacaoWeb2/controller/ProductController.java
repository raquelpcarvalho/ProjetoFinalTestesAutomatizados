package com.ada.ProjetoFinalProgramacaoWeb2.controller;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.OrderResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.ProductRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.ProductResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProduct(
            @RequestParam(name = "typeProduct", required = false) Integer typeProduct
    ){
        return ResponseEntity.ok(productService.getAllProduct(typeProduct));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody ProductRequest productRequest){
        ProductResponse productResponse =  productService.saveProduct(productRequest);
        return ResponseEntity.created(URI.create("/product/"+productResponse.getId())).body(productResponse);
    }
}
