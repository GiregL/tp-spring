package fr.lezenn.tpspring.controllers;

import fr.lezenn.tpspring.entites.Film;
import fr.lezenn.tpspring.services.CategorieServices;
import fr.lezenn.tpspring.services.FilmServices;
import fr.lezenn.tpspring.services.ParticipantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * Contoller de gestion des films.
 */
@Controller
@RequestMapping("/film")
@SessionAttributes({"utilisateur"})
public class FilmController {

    private final FilmServices filmServices;
    private final CategorieServices categorieServices;
    private final ParticipantServices participantServices;

    @Autowired
    public FilmController(FilmServices filmServices,
                          CategorieServices categorieServices,
                          ParticipantServices participantServices) {
        this.filmServices = filmServices;
        this.categorieServices = categorieServices;
        this.participantServices = participantServices;
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
        model.addAttribute("participants", this.participantServices.getParticipants());

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
