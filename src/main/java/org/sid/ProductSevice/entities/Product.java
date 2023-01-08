package org.sid.ProductSevice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.awt.*;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String designation;//Nom du produit
    private String description;
    private int quantite_stock;
    private double prix;
    @Lob
    private String imageUrl;
    @ManyToOne
    private Catalog catalog;
}
