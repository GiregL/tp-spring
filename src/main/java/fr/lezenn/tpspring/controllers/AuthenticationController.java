package fr.lezenn.tpspring.controllers;

import fr.lezenn.tpspring.controllers.forms.ConnexionForm;
import fr.lezenn.tpspring.entites.Utilisateur;
import fr.lezenn.tpspring.services.AuthentificationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpResponse;
import java.util.Optional;

/**
 * Controlleur d'authentification sur l'application.
 */
@Controller
@RequestMapping("/auth")
@SessionAttributes({"utilisateur"})
public class AuthenticationController {

    private final AuthentificationServices authentificationServices;

    @Autowired
    public AuthenticationController(AuthentificationServices authentificationServices) {
        this.authentificationServices = authentificationServices;
    }

    /**
     * Affichage de la page de connexion.
     * @param model
     * @return
     */
    @GetMapping("/connexion")
    public String afficherPageConnexion(Model model) {
        model.addAttribute("modelFormConnexion", new ConnexionForm());

        return "pages/auth/connexion";
    }

    @PostMapping("/connexion")
    public String connexion(@ModelAttribute("modelFormConnexion") ConnexionForm connexionForm, RedirectAttributes redirectAttributes) {

        Optional<Utilisateur> authentification = this.authentificationServices.authentifier(
                connexionForm.getEmail(),
                connexionForm.getMotDePasse()
        );

        if (authentification.isEmpty()) {
            redirectAttributes.addFlashAttribute(
                    "error",
                    "Echec de l'authentification, l'email ou le mot de passe sont incorrect."
            );
            return "redirect:/auth/connexion";
        }

        redirectAttributes.addFlashAttribute(
                "info",
                "Vous êtes authentifié."
        );
        return "redirect:/";
    }

    /**
     * Deconnexion de l'utilisateur.
     * @return Redirection vers la page index.
     */
    @GetMapping("/deconnexion")
    public String deconnexion(HttpSession session) {

        return "redirect:/";
    }

}
