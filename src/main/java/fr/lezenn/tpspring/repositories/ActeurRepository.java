package fr.lezenn.tpspring.repositories;

import fr.lezenn.tpspring.entites.Acteur;
import fr.lezenn.tpspring.entites.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository des acteurs d'un film.
 */
public interface ActeurRepository extends JpaRepository<Acteur, Long> {

    List<Acteur> getActeursByFilmJouesContains(Film film);

}
