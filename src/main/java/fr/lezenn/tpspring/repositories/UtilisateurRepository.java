package fr.lezenn.tpspring.repositories;

import fr.lezenn.tpspring.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository des utilisateurs.
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
