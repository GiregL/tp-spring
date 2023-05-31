package fr.lezenn.tpspring.entites;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Utilisateur de l'application.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateurs",
    uniqueConstraints = @UniqueConstraint(columnNames = {"adresse_email"}))
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom_utilisateur")
    private String nomUtilisateur;

    @Column(name = "adresse_email")
    @NotNull
    private String adresseEmail;

    @Column(name = "mot_de_passe")
    @NotNull
    private String motDePasse;

    @Builder.Default
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection(targetClass = RoleUtilisateur.class)
    @CollectionTable(
            name = "roles_utilisateurs",
            joinColumns = @JoinColumn(name = "id")
    )
    @Column(name = "role")
    private List<RoleUtilisateur> roles = List.of(RoleUtilisateur.VISITEUR);

    @Builder.Default
    @OneToMany
    private List<Avis> avis = List.of();

}
