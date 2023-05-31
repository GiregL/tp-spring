package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.entites.Film;
import fr.lezenn.tpspring.entites.Acteur;

import java.util.List;
import java.util.Optional;

/**
 * Services de gestion des participants.
 */
public interface ActeurServices {

    List<Acteur> getActeurs();

    List<Acteur> getActeursFilm(Film film);

}
