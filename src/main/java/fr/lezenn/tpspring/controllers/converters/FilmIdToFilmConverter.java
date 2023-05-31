package fr.lezenn.tpspring.controllers.converters;

import fr.lezenn.tpspring.entites.Film;
import fr.lezenn.tpspring.services.FilmServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Convertisseur d'ID vers film.
 */
@Component
public class FilmIdToFilmConverter implements Converter<Integer, Film> {

    private final FilmServices filmServices;

    @Autowired
    public FilmIdToFilmConverter(FilmServices filmServices) {
        this.filmServices = filmServices;
    }

    @Override
    public Film convert(Integer source) {
        var result = filmServices.getFilmById(source);

        return result.orElse(null);
    }
}
