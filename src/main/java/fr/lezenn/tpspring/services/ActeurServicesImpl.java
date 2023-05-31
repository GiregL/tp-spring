package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.entites.Film;
import fr.lezenn.tpspring.entites.Acteur;
import fr.lezenn.tpspring.repositories.ActeurRepository;
import fr.lezenn.tpspring.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 *
 */
@Service
public class ActeurServicesImpl implements ActeurServices {

    private final ActeurRepository acteurRepository;

    @Autowired
    public ActeurServicesImpl(ActeurRepository acteurRepository) {
        this.acteurRepository = acteurRepository;
    }

    public List<Acteur> getActeurs() {
        return this.acteurRepository.findAll();
    }

    @Override
    public List<Acteur> getActeursFilm(Film film) {

        if (film == null) return Collections.emptyList();

        return this.acteurRepository.getActeursByFilmJouesContains(film);
    }
}
