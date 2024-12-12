package org.example.game_management_service.DAO;

import org.example.game_management_service.Model.TypePartie;
import org.example.game_management_service.Repository.TypePartieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TypePartieDAOImpl implements TypePartieDAO {
    @Autowired
    private TypePartieRepository typePartieRepository;

    @Override
    public TypePartie save(TypePartie typePartie) {
        return typePartieRepository.save(typePartie);
    }

    @Override
    public Optional<TypePartie> findById(Long id) {
        return typePartieRepository.findById(id);
    }
}
