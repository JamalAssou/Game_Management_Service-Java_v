package org.example.game_management_service.DAO;
import org.example.game_management_service.Model.TypePartie;

import java.util.Optional;


public interface TypePartieDAO {
    TypePartie save(TypePartie typePartie);
    Optional<TypePartie> findById(Long id);
}
