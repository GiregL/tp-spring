package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.entites.Film;
import fr.lezenn.tpspring.entites.ParticipantFilm;
import fr.lezenn.tpspring.repositories.FilmRepository;
import fr.lezenn.tpspring.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Service
public class ParticipantServicesImpl implements ParticipantServices {

    private final ParticipantRepository participantRepository;
    private final FilmRepository filmRepository;

    @Autowired
    public ParticipantServicesImpl(ParticipantRepository participantRepository, FilmRepository filmRepository) {
        this.participantRepository = participantRepository;
        this.filmRepository = filmRepository;
    }

    public List<ParticipantFilm> getParticipants() {
        return this.participantRepository.findAll();
    }

    @Override
    public Optional<ParticipantFilm> getRealisateurFilm(Film film) {
        return this.participantRepository.getByFilmJouesIs(film);
    }

    @Override
    public List<ParticipantFilm> getActeursFilm(Film film) {
        return null;
    }
}
