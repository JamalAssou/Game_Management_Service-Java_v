package org.example.game_management_service.DAO;

import org.example.game_management_service.Model.Partie;

import java.util.List;
import java.util.Optional;

public interface PartieDAO {
    Partie save(Partie partie);
    Optional<Partie> findById(Long id);
    List<Partie> findAll();
    void delete(Partie partie);
}
