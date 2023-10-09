package com.ada.ProjetoFinalProgramacaoWeb2.utils;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.TypeProductRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.TypeProductResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.model.TypeProduct;

import java.util.ArrayList;
import java.util.List;

public class TypeProductConvert {

    public static TypeProduct toEntity(TypeProductRequest typeProductDTO){
        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setName(typeProductDTO.getName());
        return typeProduct;
    }

    public static TypeProductResponse toResponse(TypeProduct typeProduct){
        TypeProductResponse typeProductResponse = new TypeProductResponse();
        typeProductResponse.setId(typeProduct.getId());
        typeProductResponse.setName(typeProduct.getName());
        return typeProductResponse;
    }

    public static List<TypeProductResponse> toResponseList(List<TypeProduct> typeProducts){
        List<TypeProductResponse> typeProductResponses = new ArrayList<>();
        for (TypeProduct typeProduct : typeProducts){
            TypeProductResponse typeProductResponse = TypeProductConvert.toResponse(typeProduct);
            typeProductResponses.add(typeProductResponse);
        }
        return typeProductResponses;
    }

}
