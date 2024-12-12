package org.example.game_management_service.Controller;

import org.example.game_management_service.DTO.PartieDTO;
import org.example.game_management_service.Model.Partie;
import org.example.game_management_service.Service.PartieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parties")
public class PartieController {

    @Autowired
    private PartieService partieService;

    @PostMapping
    public ResponseEntity<Partie> creerPartie(@RequestBody PartieDTO partieDTO) {
        Partie partie = partieService.creerPartie(partieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(partie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partie> obtenirPartie(@PathVariable Long id) {
        return ResponseEntity.ok(partieService.obtenirPartie(id));
    }

    @GetMapping
    public List<Partie> obtenirToutesLesParties() {
        return partieService.obtenirToutesLesParties();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerPartie(@PathVariable Long id) {
        partieService.supprimerPartie(id);
        return ResponseEntity.noContent().build();
    }

}
