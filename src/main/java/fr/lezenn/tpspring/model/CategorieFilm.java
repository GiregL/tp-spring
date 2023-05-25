package fr.lezenn.tpspring.model;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Catégorie de film
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories", uniqueConstraints = @UniqueConstraint(columnNames = {"nom"}))
public class CategorieFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "nom")
    @NotNull
    private String nom;

    @Builder.Default
    @OneToMany(mappedBy = "genre")
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
