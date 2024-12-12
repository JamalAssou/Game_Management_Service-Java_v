package org.example.game_management_service.Model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_partie")
    private Partie partie;

    @ManyToOne
    @JoinColumn(name = "id_joueur")
    private Joueur joueur;

    private int score;
    private boolean victoire;

}

