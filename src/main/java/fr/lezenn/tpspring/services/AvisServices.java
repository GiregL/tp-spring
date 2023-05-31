package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.entites.Avis;
import fr.lezenn.tpspring.entites.Film;
import fr.lezenn.tpspring.entites.Utilisateur;

/**
 * Services de gestion des avis de films.
 */
public interface AvisServices {

    boolean ajouterAvisFilm(Avis avis);

}
