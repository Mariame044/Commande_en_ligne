package com.example.cmd.service;

import com.example.cmd.model.Historique;
import com.example.cmd.model.Utilisateur;

import java.util.List;

public interface HistoriqueService {
    Historique addCREATIONhistorique(Utilisateur utilisateur, String description);
    Historique addMODIFICATIONhistorique(Utilisateur utilisateur, String description);
    Historique addSUPPRESSIONhistorique(Utilisateur utilisateur, String description);
    List<Historique> voirToutesHistoriques();
    List<Historique> voirToutesHistoriquesPar(Utilisateur utilisateur);
}
