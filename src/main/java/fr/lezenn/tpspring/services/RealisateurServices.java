package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.entites.Film;
import fr.lezenn.tpspring.entites.Realisateur;

import java.util.List;
import java.util.Optional;

/**
 * Services de gestion des réalisateurs
 */
public interface RealisateurServices {

    List<Realisateur> getRealisateurs();

}
