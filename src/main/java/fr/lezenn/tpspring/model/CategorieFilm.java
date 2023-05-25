package fr.lezenn.tpspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Catégorie de film
 */
@Data
@Builder
@AllArgsConstructor
public class CategorieFilm {

    private long id;
    private String nom;

    @Builder.Default
    private List<Film> films = List.of();

    public CategorieFilm(long id, String nom) {
        this.id = id;
        this.nom = nom;
        this.films = List.of();
    }

    @Override
    public String toString() {
        return nom + "[id=" + id + "]";
    }
}
