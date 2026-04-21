package com.restaurantes;

import com.restaurantes.model.Restaurant;
import com.restaurantes.repository.RestaurantRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantesApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(RestaurantesApplication.class, args);
        //si no hay restaurantes inserto un par de ellos - inserto datos
        RestaurantRepository restaurantRepository = context.getBean(RestaurantRepository.class);
        restaurantRepository.save(Restaurant.builder()
                .name("Paquito Restaurante")
                .averagePrice(20.0)
                .active(true)
                .build());
        restaurantRepository.save(Restaurant.builder()
                .name("El Buen Sabor")
                .averagePrice(15.0)
                .active(true)
                .build());
        restaurantRepository.save(Restaurant.builder()
                .name("La Casa del Sabor")
                .averagePrice(25.0)
                .active(true)
                .build());
    }



}
