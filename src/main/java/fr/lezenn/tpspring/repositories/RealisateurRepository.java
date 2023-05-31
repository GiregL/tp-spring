package fr.lezenn.tpspring.repositories;

import fr.lezenn.tpspring.entites.Film;
import fr.lezenn.tpspring.entites.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository des réalisateurs de films.
 */
public interface RealisateurRepository extends JpaRepository<Realisateur, Long> {
}
