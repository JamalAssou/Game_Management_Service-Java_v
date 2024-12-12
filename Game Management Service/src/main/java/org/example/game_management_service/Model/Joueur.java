package org.example.game_management_service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Joueur {
    @Id
    private Long id;
    private String nom;
    private String pseudonyme;
    private String email;
    private int niveau;
    private int pointsTotaux;
}
