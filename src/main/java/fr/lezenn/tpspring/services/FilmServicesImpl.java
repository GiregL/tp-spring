package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.model.CategorieFilm;
import fr.lezenn.tpspring.model.Film;
import fr.lezenn.tpspring.model.ParticipantFilm;
import fr.lezenn.tpspring.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServicesImpl implements FilmServices {

    private final FilmRepository repository;

    @Autowired
    public FilmServicesImpl(FilmRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Film> getAllFilms() {
        return repository.findAll();
    }

    @Override
    public Optional<Film> getFilmById(long id) {
        return this.repository.findById(id);
    }

    @Override
    public boolean sauvegarder(Film film) {
        if (film == null) {
            return false;
        }

        this.repository.save(film);
        return true;
    }
}
