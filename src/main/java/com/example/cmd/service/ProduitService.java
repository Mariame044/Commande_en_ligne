package com.example.cmd.service;

import com.example.cmd.model.Produit;

import java.util.List;

public interface ProduitService {


    String ajouterProduit(Produit produit);


    List<Produit> lireProduit();

    String supprimerProduit(Long id);

}