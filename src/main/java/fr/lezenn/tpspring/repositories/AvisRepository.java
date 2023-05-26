package fr.lezenn.tpspring.repositories;

import fr.lezenn.tpspring.entites.Avis;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository des avis de films.
 */
public interface AvisRepository extends JpaRepository<Avis, Long> {
}
