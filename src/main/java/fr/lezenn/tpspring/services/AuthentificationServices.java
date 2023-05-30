package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.entites.Utilisateur;

import java.util.Optional;

/**
 * Services d'authentification
 */
public interface AuthentificationServices {

    /**
     * Service de vérification que l'utilisateur soit authentifié.
     */
    boolean isIdentifie();

    /**
     * Service de récupération de l'utilisateur courant s'il est authentifié.
     * @return Empty si l'utilisateur n'est pas authentifié.
     */
    Optional<Utilisateur> getUtilisateurConnecte();

    /**
     * Service d'authentification de l'utilisateur.
     * @param email Email fourni par l'utilisateur.
     * @param motDePasse Mot de passe fourni par l'utilisateur.
     * @return Retourne l'utilisateur authentifié ou empty s'il ne l'est pas.
     */
    Optional<Utilisateur> authentifier(String email, String motDePasse);

}
