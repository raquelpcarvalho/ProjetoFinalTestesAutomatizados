package com.ada.ProjetoFinalProgramacaoWeb2.service;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.OrderRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.OrderResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.model.Order;
import com.ada.ProjetoFinalProgramacaoWeb2.model.Product;
import com.ada.ProjetoFinalProgramacaoWeb2.model.User;
import com.ada.ProjetoFinalProgramacaoWeb2.repository.OrderRepository;
import com.ada.ProjetoFinalProgramacaoWeb2.repository.ProductRepository;
import com.ada.ProjetoFinalProgramacaoWeb2.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;


@ExtendWith(SpringExtension.class)
public class OrderServiceUnitTest {
    @Mock
    private OrderRepository orderRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private OrderService orderService;

    private Order order;
    private User user;

    @BeforeEach
    public void setup(){
        order = new Order();
        order.setId(1);

        user = new User();
        user.setId(1);

        Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
    }


    @Test
    public void save_order_with_invalid_userId() {
        // Configurando o pedido de teste com ID de usuário inválido
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setUserId(null);  // Defina um ID de usuário inválido

        // Executando o método a ser testado e esperando uma exceção
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            orderService.saveOrder(orderRequest);
        });

        // Verificações
        Mockito.verify(userRepository, Mockito.never()).findById(any(Integer.class));
        Mockito.verify(productRepository, Mockito.never()).findById(any(Integer.class));
        Mockito.verify(orderRepository, Mockito.never()).save(any(Order.class));
    }


}