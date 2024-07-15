package com.example.cmd.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "PRODUIT")
@Getter
@Setter
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Float prix;
    private int quantite;
    LocalDate date = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;



    public Produit(String description, Categorie categorie, Float prix, int quantite, Utilisateur utilisateur) {
        this.description = description;
        this.categorie = categorie;
        this.prix = prix;
        this.quantite = quantite;
        this.utilisateur = utilisateur;
    }


}
