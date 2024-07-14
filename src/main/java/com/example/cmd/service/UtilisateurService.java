package com.example.cmd.service;

import com.example.cmd.model.*;

import java.util.List;//Admin ajouterAdmin(Admin admin);



public interface UtilisateurService {
String ajouterPersonnel(Personnel personnel);
String ajouterClient(Client client);


String modifierAdmin(Long id, Admin adminDetails);

List<Utilisateur> lireUtilisateurs();

String supprimerUtilisateur(Long id);

String ajouterProduit(Produit produit);


List<Produit> lireProduit();

String supprimerProduit(Long id);


}