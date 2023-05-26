package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.entites.Film;

import java.util.List;
import java.util.Optional;

/**
 * Services de gestion des films.
 */
public interface FilmServices {

    /**
     * Récupère la liste de tous les films.
     */
    List<Film> getAllFilms();

    /**
     * Récupère un film par son ID.
     * @param id ID du film.
     * @return Optional.of du film si trouvé, Optional.empty sinon.
     */
    Optional<Film> getFilmById(long id);

    /**
     * Sauvegarde un film en base.
     * @param film Film.
     * @return True si succès, False sinon.
     */
    boolean sauvegarder(Film film);

}
