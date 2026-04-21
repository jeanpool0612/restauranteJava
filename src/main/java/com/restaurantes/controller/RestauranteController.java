package com.restaurantes.controller;


import com.restaurantes.model.Dish;
import com.restaurantes.model.Restaurant;
import com.restaurantes.repository.DishRepository;
import com.restaurantes.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor


public class RestauranteController {

private RestaurantRepository restaurantRepository;
//private DishRepository dishRepository;
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

}
