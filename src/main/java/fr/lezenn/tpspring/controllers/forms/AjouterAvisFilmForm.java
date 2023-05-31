package fr.lezenn.tpspring.controllers.forms;

import fr.lezenn.tpspring.entites.Film;
import fr.lezenn.tpspring.entites.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Représentation du formulaire d'ajout d'avis sur un film.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AjouterAvisFilmForm {

    @NotNull
    private Film film;

    @NotNull
    @Min(0)
    @Max(5)
    private int note;

    @NotNull
    @Size(max = 256)
    private String commentaire;

}
