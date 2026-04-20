package com.restaurantes.model;

import com.restaurantes.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
@Table(name = "orders")
@AllArgsConstructor
@ToString

public class Order {
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Nombre del cliente
    private String clienteName;
    //Numero de tabla
    private int tableNumber;
    //Numero del cliente
    @Column(unique = true)
    private int phone;
    //LocalDateTime date de la orden
    @Builder.Default //Para Valores por defecto en el builder
    private LocalDateTime date = LocalDateTime.now();
    //Estado de la orden (OPEN, CLOSED, PAID, CANCELLED)
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDIENTE;
    //precio total  - calcularse en base a los platos pedidos
    private Double totalPrice ;

    //Asociaciones
    @ToString.Exclude
    @ManyToOne
    private Restaurant restaurant;

}
