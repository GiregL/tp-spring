package fr.lezenn.tpspring.controllers.forms;

import fr.lezenn.tpspring.entites.Acteur;
import fr.lezenn.tpspring.entites.CategorieFilm;
import fr.lezenn.tpspring.entites.Realisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Données d'un formulaire d'ajout de formulaire.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AjouterFilmForm {

    @NotNull
    @Size(min = 1, max = 255)
    String nom;

    @NotNull
    int dateParution;

    @NotNull
    int duree;

    @NotNull
    @Size(min = 1)
    String synopsis;

    @NotNull
    CategorieFilm categorieFilm;

    @NotNull
    List<Acteur> acteurs;

    @NotNull
    Realisateur realisateur;

}
