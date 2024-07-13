package com.example.cmd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name="CLIENT")
@Entity
@NoArgsConstructor
@Data
public class Client extends Utilisateur {

    private boolean actif;

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
    public Client(String username, String motDePasse, RoleType roletype){
        super(username, motDePasse, roletype);
    }


}

