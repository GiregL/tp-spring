package fr.lezenn.tpspring.controllers;

import fr.lezenn.tpspring.controllers.forms.AjouterAvisFilmForm;
import fr.lezenn.tpspring.controllers.forms.AjouterFilmForm;
import fr.lezenn.tpspring.entites.Avis;
import fr.lezenn.tpspring.entites.Film;
import fr.lezenn.tpspring.entites.Utilisateur;
import fr.lezenn.tpspring.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

/**
 * Contoller de gestion des films.
 */
@Slf4j
@Controller
@RequestMapping("/film")
@SessionAttributes({"utilisateur"})
public class FilmController {

    private final FilmServices filmServices;
    private final CategorieServices categorieServices;
    private final ActeurServices acteurServices;
    private final RealisateurServices realisateurServices;
    private final AvisServices avisServices;

    @Autowired
    public FilmController(FilmServices filmServices,
                          CategorieServices categorieServices,
                          ActeurServices acteurServices,
                          RealisateurServices realisateurServices,
                          AvisServices avisServices) {
        this.filmServices = filmServices;
        this.categorieServices = categorieServices;
        this.acteurServices = acteurServices;
        this.realisateurServices = realisateurServices;
        this.avisServices = avisServices;
    }

    @Transactional
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
        model.addAttribute("realisateur", film.get().getRealisateur());
        model.addAttribute("acteurs", film.get().getActeurs());

        model.addAttribute("avis", new AjouterAvisFilmForm());

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

    @GetMapping("/ajouter")
    public String pageAjoutFilm(Model model) {

        var categories = this.categorieServices.getAll();
        var acteurs = this.acteurServices.getActeurs();
        var realisateurs = this.realisateurServices.getRealisateurs();

        model.addAttribute("categories", categories);
        model.addAttribute("acteurs", acteurs);
        model.addAttribute("realisateurs", realisateurs);

        model.addAttribute("film", new AjouterFilmForm());

        return "pages/film/ajouter";
    }

    @PostMapping("/ajouter")
    public String ajouterFilm(@ModelAttribute("film") @Valid AjouterFilmForm film,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "redirect:/film/ajouter";
        }

        Film result = Film.builder()
                .nom(film.getNom())
                .genre(film.getCategorieFilm())
                .dateParution(film.getDateParution())
                .duree(film.getDuree())
                .realisateur(film.getRealisateur())
                .acteurs(film.getActeurs())
                .synopsis(film.getSynopsis())
                .build();

        if (this.filmServices.sauvegarder(result)) {
            return "redirect:/film/" + result.getId();
        } else {
            return "redirect:/film/ajouter";
        }
    }

    @PostMapping("/avis/new")
    public String ajouterAvisFilm(@ModelAttribute("avis") @Valid AjouterAvisFilmForm avisForm,
                                  BindingResult bindingResult,
                                  HttpSession session) {
        if (bindingResult.hasErrors()) {
            log.error(bindingResult.getAllErrors().toString());
            return "redirect:/";
        }

        Utilisateur utilisateur = ((Optional<Utilisateur>) session.getAttribute("utilisateur")).get();

        Avis avis = Avis.builder()
                .film(avisForm.getFilm())
                .commentaire(avisForm.getCommentaire())
                .note(avisForm.getNote())
                .utilisateur(utilisateur)
                .build();

        this.avisServices.ajouterAvisFilm(avis);
        return "redirect:/film/" + avisForm.getFilm().getId();
    }
}
