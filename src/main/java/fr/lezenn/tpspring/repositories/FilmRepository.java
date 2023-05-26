package fr.lezenn.tpspring.repositories;

import fr.lezenn.tpspring.entites.Film;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository des films.
 */
public interface FilmRepository extends JpaRepository<Film, Long> {
}
