package com.example.cmd.model;


import com.example.cmd.model.RoleType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@MappedSuperclass
@Entity
@Table(name = "UTILISATEUR")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Getter
@Setter

public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String motDePasse;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    public Utilisateur(String username, String motDePasse, RoleType role) {
        this.username = username;
        this.motDePasse = motDePasse;
        this.role = role;
    }
}