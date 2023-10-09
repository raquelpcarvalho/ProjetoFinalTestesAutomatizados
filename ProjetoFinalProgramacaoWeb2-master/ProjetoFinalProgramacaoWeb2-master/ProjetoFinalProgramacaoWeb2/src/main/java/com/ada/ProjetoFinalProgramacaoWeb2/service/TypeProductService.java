package com.ada.ProjetoFinalProgramacaoWeb2.service;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.TypeProductRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.TypeProductResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.model.TypeProduct;
import com.ada.ProjetoFinalProgramacaoWeb2.repository.TypeProductRepository;
import com.ada.ProjetoFinalProgramacaoWeb2.utils.TypeProductConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductService {

    @Autowired
    TypeProductRepository typeProductRepository;

    public List<TypeProductResponse> getAllTypeProducts(){
        return TypeProductConvert.toResponseList(typeProductRepository.findAll());
    }

    public TypeProductResponse saveTypeProduct(TypeProductRequest typeProductRequest){
        TypeProduct typeProduct = typeProductRepository.save(TypeProductConvert.toEntity(typeProductRequest));
        return TypeProductConvert.toResponse(typeProduct);
    }

    public void deleteTypeProduct(Integer id){
        typeProductRepository.deleteById(id);
    }

}
