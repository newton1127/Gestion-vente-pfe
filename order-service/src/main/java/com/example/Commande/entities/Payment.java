package com.example.Commande.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date datePayment;
    private long cardNumber;
    private String cardType;
    @OneToOne(mappedBy = "payment")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order order;

}
