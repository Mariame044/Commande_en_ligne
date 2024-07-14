package com.example.cmd.service;

import com.example.cmd.model.*;
import com.example.cmd.repository.ProduitRepository;
import com.example.cmd.repository.UtilisateurRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
@AllArgsConstructor

public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ProduitRepository produitRepository;


    /**
     * @param personnel
     * @return
     */
    @Override
    public String ajouterPersonnel(Personnel personnel) {
        personnel.setRole(RoleType.PERSONNEL);
        personnel.setMotDePasse(passwordEncoder.encode(personnel.getMotDePasse()));
        //formateur.setMotDePasse("{noop}" + formateur.getMotDePasse());
        utilisateurRepository.save(personnel);
        return " Nouveau formateur ajouter avec succes!!";
    }

    /**
     * @param client
     * @return
     */
    @Transactional
    @Override
    public String ajouterClient(Client client) {

        client.setRole(RoleType.CLIENT);
        client.setMotDePasse(passwordEncoder.encode(client.getMotDePasse()));
        //apprenant.setMotDePasse("{noop}" + apprenant.getMotDePasse());
        utilisateurRepository.save(client);
        return "Nouveau client ajouter avec succes!";
    }

    /**
     * @param adminDetails
     * @return
     */
    @Override
    public String modifierAdmin(Long id, Admin adminDetails) {
        Admin admin = (Admin) utilisateurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé avec id : " + id));

        admin.setUsername(adminDetails.getUsername());
        admin.setMotDePasse(passwordEncoder.encode(adminDetails.getMotDePasse()));
        admin.setRole(RoleType.ADMIN);

        utilisateurRepository.save(admin);
        return "Admin modifier avec succes!";
    }

    /**
     * @return
     */
    @Transactional
    @Override
    public List<Utilisateur> lireUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Transactional
    @Override
    public String supprimerUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
        return "utilisateur supprimer!!!";
    }
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

    /**
     * @return
     */


    @PostConstruct
    public void initAdmin() {
        List<Utilisateur> admins = utilisateurRepository.findByRole(RoleType.ADMIN);
        if (admins.isEmpty()) {
            Admin admin = new Admin("admin", passwordEncoder.encode("admin"));
            utilisateurRepository.save(admin);
        }
    }
}