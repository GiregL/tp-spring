package fr.lezenn.tpspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Film
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date_parution")
    private int dateParution;

    @Column(name = "duree")
    private int duree; // En minutes

    @Column(name = "synopsis")
    private String synopsis;

    @ManyToOne
    @JoinColumn(name = "genre", nullable = false)
    private CategorieFilm genre;

    @ManyToOne
    @JoinColumn(name = "realisateur", nullable = false)
    private ParticipantFilm realisateur;

    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "acteurs_films",
            joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "id_acteur")
    )
    private List<ParticipantFilm> acteurs = List.of();

    @Builder.Default
    @OneToMany(mappedBy = "film")
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
