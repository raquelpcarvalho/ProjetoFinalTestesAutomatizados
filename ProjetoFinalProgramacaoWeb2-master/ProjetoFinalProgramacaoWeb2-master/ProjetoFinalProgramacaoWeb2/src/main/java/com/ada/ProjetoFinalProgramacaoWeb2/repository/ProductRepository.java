package com.ada.ProjetoFinalProgramacaoWeb2.repository;

import com.ada.ProjetoFinalProgramacaoWeb2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT p FROM Product p WHERE p.type.id = :typeProduct")
    List<Product> findProductByType(Integer typeProduct);



//    @Query(value = "SELECT o FROM Order o JOIN o.product p WHERE p.id = :productId")
//    List<Order> findAllByProduct(Integer productId);
}
