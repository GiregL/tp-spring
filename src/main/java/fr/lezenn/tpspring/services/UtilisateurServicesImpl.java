package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.entites.Utilisateur;
import fr.lezenn.tpspring.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implémentation des services de gestion des utilisateurs.
 */
@Service
public class UtilisateurServicesImpl implements UtilisateurServices {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServicesImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public void sauvegarder(Utilisateur utilisateur) {
        this.utilisateurRepository.save(utilisateur);
    }
}
