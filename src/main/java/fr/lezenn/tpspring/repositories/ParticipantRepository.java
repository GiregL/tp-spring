package fr.lezenn.tpspring.repositories;

import fr.lezenn.tpspring.entites.Film;
import fr.lezenn.tpspring.entites.ParticipantFilm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository des participants d'un film.
 */
public interface ParticipantRepository extends JpaRepository<ParticipantFilm, Long> {
}
