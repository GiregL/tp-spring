package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.entites.Avis;
import fr.lezenn.tpspring.repositories.AvisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implémentation des services de gestion des avis.
 */
@Slf4j
@Service
public class AvisServicesImpl implements AvisServices {

    private final AvisRepository avisRepository;

    @Autowired
    public AvisServicesImpl(AvisRepository avisRepository) {
        this.avisRepository = avisRepository;
    }

    @Override
    public boolean ajouterAvisFilm(Avis avis) {
        try {
            this.avisRepository.save(avis);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
        return true;
    }
}
