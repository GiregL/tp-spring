package fr.lezenn.tpspring.controllers;

import fr.lezenn.tpspring.services.CategorieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Controller des catégories de films.
 */
@Controller
@RequestMapping("/categories")
@SessionAttributes({"utilisateur"})
public class CategorieController {

    private final CategorieServices categorieServices;

    @Autowired
    public CategorieController(CategorieServices categorieServices) {
        this.categorieServices = categorieServices;
    }

    /**
     * Affiche une page avec toutes les catégories de films.
     */
    @GetMapping
    public String afficherCategories() {
        return "pages/categories/index";
    }

}
