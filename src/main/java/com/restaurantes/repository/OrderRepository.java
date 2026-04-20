package com.restaurantes.repository;

import com.restaurantes.model.Order;
import com.restaurantes.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    //Filtrar ordenes por id de restaurante
    List<Order> findByRestaurant_Id(Long id);
    //Filtrar por estado de order
    List<Order> findByStatus(OrderStatus status);


    //calculate total price based on order lines
    //JPQL
    @Query("SELECT sum (ol.dish.price * ol.quantity) from OrderLine ol where ol.order.id = :orderId")

    Double calculateTotalPrice(Long orderId);


}