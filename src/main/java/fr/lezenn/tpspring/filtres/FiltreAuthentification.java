package fr.lezenn.tpspring.filtres;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filtre d'authentification de l'utilisateur.
 */
@Slf4j
@Component
@SessionAttributes({"utilisateur"})
public class FiltreAuthentification extends OncePerRequestFilter {

    @Autowired
    private HttpSession session;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.debug("Execution du filtre d'authentification.");

        if (session.getAttribute("utilisateur") == null) {
            log.debug("Redirection vers la page de connexion.");
            response.sendRedirect("/auth/connexion");
            return;
        }

        log.debug("Utilisateur authentifié.");
        chain.doFilter(request, response);
    }
}
