package com.restaurantes.repository;

import com.restaurantes.model.Dish;
import com.restaurantes.model.Order;
import com.restaurantes.model.OrderLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@DisplayName("Test de Linea de Orden")
class OrderLineRepositoryTest {
    //llamamos los repos
    @Autowired
    DishRepository DishRepository;
    @Autowired
    OrderRepository OrderRepository;
    @Autowired
    OrderLineRepository OrderLineRepository;

    Order oder1;
    Dish dish1;

    @BeforeEach
    void setUp() {
        dish1 = DishRepository.save(Dish.builder().name("Pizza").price(10.0).build());
        oder1 = OrderRepository.save(Order.builder().clienteName("Juan").build());
    }

    @Test
    void findByDish_Id() {
        List<OrderLine> orderLines = OrderLineRepository.findByDish_Id(dish1.getId());
    }

}