package org.example.game_management_service.DTO;

import lombok.Data;
import org.example.game_management_service.Model.Joueur;

@Data
public class ParticipationDTO {
    private Joueur joueur;
    private int score;
    private boolean victoire;
}
