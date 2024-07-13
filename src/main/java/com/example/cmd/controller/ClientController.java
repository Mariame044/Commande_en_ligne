package com.example.cmd.controller;

import com.example.cmd.model.Client;
import com.example.cmd.service.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/client")



public class ClientController {


   private final UtilisateurService utilisateurService;

    // Endpoint pour la création de compte client
    @PostMapping("/creerCompte")
    public ResponseEntity<String> creerCompteClient(@RequestBody Client client, Authentication authentication) {
        // Vérifier si un utilisateur est déjà authentifié
        if (authentication != null && authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Vous êtes déjà connecté en tant que " + authentication.getName() + ". Vous ne pouvez pas créer un autre compte.");
        }

        // Sinon, permettre la création de compte client
        String message = utilisateurService.creerCompteClient(client);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/modifierMotDePasse")
    public ResponseEntity<String> modifierMotDePasse(@RequestBody Map<String, String> requestBody) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();

            String nouveauMotDePasse = requestBody.get("nouveauMotDePasse");
            if (nouveauMotDePasse == null || nouveauMotDePasse.isEmpty()) {
                return ResponseEntity.badRequest().body("Le nouveau mot de passe ne peut pas être vide.");
            }

            String message = utilisateurService.modifiermotDePasse(username, nouveauMotDePasse);
            return ResponseEntity.ok(message);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }



}