package org.example.game_management_service.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Partie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private int scoreMax;

    @ManyToOne
    @JoinColumn(name = "id_hote")
    private Joueur hote;

    @OneToMany(mappedBy = "partie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Participation> participations;

    @ManyToOne
    @JoinColumn(name = "id_typePartie")
    private TypePartie typePartie;

}
