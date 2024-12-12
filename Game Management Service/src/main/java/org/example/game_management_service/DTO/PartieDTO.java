package org.example.game_management_service.DTO;

import lombok.Data;
import org.example.game_management_service.Model.TypePartie;

import java.time.LocalDate;
import java.util.Date;

@Data
public class PartieDTO {
    private Date date;
    private int scoreMax;
    private Long typePartieId; // Assurez-vous que le typePartie est bien transmis
}
