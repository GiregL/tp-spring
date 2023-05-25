package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.model.ParticipantFilm;
import fr.lezenn.tpspring.model.CategorieFilm;
import fr.lezenn.tpspring.model.Film;

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
     * Récupère la liste des catégories de films.
     */
    List<CategorieFilm> getCategories();

    /**
     * Récupère une catégorie par son ID.
     * @param id ID de la catégorie.
     * @return Optional.of de la catégorie si trouvée, empty sinon.
     */
    Optional<CategorieFilm> getCategorieById(long id);

    /**
     * Récupère la liste des participants d'un film.
     */
    List<ParticipantFilm> getAllParticipants();

    /**
     * Récupère un participant par son ID.
     * @param id ID de la catégorie.
     * @return Optional.of du participant si trouvé, empty sinon.
     */
    Optional<ParticipantFilm> getParticipantById(long id);

    /**
     * Sauvegarde un film sur l'application.
     * @param film Film à sauvegarder.
     * @return True si succès, false sinon.
     */
    boolean saveFilm(Film film);

}
