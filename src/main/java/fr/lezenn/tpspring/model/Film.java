package fr.lezenn.tpspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Film
 */
@Data
@Builder
@AllArgsConstructor
public class Film {

    private long id;

    private String nom;
    private int dateParution;
    private int duree; // En minutes
    private String synopsis;

    private CategorieFilm genre;
    private ParticipantFilm realisateur;

    @Builder.Default
    private List<ParticipantFilm> acteurs = List.of();

    @Builder.Default
    private List<Avis> avis = List.of();


    @Override
    public String toString() {
        return "Film [id=" + id + "]\n" +
                "\t\tTitre: " + this.nom + "\n" +
                "\t\tSynopsis: " + this.synopsis + "\n" +
                "\t\tRéalisateur: " + this.realisateur + "\n" +
                "\t\tActeurs: " + this.acteurs + "\n" +
                "\t\tGenre: " + this.genre + "\n";
    }
}
