package fr.lezenn.tpspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Avis d'un utilisateur sur un film.
 */
@Data
@Builder
@AllArgsConstructor
public class Avis {

    private Long id;
    private int note;
    private String commentaire;

    private Utilisateur utilisateur;
    private Film film;

}
