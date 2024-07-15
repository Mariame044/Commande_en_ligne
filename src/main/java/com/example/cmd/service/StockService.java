package com.example.cmd.service;

import com.example.cmd.model.Produit;
import jakarta.transaction.Transactional;

public interface StockService {
    void ajouterProduit(Produit produit);
    void retirerProduit(Produit produit, int quantite);
}
