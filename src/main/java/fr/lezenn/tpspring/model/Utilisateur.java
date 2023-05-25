package fr.lezenn.tpspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Utilisateur de l'application.
 */
@Data
@Builder
@AllArgsConstructor
public class Utilisateur {

    private long id;

    private String nomUtilisateur;
    private String adresseEmail;
    private String motDePasse;

    @Builder.Default
    private List<RoleUtilisateur> roles = List.of(RoleUtilisateur.VISITEUR);

    @Builder.Default
    private List<Avis> avis = List.of();

}
