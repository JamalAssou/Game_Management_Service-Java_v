package org.example.game_management_service.Repository;

import org.example.game_management_service.Model.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {
    List<Participation> findByPartieId(Long partieId);
}
