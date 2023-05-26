package fr.lezenn.tpspring.config;

import fr.lezenn.tpspring.filtres.FiltreAuthentification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config de session.
 */
@Configuration
public class AuthentificationConfig {

    @Autowired
    private final FiltreAuthentification filtreAuthentification;

    public AuthentificationConfig(FiltreAuthentification filtreAuthentification) {
        this.filtreAuthentification = filtreAuthentification;
    }

    @Bean
    public FilterRegistrationBean<FiltreAuthentification> filtreAuthentificationConfig() {
        FilterRegistrationBean<FiltreAuthentification> result = new FilterRegistrationBean<>();
        result.setFilter(filtreAuthentification);
        result.addUrlPatterns("/", "/film/*", "/categories/*");
        return result;
    }

}
