package org.example.game_management_service.DAO;

import org.example.game_management_service.Model.Partie;
import org.example.game_management_service.Repository.PartieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PartieDAOImpl implements PartieDAO {
    @Autowired
    private PartieRepository partieRepository;

    @Override
    public Partie save(Partie partie) {
        return partieRepository.save(partie);
    }

    @Override
    public Optional<Partie> findById(Long id) {
        return partieRepository.findById(id);
    }

    @Override
    public List<Partie> findAll() {
        return partieRepository.findAll();
    }

    @Override
    public void delete(Partie partie) {
        partieRepository.delete(partie);
    }
}
