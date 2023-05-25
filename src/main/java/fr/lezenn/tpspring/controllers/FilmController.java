package fr.lezenn.tpspring.controllers;

import fr.lezenn.tpspring.model.Film;
import fr.lezenn.tpspring.services.CategorieServices;
import fr.lezenn.tpspring.services.FilmServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

/**
 * Contoller de gestion des films.
 */
@Controller
@RequestMapping("/film")
public class FilmController {

    private final FilmServices filmServices;
    private final CategorieServices categorieServices;

    @Autowired
    public FilmController(FilmServices filmServices,
                          CategorieServices categorieServices) {
        this.filmServices = filmServices;
        this.categorieServices = categorieServices;
    }

    @GetMapping("/{id}")
    public String detailsFilm(@PathVariable Integer id, Model model) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        var film = filmServices.getFilmById(id);

        // Redirection vers une 404
        if (film.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le film demandé n'existe pas.");
        }

        model.addAttribute("film", film.get());
        model.addAttribute("categories", categorieServices.getAll());

        return "pages/film/details";
    }

    @PostMapping("/{id}")
    public String modifierFilm(@ModelAttribute("film") Film film) {
        if (film == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        this.filmServices.sauvegarder(film);

        return "redirect:/film/" + film.getId();
    }

}
