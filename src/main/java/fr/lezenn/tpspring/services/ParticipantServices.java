package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.entites.Film;
import fr.lezenn.tpspring.entites.ParticipantFilm;

import java.util.List;
import java.util.Optional;

/**
 * Services de gestion des participants.
 */
public interface ParticipantServices {

    List<ParticipantFilm> getParticipants();

    Optional<ParticipantFilm> getRealisateurFilm(Film film);

    List<ParticipantFilm> getActeursFilm(Film film);

}
