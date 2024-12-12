package org.example.game_management_service.Service;

import org.example.game_management_service.DAO.PartieDAO;
import org.example.game_management_service.DAO.TypePartieDAO;
import org.example.game_management_service.DTO.PartieDTO;
import org.example.game_management_service.Model.Partie;
import org.example.game_management_service.Model.TypePartie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PartieServiceTest {

    @InjectMocks
    private PartieService partieService;

    @Mock
    private PartieDAO partieDAO;

    @Mock
    private TypePartieDAO typePartieDAO;

    private PartieDTO partieDTO;
    private TypePartie typePartie;

    @BeforeEach
    public void setUp() {
        partieDTO = new PartieDTO();
        partieDTO.setDate(new Date());
        partieDTO.setScoreMax(100);

        typePartie = new TypePartie();
        typePartie.setId(1L);

        partieDTO.setTypePartieId(typePartie.getId());
    }

    @Test
    public void testCreerPartie() {
        when(typePartieDAO.findById(1L)).thenReturn(Optional.of(typePartie));
        when(partieDAO.save(any(Partie.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Partie partie = partieService.creerPartie(partieDTO);

        assertEquals(partieDTO.getDate(), partie.getDate());
        assertEquals(partieDTO.getScoreMax(), partie.getScoreMax());
        assertEquals(typePartie.getId(), partie.getTypePartie().getId());
    }

    @Test
    public void testObtenirPartie() {
        Partie partie = new Partie();
        partie.setId(1L);

        when(partieDAO.findById(1L)).thenReturn(Optional.of(partie));

        Partie result = partieService.obtenirPartie(1L);

        assertEquals(1L, result.getId());
    }

    @Test
    public void testObtenirToutesLesParties() {
        List<Partie> parties = new ArrayList<>();
        Partie partie1 = new Partie();
        partie1.setId(1L);
        Partie partie2 = new Partie();
        partie2.setId(2L);
        parties.add(partie1);
        parties.add(partie2);

        when(partieDAO.findAll()).thenReturn(parties);

        List<Partie> result = partieService.obtenirToutesLesParties();

        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals(2L, result.get(1).getId());
    }

    @Test
    public void testSupprimerPartie() {
        Partie partie = new Partie();
        partie.setId(1L);

        when(partieDAO.findById(1L)).thenReturn(Optional.of(partie));

        partieService.supprimerPartie(1L);

        // Vérifiez que la partie a été supprimée (vous pouvez ajouter des vérifications supplémentaires si nécessaire)
    }
}
