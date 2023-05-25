package fr.lezenn.tpspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Acteur d'un film
 */
@Data
@Builder
@AllArgsConstructor
public class ParticipantFilm {

    private long id;
    private String prenom;
    private String nom;

    @Builder.Default
    private List<Film> filmRealise = List.of();

    @Builder.Default
    private List<Film> filmJoues = List.of();

    public ParticipantFilm(long id, String prenom, String nom) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom + " " + prenom + "[id=" + id + "]";
    }
}
