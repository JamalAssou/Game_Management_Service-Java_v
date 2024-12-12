package org.example.game_management_service.Service;

import org.example.game_management_service.DAO.ParticipationDAO;
import org.example.game_management_service.DAO.PartieDAO;
import org.example.game_management_service.DTO.ParticipationDTO;
import org.example.game_management_service.Model.Participation;
import org.example.game_management_service.Model.Partie;
import org.example.game_management_service.Model.Joueur;
import org.example.game_management_service.Model.TypePartie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ParticipationServiceTest {

    @InjectMocks
    private ParticipationService participationService;

    @Mock
    private ParticipationDAO participationDAO;

    @Mock
    private PartieDAO partieDAO;

    @Mock
    private RestTemplate restTemplate;

    private Partie partie;
    private Joueur joueur;
    private ParticipationDTO participationDTO;

    @BeforeEach
    public void setUp() {
        partie = new Partie();
        partie.setId(1L);

        joueur = new Joueur();
        joueur.setId(1L);

        participationDTO = new ParticipationDTO();
        participationDTO.setJoueur(joueur);
        participationDTO.setScore(100);
        participationDTO.setVictoire(true);
    }

    @Test
    public void testEnregistrerParticipation() {
        when(partieDAO.findById(1L)).thenReturn(Optional.of(partie));
        when(participationDAO.save(any(Participation.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Participation participation = participationService.enregistrerParticipation(1L, participationDTO);

        assertEquals(1L, participation.getPartie().getId());
        assertEquals(1L, participation.getJoueur().getId());
        assertEquals(100, participation.getScore());
        assertEquals(true, participation.isVictoire());
    }
}
