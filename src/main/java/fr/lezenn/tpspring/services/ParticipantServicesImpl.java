package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.entites.Film;
import fr.lezenn.tpspring.entites.ParticipantFilm;
import fr.lezenn.tpspring.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

/**
 *
 */
@Service
public class ParticipantServicesImpl implements ParticipantServices {

    private final ParticipantRepository participantRepository;
    private final EntityManager entityManager;

    @Autowired
    public ParticipantServicesImpl(ParticipantRepository participantRepository,
                                   EntityManager entityManager) {
        this.participantRepository = participantRepository;
        this.entityManager = entityManager;
    }

    public List<ParticipantFilm> getParticipants() {
        return this.participantRepository.findAll();
    }

    @Override
    public Optional<ParticipantFilm> getRealisateurFilm(Film film) {
        Query query = this.entityManager.createNamedQuery("getRealisateurFilm");
        query.setParameter(1, film.getId());
        List<ParticipantFilm> participants = (List<ParticipantFilm>) query.getResultList();
        if (participants.size() == 1) {
            return Optional.of(participants.get(0));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<ParticipantFilm> getActeursFilm(Film film) {
        Query query = this.entityManager.createNamedQuery("getActeursFilm");
        query.setParameter(1, film.getId());
        return (List<ParticipantFilm>) query.getResultList();
    }
}
