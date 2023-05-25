package fr.lezenn.tpspring.controllers;

import fr.lezenn.tpspring.model.Film;
import fr.lezenn.tpspring.services.FilmServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

/**
 * Contoller de gestion des films.
 */
@Controller("movieBean")
public class FilmController {

    private final FilmServices filmServices;

    @Autowired
    public FilmController(FilmServices filmServices) {
        this.filmServices = filmServices;
    }

    /**
     * Affiche la liste des films.
     */
    public List<Film> showAllFilms() {
        return this.filmServices.getAllFilms();
    }

    /**
     * Affiche un film par son ID, s'il existe.
     */
    public Optional<Film> findFilm(long id) {
        return this.filmServices.getFilmById(id);
    }

}
