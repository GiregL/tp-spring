package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.entites.Film;
import fr.lezenn.tpspring.entites.Realisateur;
import fr.lezenn.tpspring.repositories.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation des services de gestion des réalisateurs.
 * @see RealisateurServices
 */
@Service
public class RealisateurServicesImpl implements RealisateurServices {

    public final RealisateurRepository repository;

    @Autowired
    public RealisateurServicesImpl(RealisateurRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Realisateur> getRealisateurs() {
        return this.repository.findAll();
    }

}
