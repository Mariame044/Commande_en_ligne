package com.example.cmd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Table(name="PERSONNEL")
@Entity
@NoArgsConstructor
@Data
public class Personnel extends Utilisateur {

    private boolean actif;

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
    public Personnel(String username, String motDePasse, RoleType roletype){
        super(username, motDePasse, roletype);
    }
}
