package org.example.game_management_service.DAO;

import org.example.game_management_service.Model.Participation;

import java.util.List;

public interface ParticipationDAO {
    Participation save(Participation participation);
    List<Participation> findByPartieId(Long partieId);
}
