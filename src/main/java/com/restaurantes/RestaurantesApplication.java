package com.restaurantes;

import com.restaurantes.model.Dish;
import com.restaurantes.model.Restaurant;
import com.restaurantes.model.enums.FoodType;
import com.restaurantes.repository.DishRepository;
import com.restaurantes.repository.RestaurantRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantesApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(RestaurantesApplication.class, args);
        //si no hay restaurantes inserto un par de ellos - inserto datos
        RestaurantRepository restaurantRepository = context.getBean(RestaurantRepository.class);
        DishRepository dishRepository = context.getBean(DishRepository.class);
      Restaurant paco =  restaurantRepository.save(Restaurant.builder()
                .name("Paquito_Restaurante")
                .averagePrice(null)
                .active(false)
                .foodType(FoodType.SPANISH)
                .build());
        Restaurant sabor = restaurantRepository.save(Restaurant.builder()
                .name("El_Buen_Sabor")
                .averagePrice(15.0)
                .foodType(FoodType.MEXICAN)
                .active(true)
                .build());
      Restaurant casa =  restaurantRepository.save(Restaurant.builder()
                .name("La_Casa_del_Sabor")
                .averagePrice(25.0)
                .foodType(FoodType.JAPANESE)
                .active(true)
                .build());
        Restaurant cuartobar = restaurantRepository.save(Restaurant.builder()
                .name("Cuarto_Bar")
                .averagePrice(25.0)
                .foodType(null)
                .active(true)
                .build());

        //crear los pla tos de cada restaurante
        dishRepository.save(Dish.builder()
                .name("Paella")
                .price(12.0)
                .restaurant(paco)
                .description("Deliciosa paella con mariscos frescos y arroz sabroso.")
                .active(true)
                .imageUrl("https://recetasdecocina.elmundo.es/wp-content/uploads/2026/02/paella-de-marisco.jpg")
                .type("Main Course")
                .foodType(FoodType.SPANISH)
                .build());
        dishRepository.save(Dish.builder()
                .name("Pizza")
                .price(10.0)
                .restaurant(sabor)
                .description("Pizza casera con ingredientes frescos y masa crujiente.")
                .active(true)
                .imageUrl("https://www.sortirambnens.com/wp-content/uploads/2019/02/pizza-de-peperoni.jpg")
                .type("Main Course")
                .foodType(FoodType.MEXICAN)
                .build());
        dishRepository.save(Dish.builder()
                .name("Sushi")
                .price(15.0)
                .restaurant(casa)
                .description("Sushi fresco con una variedad de ingredientes y sabores.")
                .active(true)
                .imageUrl("https://offloadmedia.feverup.com/madridsecreto.co/wp-content/uploads/2022/02/02043605/Ruta-sushi3-1024x720.jpg")
                .type("Main Course")
                .foodType(FoodType.JAPANESE)
                .build());
         dishRepository.save(Dish.builder()
                .name("Hamburguesa")
                .price(8.0)
                 .restaurant(cuartobar)
                 .description("Hamburguesa jugosa con queso derretido y pan fresco.")
                .active(true)
                         .imageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOVesYKJ-znMaPhV7EHg-PwQ5EMpVKAoESoQ&s")
                .type("Main Course")
                .foodType(null)
                .build());


    }



}
