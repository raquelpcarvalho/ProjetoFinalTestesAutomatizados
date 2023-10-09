package com.ada.ProjetoFinalProgramacaoWeb2.utils;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.ProductRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.ProductResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.model.Product;
import com.ada.ProjetoFinalProgramacaoWeb2.model.TypeProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductConvert {
    public static Product toEntity(ProductRequest productRequest, TypeProduct typeProduct){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setType(typeProduct);
        return product;
    }

    public static ProductResponse toResponse(Product product){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        productResponse.setType(TypeProductConvert.toResponse(product.getType()));
        return productResponse;
    }

    public static List<ProductResponse> toResponseList(List<Product> products){
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : products){
            productResponses.add(toResponse(product));
        }
        return productResponses;
    }

}
