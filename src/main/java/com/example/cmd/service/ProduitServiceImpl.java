package com.example.cmd.service;

import com.example.cmd.model.Produit;
import com.example.cmd.repository.ProduitRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
@AllArgsConstructor

public class ProduitServiceImpl implements ProduitService {

    private ProduitRepository produitRepository;


    /**
     * @param produit
     * @return
     */
    @Transactional
    @Override
    public String ajouterProduit(Produit produit) {
        produitRepository.save(produit);
        return "Produit ajouter avec succes!";
    }

    @Override
    public List<Produit> lireProduit() {
        return produitRepository.findAll();
    }

    @Override
    public String supprimerProduit(Long id) {
        produitRepository.deleteById(id);
        return "Produit supprimer!!!";
    }

}
