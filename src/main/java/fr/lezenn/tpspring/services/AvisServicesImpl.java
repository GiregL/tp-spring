package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.entites.Avis;
import fr.lezenn.tpspring.entites.Film;
import fr.lezenn.tpspring.entites.Utilisateur;
import fr.lezenn.tpspring.repositories.AvisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implémentation des services de gestion des avis.
 */
@Slf4j
@Service
public class AvisServicesImpl implements AvisServices {

    private final AvisRepository avisRepository;
    private final FilmServices filmServices;
    private final UtilisateurServices utilisateurServices;

    @Autowired
    public AvisServicesImpl(AvisRepository avisRepository,
                            FilmServices filmServices,
                            UtilisateurServices utilisateurServices) {
        this.avisRepository = avisRepository;
        this.filmServices = filmServices;
        this.utilisateurServices = utilisateurServices;
    }

    @Override
    public boolean ajouterAvisFilm(Film film, Avis avis, Utilisateur utilisateur) {
        avis.setFilm(film);
        avis.setUtilisateur(utilisateur);

        utilisateur.getAvis().add(avis);
        film.getAvis().add(avis);

        try {
            this.avisRepository.save(avis);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }

        this.utilisateurServices.sauvegarder(utilisateur);
        this.filmServices.sauvegarder(film);

        return true;
    }
}
