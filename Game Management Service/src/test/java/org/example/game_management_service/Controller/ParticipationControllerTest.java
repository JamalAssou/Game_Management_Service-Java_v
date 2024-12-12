package org.example.game_management_service.Controller;

import org.example.game_management_service.DTO.ParticipationDTO;
import org.example.game_management_service.Model.Joueur;
import org.example.game_management_service.Model.Participation;
import org.example.game_management_service.Service.ParticipationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ParticipationControllerTest {

    @InjectMocks
    private ParticipationController participationController;

    @Mock
    private ParticipationService participationService;

    private MockMvc mockMvc;

    private ParticipationDTO participationDTO;
    private Joueur joueur;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(participationController).build();

        joueur = new Joueur();
        joueur.setId(1L);

        participationDTO = new ParticipationDTO();
        participationDTO.setJoueur(joueur);
        participationDTO.setScore(100);
        participationDTO.setVictoire(true);
    }

    @Test
    public void testEnregistrerParticipation() throws Exception {
        Participation participation = new Participation();
        participation.setId(1L);
        participation.setJoueur(joueur);
        participation.setScore(100);
        participation.setVictoire(true);

        when(participationService.enregistrerParticipation(any(Long.class), any(ParticipationDTO.class)))
                .thenReturn(participation);

        mockMvc.perform(post("/parties/1/participations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"joueur\":{\"id\":1},\"score\":100,\"victoire\":true}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.joueur.id").value(1))
                .andExpect(jsonPath("$.score").value(100))
                .andExpect(jsonPath("$.victoire").value(true));
    }
}
