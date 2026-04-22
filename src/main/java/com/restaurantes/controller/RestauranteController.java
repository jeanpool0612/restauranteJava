package com.restaurantes.controller;


import com.restaurantes.model.Dish;
import com.restaurantes.model.Restaurant;
import com.restaurantes.repository.DishRepository;
import com.restaurantes.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor


public class RestauranteController {

private RestaurantRepository restaurantRepository;
private DishRepository dishRepository;
//
//    public RestauranteController(RestaurantRepository restaurantRepository,DishRepository dishRepository) {
//        this.restaurantRepository = restaurantRepository;
//        this.dishRepository = dishRepository;
//    }


            //PATRON MVC

    @GetMapping("/restaurantes") //controlador
    public String restaurantes(Model model) {
        //MODEL donde se guardan los datos
        model.addAttribute("mensaje", "Todos Los Restaurantes");
        model.addAttribute("restaurantes", restaurantRepository.findAll());

        return "restaurantes";} //vista HTML

    //Metodo para ver el detalle de un restaurante por su id
    //restaurantes/{id}
    @GetMapping("/restaurantes/{id}")
    public String restauranteId(@PathVariable Long id,Model model){

        Optional<Restaurant> restaurante = restaurantRepository.findById(id);


        if (restaurante.isPresent()){
            model.addAttribute("restaurante", restaurante.get());
            //sacar los platos  del restaurante
            List<Dish> platos = dishRepository.findByRestaurant_Id(id);
            model.addAttribute("dishes", dishRepository.findByRestaurant_Id(id));

            return "restaurantes-detail";
        }
        else {
            return "restaurantes";
        }




    }

}
