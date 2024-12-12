package org.example.game_management_service.Controller;

import org.example.game_management_service.DTO.ParticipationDTO;
import org.example.game_management_service.Model.Participation;
import org.example.game_management_service.Service.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parties/{partieId}/participations")
public class ParticipationController {

    @Autowired
    private ParticipationService participationService;

    @PostMapping
    public ResponseEntity<Participation> enregistrerParticipation(@PathVariable Long partieId, @RequestBody ParticipationDTO participationDTO) {
        Participation participation = participationService.enregistrerParticipation(partieId, participationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(participation);
    }
}
