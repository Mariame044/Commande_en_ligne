package com.example.cmd.service;

import com.example.cmd.model.Produit;
import com.example.cmd.model.Stock;
import com.example.cmd.repository.StockRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StockServiceImpl implements StockService{
    private StockRepository stockRepository;

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void ajouterProduit(Produit produit) {
        Optional<Stock> stock = this.stockRepository.findByProduit(produit);
        if (stock.isPresent()) {
            Stock stockInDB = stock.get();
            int qte = stockInDB.getQuantite();
            stockInDB.setQuantite(qte + produit.getQuantite());
            this.stockRepository.save(stockInDB);
        } else {
            Stock nouveauStock = new Stock();
            nouveauStock.setProduit(produit);
            nouveauStock.setQuantite(produit.getQuantite());
            this.stockRepository.save(nouveauStock);
        }
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void retirerProduit(Produit produit, int quantite) {
        Optional<Stock> stock = this.stockRepository.findByProduit(produit);
        if (stock.isPresent()) {
            Stock stockInDB = stock.get();
            int qte = stockInDB.getQuantite();
            if (qte > 0 && quantite<qte) {
                stockInDB.setQuantite(qte - quantite);
                this.stockRepository.save(stockInDB);
            }
        } else {
            System.out.println("Ce produit n'existe pas !!!");
        }
    }
}
