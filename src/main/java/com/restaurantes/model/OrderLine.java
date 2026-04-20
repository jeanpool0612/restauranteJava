package com.restaurantes.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
@Table(name = "orders_line")
@AllArgsConstructor
@ToString


public class OrderLine {
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Cantidad de platos pedidos
    private Integer quantity;

    //Asociaciones
    @ToString.Exclude
    @ManyToOne
    private Dish dish;

    @ToString.Exclude
    @ManyToOne
    private Order order;

}
