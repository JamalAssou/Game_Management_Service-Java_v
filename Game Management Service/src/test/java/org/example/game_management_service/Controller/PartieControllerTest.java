package org.example.game_management_service.Controller;

import org.example.game_management_service.DTO.PartieDTO;
import org.example.game_management_service.Model.Partie;
import org.example.game_management_service.Model.TypePartie;
import org.example.game_management_service.Service.PartieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class PartieControllerTest {

    @InjectMocks
    private PartieController partieController;

    @Mock
    private PartieService partieService;

    private MockMvc mockMvc;

    private PartieDTO partieDTO;
    private TypePartie typePartie;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(partieController).build();

        partieDTO = new PartieDTO();
        partieDTO.setDate(new Date());
        partieDTO.setScoreMax(100);

        typePartie = new TypePartie();
        typePartie.setId(1L);

        partieDTO.setTypePartieId(typePartie.getId());
    }

    @Test
    public void testCreerPartie() throws Exception {
        Partie partie = new Partie();
        partie.setId(1L);
        partie.setDate(partieDTO.getDate());
        partie.setScoreMax(partieDTO.getScoreMax());
        partie.setTypePartie(typePartie);

        when(partieService.creerPartie(any(PartieDTO.class))).thenReturn(partie);

        mockMvc.perform(post("/parties")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"date\":\"2023-10-01\",\"scoreMax\":100,\"typePartieId\":1}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.scoreMax").value(100));
    }

    @Test
    public void testObtenirPartie() throws Exception {
        Partie partie = new Partie();
        partie.setId(1L);

        when(partieService.obtenirPartie(1L)).thenReturn(partie);

        mockMvc.perform(get("/parties/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testObtenirToutesLesParties() throws Exception {
        List<Partie> parties = new ArrayList<>();
        Partie partie1 = new Partie();
        partie1.setId(1L);
        Partie partie2 = new Partie();
        partie2.setId(2L);
        parties.add(partie1);
        parties.add(partie2);

        when(partieService.obtenirToutesLesParties()).thenReturn(parties);

        mockMvc.perform(get("/parties"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));
    }

    @Test
    public void testSupprimerPartie() throws Exception {
        mockMvc.perform(delete("/parties/1"))
                .andExpect(status().isNoContent());
    }
}
