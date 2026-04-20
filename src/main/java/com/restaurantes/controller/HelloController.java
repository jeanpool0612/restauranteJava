package com.restaurantes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello() {return "hello";}
    //crear un metodo adios que tenga model coo parametro
    //mode.addAttribute("mensaje" , "adios mundo cruel");

    @GetMapping("/adios")
    public String adios(Model model) {
        model.addAttribute("mensaje" , "Hola desde Java");
        model.addAttribute("dinero" , 300.00);
        return "adios";}

}
