package com.sid.clientservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GeneratedColumn;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "client_Id")
    private Long id ;
    private String nom ;
    private String prenom ;
    private String email ;
    private String adresse ;
    private int age ;
    private String sexe ;
}
