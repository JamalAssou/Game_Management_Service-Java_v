package org.example.game_management_service.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class TypePartie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private int nombreJoueur;
}
