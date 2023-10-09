package com.ada.ProjetoFinalProgramacaoWeb2.service;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.OrderRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.OrderResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.ProductRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.ProductResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.model.Order;
import com.ada.ProjetoFinalProgramacaoWeb2.model.Product;
import com.ada.ProjetoFinalProgramacaoWeb2.model.TypeProduct;
import com.ada.ProjetoFinalProgramacaoWeb2.model.User;
import com.ada.ProjetoFinalProgramacaoWeb2.repository.OrderRepository;
import com.ada.ProjetoFinalProgramacaoWeb2.repository.ProductRepository;
import com.ada.ProjetoFinalProgramacaoWeb2.repository.UserRepository;
import com.ada.ProjetoFinalProgramacaoWeb2.utils.OrderConvert;
import com.ada.ProjetoFinalProgramacaoWeb2.utils.ProductConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    public OrderResponse saveOrder(OrderRequest orderRequest){
        User user = userRepository.findById(orderRequest.getUserId()).get();

        List<Product> products = new ArrayList<>();
        List<Integer> productsId = orderRequest.getProductsIds();

        for(Integer id: productsId){
            Product product = productRepository.findById(id).get();
            products.add(product);
        }

        Order order = OrderConvert.toEntity(orderRequest, user, products);
        return OrderConvert.toResponse(orderRepository.save(order));
    }

    public List<OrderResponse> getAllOrders(Integer userId, Integer productId){
        if (userId != null){
            return getAllByUser(userId);
        } else if (productId != null) {
            return getAllByProduct(productId);
        } else {
            return  OrderConvert.toResponseList(orderRepository.findAll());
        }

    }

    public List<OrderResponse> getAllByUser(Integer userId){
        return OrderConvert.toResponseList(orderRepository.findAllByUser(userId));
    }

    public List<OrderResponse> getAllByProduct(Integer productId){
        return OrderConvert.toResponseList(orderRepository.findAllByProduct(productId));
    }

}
