package fr.lezenn.tpspring.repositories;

import fr.lezenn.tpspring.entites.CategorieFilm;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository des catégories de films.
 */
public interface CategorieRepository extends JpaRepository<CategorieFilm, Long> {
}
