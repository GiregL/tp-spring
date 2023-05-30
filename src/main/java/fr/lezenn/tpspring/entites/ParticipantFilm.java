package fr.lezenn.tpspring.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Acteur d'un film
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "participants")
@NamedQueries({
        @NamedQuery(
                name = "getRealisateurFilm",
                query = "SELECT p FROM ParticipantFilm p, Film f WHERE f.realisateur.id = p.id AND f.id = ?1"
        ),
        @NamedQuery(
                name = "getActeursFilm",
                query = "SELECT p FROM ParticipantFilm p, Film f WHERE f.realisateur.id <> p.id AND f.id = ?1"
        )
})
public class ParticipantFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Builder.Default
    @OneToMany(mappedBy = "realisateur")
    private List<Film> filmRealise = List.of();

    @Builder.Default
    @ManyToMany(mappedBy = "acteurs")
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
