package fr.lezenn.tpspring.repositories;

import fr.lezenn.tpspring.entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository des utilisateurs.
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Optional<Utilisateur> getUtilisateurByAdresseEmailAndMotDePasse(String adresseEmail, String motDePasse);

}
