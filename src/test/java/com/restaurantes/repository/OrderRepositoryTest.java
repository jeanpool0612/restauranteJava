package com.restaurantes.repository;

import com.restaurantes.model.Order;
import com.restaurantes.model.Restaurant;
import com.restaurantes.model.enums.OrderStatus;
import jakarta.persistence.EntityManager;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@DisplayName("Test de pedidos en base de datos")
class OrderRepositoryTest {
    //order repository
    @Autowired
    OrderRepository OrderRepository;
    // Spring Data JPA ( Repository) --> EntityManager --> JDBC --> Base de datos
    // Agregamos EntityManager para poder limpiar la memoria y forzar consultas a base de datos
    // declarar datos para el test
    Restaurant restaurant1 ;
    Order order1;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private OrderRepository orderRepository;


    @BeforeEach
    void setUp() {
        //crear y guarda un pedido
//        restaurant1 = new Restaurant();
//        restaurant1.setName("Paco");
//        RestaurantRepository.save(restaurant1);
//        order1 = new Order();
//        order1.setClienteName("Juan");
//        OrderRepository.save(order1);
        restaurant1 = restaurantRepository.save(Restaurant.builder().name("Paco").build());
        order1 = OrderRepository.save(Order.builder().clienteName("Juan").restaurant(restaurant1).build());


    }
    //fecha y estado
    @Test
    void verificarValoresPorDefecto(){
        assertNotNull(order1.getId());
        assertNotNull(order1.getDate());
        assertEquals(OrderStatus.PENDIENTE,order1.getStatus());
        assertEquals(LocalDateTime.now().toLocalDate(),order1.getDate().toLocalDate());

    }

    @Test
    void findByRestaurant_Id() {
        List<Order> pedidos = orderRepository.findByRestaurant_Id(restaurant1.getId());
        assertEquals(1,pedidos.size());

    }

    @Test
    void findByStatus() {
        List<Order> pedidos = orderRepository.findByStatus(OrderStatus.PENDIENTE);
        assertEquals(1,pedidos.size());
    }
}