package com.example.cmd.controller;



import com.example.cmd.model.*;
import com.example.cmd.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UtilisateurService utilisateurService;

    private Utilisateur utilisateur;



    @PostMapping("/creerpersonnel")
    public String ajouterPersonnel(@RequestBody Personnel personnel) {
                return utilisateurService.ajouterPersonnel(personnel);
    }

    @PostMapping("/creerclient")

    public String ajouterClient(@RequestBody Client client) {
        return utilisateurService.ajouterClient(client);
    }

    @PutMapping("/modifieradmin/{id}")

    public String modifierAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        return utilisateurService.modifierAdmin(id, admin);
    }

    @GetMapping("/listutilisateurs")

    public List<Utilisateur> lireUtilisateurs() {
        return utilisateurService.lireUtilisateurs();
    }

    @DeleteMapping("/supprimerutilisateur/{id}")

    public String supprimerUtilisateur(@PathVariable Long id) {
        return utilisateurService.supprimerUtilisateur(id);
    }


    @PostMapping("/creerproduit")
    public String ajouterproduit(@RequestBody Produit produit) {
        produit.setUtilisateur(utilisateur);
        return utilisateurService.ajouterProduit(produit);
    }
    @GetMapping ("/listProduit")

        public List<Produit> lireProduit() {
            return utilisateurService.lireProduit();
        }
    @DeleteMapping("/supprimerProduit/{id}")

    public String supprimerProduit(@PathVariable Long id) {
        return utilisateurService.supprimerProduit(id);
    }

    }

