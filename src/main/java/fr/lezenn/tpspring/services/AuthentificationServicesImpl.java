package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.entites.Utilisateur;
import fr.lezenn.tpspring.repositories.UtilisateurRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Implémentation des services d'authentification.
 * @see AuthentificationServices
 *
 */
@Slf4j
@Service("authService")
public class AuthentificationServicesImpl implements AuthentificationServices {

    private final HttpSession sessionUtilisateur;
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public AuthentificationServicesImpl(HttpSession sessionUtilisateur,
                                        UtilisateurRepository utilisateurRepository) {
        this.sessionUtilisateur = sessionUtilisateur;
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public boolean isIdentifie() {
        Object utilisateur = sessionUtilisateur.getAttribute("utilisateur");
        return utilisateur instanceof Utilisateur; // Check null également.
    }

    @Override
    public Optional<Utilisateur> getUtilisateurConnecte() {
        if (!this.isIdentifie()) {
            return Optional.empty();
        }
        Utilisateur utilisateur = (Utilisateur) sessionUtilisateur.getAttribute("utilisateur");
        return Optional.of(utilisateur);
    }

    @Override
    public Optional<Utilisateur> authentifier(String email, String motDePasse) {
        Optional<Utilisateur> result = this.utilisateurRepository.getUtilisateurByAdresseEmailAndMotDePasse(email, motDePasse);

        if (result.isPresent()) {
            this.sessionUtilisateur.setAttribute("utilisateur", result);
            log.debug("Utilisateur authentifié.");
        } else {
            log.debug("Echec de l'authentification avec: '{}' '{}'", email, motDePasse);
        }

        return result;
    }

    @Override
    public void deconnexion() {
        log.debug("Deconnexion de l'utilisateur.");
        this.sessionUtilisateur.removeAttribute("utilisateur");
    }
}
