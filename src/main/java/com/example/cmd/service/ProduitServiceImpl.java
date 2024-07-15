package com.example.cmd.service;

import com.example.cmd.model.EntreeSorti;
import com.example.cmd.model.Produit;
import com.example.cmd.repository.ProduitRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Service
@AllArgsConstructor

public class ProduitServiceImpl implements ProduitService {

    private ProduitRepository produitRepository;
    private StockServiceImpl stockService;
    private EntreeSortiServiceImp entreeSortiServiceImp;

    /**
     * @param produit
     * @return
     */
    @Transactional
    @Override
    public String ajouterProduit(Produit produit) {
        Produit p = produitRepository.save(produit);
        EntreeSorti es = new EntreeSorti();
        es.setProduit(p);
        es.setDate(new Date());
        es.setLibelle("Entrée");
        es.setQuantite(p.getQuantite());
        this.entreeSortiServiceImp.creer(es);
        this.stockService.ajouterProduit(p);
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
