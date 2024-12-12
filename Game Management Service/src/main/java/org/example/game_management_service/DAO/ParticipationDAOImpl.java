package org.example.game_management_service.DAO;


import org.example.game_management_service.Model.Participation;
import org.example.game_management_service.Repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParticipationDAOImpl implements ParticipationDAO {
    @Autowired
    private ParticipationRepository participationRepository;

    @Override
    public Participation save(Participation participation) {
        return participationRepository.save(participation);
    }

    @Override
    public List<Participation> findByPartieId(Long partieId) {
        return participationRepository.findByPartieId(partieId);
    }
}
