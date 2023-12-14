package com.ada.ProjetoFinalProgramacaoWeb2.service;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.OrderResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.ProductRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.ProductResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.model.Product;
import com.ada.ProjetoFinalProgramacaoWeb2.model.TypeProduct;
import com.ada.ProjetoFinalProgramacaoWeb2.repository.ProductRepository;
import com.ada.ProjetoFinalProgramacaoWeb2.repository.TypeProductRepository;
import com.ada.ProjetoFinalProgramacaoWeb2.utils.OrderConvert;
import com.ada.ProjetoFinalProgramacaoWeb2.utils.ProductConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TypeProductRepository typeProductRepository;

    public ProductResponse saveProduct(ProductRequest productRequest){
        TypeProduct typeProduct = typeProductRepository.findById(productRequest.getTypeId()).get();
        Product product = ProductConvert.toEntity(productRequest, typeProduct);
        return ProductConvert.toResponse(productRepository.save(product));
    }

    public List<ProductResponse> getAllProduct(Integer typeProduct){
        if (typeProduct != null){
            return getAllByTypeProduct(typeProduct);
        }
        return ProductConvert.toResponseList(productRepository.findAll());
    }

    public List<ProductResponse> getAllByTypeProduct(Integer typeProduct){
        return ProductConvert.toResponseList(productRepository.findProductByType(typeProduct));
    }


}
