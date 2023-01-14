package com.example.orderservice.entities;

import com.example.orderservice.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date orderdate;
    @OneToMany(mappedBy = "order")
    private Collection<OrderItem> productItems;
    private Long customerID;
    @Transient
    private Customer customer;



}
