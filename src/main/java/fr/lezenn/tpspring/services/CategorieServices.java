package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.model.CategorieFilm;

import java.util.List;
import java.util.Optional;

/**
 * Services de gestion des catégories.
 */
public interface CategorieServices {

    List<CategorieFilm> getAll();

    Optional<CategorieFilm> getById(long id);

    boolean delete(CategorieFilm categorieFilm);

    boolean update(CategorieFilm categorieFilm);

}
