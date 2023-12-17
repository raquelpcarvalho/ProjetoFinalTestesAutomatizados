package com.ada.ProjetoFinalProgramacaoWeb2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.ProductRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.ProductResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.model.TypeProduct;
import com.ada.ProjetoFinalProgramacaoWeb2.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /*
    @Test
    public void saveProduct() throws Exception {

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setId(1);

        ProductRequest productRequest = new ProductRequest("Test Product",new BigDecimal("10.99"), typeProduct.getId());


        String productJson = objectMapper.writeValueAsString(productRequest);


        ResultActions result = mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productJson))
                .andExpect(status().isCreated())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.name").value("Test Product"))
                .andExpect(jsonPath("$.price").value("10.99"));


        String responseContent = result.andReturn().getResponse().getContentAsString();
        ProductResponse productResponse = objectMapper.readValue(responseContent, ProductResponse.class);

        assertNotNull(productResponse);
        assertNotNull(productResponse.getId());

    }

    @Test
    @DisplayName("Não deve ser possível cadastrar produto sem informar o preço")
    public void it_should_not_be_possible_to_register_a_product_without_the_price() throws Exception {

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setId(1);

        ProductRequest productRequest = new ProductRequest("Test Product", null, typeProduct.getId());

        String productJson = objectMapper.writeValueAsString(productRequest);

        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productJson))
                .andExpect(status().isBadRequest());
    }
     */

}
