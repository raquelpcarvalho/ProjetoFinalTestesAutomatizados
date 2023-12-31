package com.ada.ProjetoFinalProgramacaoWeb2.service;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.ProductRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.ProductResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.model.Product;
import com.ada.ProjetoFinalProgramacaoWeb2.model.TypeProduct;
import com.ada.ProjetoFinalProgramacaoWeb2.repository.ProductRepository;
import com.ada.ProjetoFinalProgramacaoWeb2.repository.TypeProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class ProductServiceUnitTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private TypeProductRepository typeProductRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    public void setup(){
        product = new Product(0,"unit-test",BigDecimal.TEN,new TypeProduct());
    }

    @Test
    public void save_product(){

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setId(1);
        Mockito.when(typeProductRepository.findById(typeProduct.getId())).thenReturn(Optional.of(typeProduct));

        ProductRequest productRequest = new ProductRequest(product.getName(), product.getPrice(), typeProduct.getId());
        Mockito.when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductResponse productResponse = productService.saveProduct(productRequest);

        Assertions.assertNotNull(productResponse);
    }

    @Test
    public void saving_product_cheaper_than_um_real_exception(){
        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setId(1);
        Mockito.when(typeProductRepository.findById(typeProduct.getId())).thenReturn(Optional.of(typeProduct));

        ProductRequest productRequest = new ProductRequest(product.getName(), BigDecimal.ZERO, typeProduct.getId());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            productService.saveProduct(productRequest);
        });

    }

}