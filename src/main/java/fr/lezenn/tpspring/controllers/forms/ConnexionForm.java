package fr.lezenn.tpspring.controllers.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO du formulaire de connexion.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnexionForm {

    private String email;
    private String motDePasse;

}
