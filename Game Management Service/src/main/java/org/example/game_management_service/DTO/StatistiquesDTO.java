package org.example.game_management_service.DTO;

import lombok.Data;

@Data
public class StatistiquesDTO {
    private int score;
    private boolean victoire;

    public StatistiquesDTO(int score, boolean victoire) {
        this.score = score;
        this.victoire = victoire;
    }

}
