package fr.lezenn.tpspring.services;

import fr.lezenn.tpspring.model.CategorieFilm;
import fr.lezenn.tpspring.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation des services de gestion des catégories de films.
 * @see CategorieServices
 */
@Service
public class CategorieServicesImpl implements CategorieServices {

    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieServicesImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public List<CategorieFilm> getAll() {
        return this.categorieRepository.findAll();
    }

    @Override
    public Optional<CategorieFilm> getById(long id) {
        return this.categorieRepository.findById(id);
    }

    @Override
    public boolean delete(CategorieFilm categorieFilm) {
        if (categorieFilm == null) {
            return false;
        }

        this.categorieRepository.delete(categorieFilm);
        return true;
    }

    @Override
    public boolean update(CategorieFilm categorieFilm) {
        if (categorieFilm == null) {
            return false;
        }

        this.categorieRepository.save(categorieFilm);
        return true;
    }
}
