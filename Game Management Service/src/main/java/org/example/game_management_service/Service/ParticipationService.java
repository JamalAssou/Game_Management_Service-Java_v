package org.example.game_management_service.Service;

import org.example.game_management_service.DAO.ParticipationDAO;
import org.example.game_management_service.DAO.PartieDAO;
import org.example.game_management_service.DTO.ParticipationDTO;
import org.example.game_management_service.DTO.StatistiquesDTO;
import org.example.game_management_service.Model.Participation;
import org.example.game_management_service.Model.Partie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ParticipationService {

    @Autowired
    private ParticipationDAO participationDAO;

    @Autowired
    private PartieDAO partieDAO;

    @Autowired
    private RestTemplate restTemplate;

    public Participation enregistrerParticipation(Long partieId, ParticipationDTO participationDTO) {
        Partie partie = partieDAO.findById(partieId)
                .orElseThrow(() -> new RuntimeException("Partie introuvable"));

        Participation participation = new Participation();
        participation.setPartie(partie);
        participation.setJoueur(participationDTO.getJoueur());
        participation.setScore(participationDTO.getScore());
        participation.setVictoire(participationDTO.isVictoire());

        participation = participationDAO.save(participation);

        // Mettre à jour les statistiques du joueur
        mettreAJourStatistiquesJoueur(participationDTO.getJoueur().getId(), participationDTO.getScore(), participationDTO.isVictoire());

        return participation;
    }

    private void mettreAJourStatistiquesJoueur(Long joueurId, int score, boolean victoire) {
        String url = "http://localhost:8080/joueurs/" + joueurId + "/statistiques";
        // Créez un objet DTO pour mettre à jour les statistiques
        StatistiquesDTO statistiquesDTO = new StatistiquesDTO(score, victoire);
        restTemplate.postForEntity(url, statistiquesDTO, Void.class);
    }
}
