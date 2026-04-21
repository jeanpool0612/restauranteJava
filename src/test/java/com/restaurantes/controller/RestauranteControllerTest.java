package com.restaurantes.controller;

import com.restaurantes.model.Restaurant;
import com.restaurantes.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

//activa Spring
@SpringBootTest
//Activa MockMvc para testing
@AutoConfigureMockMvc

class RestauranteControllerTest {
    //restaurante repositorio
    @Autowired
    RestaurantRepository restaurantRepository;
//Utilidad de testing para lanzar peticiones a controladores test
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        //limpamos
        restaurantRepository.deleteAll();
        //crear datos de prueba para los restaurantes
        var restaurant1 = Restaurant.builder().name("jp bar").active(true).averagePrice(35.00).build();
       var restaurant2 = Restaurant.builder().name("restaurante jp").active(true).averagePrice(10.00).build();
       var restaurant3 = Restaurant.builder().name("restaurante del pueblo").active(false).averagePrice(20.00).build();
       restaurantRepository.saveAll(List.of(restaurant1, restaurant2,restaurant3));

    }

    @Test
    void restaurantesFull() throws Exception {
        //invocar endpoint http://localhost:8080/restaurantes
        // mockMvc.perform(get()
        //y verificamos que devuelve un status 200 ok
        mockMvc.perform(get("/restaurantes"))
                .andExpect(status().isOk())
                .andExpect(view().name("restaurantes"))
                .andExpect(model().attributeExists("mensaje"))
                .andExpect(model().attributeExists("restaurantes"))
                .andExpect(model().attribute("restaurantes",hasSize(3)));

    }
    @Test
    void restauranteEmpty() {
        //invocar endpoint http://localhost:8080/restaurantes
        // mockMvc.perform(get()
    }
}