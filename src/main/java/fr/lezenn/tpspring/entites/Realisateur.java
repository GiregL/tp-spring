package fr.lezenn.tpspring.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "realisateurs")
public class Realisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Builder.Default
    @OneToMany(mappedBy = "realisateur")
    private List<Film> filmRealise = List.of();

    public Realisateur(long id, String prenom, String nom) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom + " " + prenom + "[id=" + id + "]";
    }

}
