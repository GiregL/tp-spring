package fr.lezenn.tpspring.controllers;

import fr.lezenn.tpspring.services.FilmServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller des pages principales.
 */
@Controller
@RequestMapping("/")
public class PageController {

    private final FilmServices filmServices;

    @Autowired
    public PageController(FilmServices filmServices) {
        this.filmServices = filmServices;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("films", this.filmServices.getAllFilms());
        return "pages/index/index";
    }

}
