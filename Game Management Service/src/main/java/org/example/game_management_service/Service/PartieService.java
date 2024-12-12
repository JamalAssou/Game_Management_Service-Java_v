package org.example.game_management_service.Service;

import jakarta.persistence.EntityNotFoundException;
import org.example.game_management_service.DAO.ParticipationDAO;
import org.example.game_management_service.DAO.PartieDAO;
import org.example.game_management_service.DAO.TypePartieDAO;
import org.example.game_management_service.DTO.PartieDTO;
import org.example.game_management_service.Model.Partie;
import org.example.game_management_service.Model.TypePartie;
import org.example.game_management_service.Repository.PartieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PartieService {
    @Autowired
    private PartieDAO partieDAO;

    @Autowired
    private TypePartieDAO typePartieDAO;

    @Autowired
    private ParticipationDAO participationDAO;

    public Partie creerPartie(PartieDTO partieDTO) {
        Partie partie = new Partie();
        partie.setDate(partieDTO.getDate());
        partie.setScoreMax(partieDTO.getScoreMax());

        TypePartie typePartie = typePartieDAO.findById(partieDTO.getTypePartieId())
                .orElseThrow(() -> new RuntimeException("Type de partie introuvable"));
        partie.setTypePartie(typePartie);

        return partieDAO.save(partie);
    }

    public Partie obtenirPartie(Long id) {
        return partieDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Partie introuvable"));
    }

    public List<Partie> obtenirToutesLesParties() {
        return partieDAO.findAll();
    }

    public void supprimerPartie(Long id) {
        Partie partie = partieDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Partie introuvable"));
        partieDAO.delete(partie);
    }
}
