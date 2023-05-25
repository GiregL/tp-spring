package fr.lezenn.tpspring.config;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * Thymeleaf Config
 */
@Configuration
public class ThymeleafConfig {

//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Bean
//    @Profile("dev")
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//        resolver.setApplicationContext(this.applicationContext);
//        resolver.setPrefix("/templates/");
//        resolver.setSuffix(".html");
//        resolver.setTemplateMode(TemplateMode.HTML);
//        resolver.setCacheable(false);
//        return resolver;
//    }
//
//    @Bean
//    @Profile("prod")
//    public SpringResourceTemplateResolver templateResolverProd() {
//        var resolver = templateResolver();
//        resolver.setCacheable(true);
//        return resolver;
//    }
//
//    /**
//     * Configuration du moteur de templates Thymeleaf.
//     */
//    @Bean
//    public SpringTemplateEngine moteurTemplate() {
//        SpringTemplateEngine engine = new SpringTemplateEngine();
//        engine.addDialect(new LayoutDialect());
//        return engine;
//    }

}
