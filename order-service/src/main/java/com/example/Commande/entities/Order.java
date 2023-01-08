package com.example.Commande.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;


@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @OneToMany(mappedBy = "order")
    private Collection<OrderItem> orderItems;

    private double totalAmount;
    @OneToOne
    private Payment payment;


}

