package org.example.game_management_service.Repository;

import org.example.game_management_service.Model.TypePartie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePartieRepository extends JpaRepository<TypePartie, Long> {
}
