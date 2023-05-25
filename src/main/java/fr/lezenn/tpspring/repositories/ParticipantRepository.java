package fr.lezenn.tpspring.repositories;

import fr.lezenn.tpspring.model.ParticipantFilm;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository des participants d'un film.
 */
public interface ParticipantRepository extends JpaRepository<ParticipantFilm, Long> {
}
