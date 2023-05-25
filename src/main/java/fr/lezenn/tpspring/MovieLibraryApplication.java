package fr.lezenn.tpspring;

import java.util.List;
import java.util.Optional;

import fr.lezenn.tpspring.model.Film;
import fr.lezenn.tpspring.controllers.FilmController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MovieLibraryApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MovieLibraryApplication.class, args);

		FilmController movieBean = context.getBean("movieBean", FilmController.class);

		// Affichage du premier film
		System.out.println("Le premier film est : ");
		Optional<Film> firstMovie = movieBean.findFilm(1);
		firstMovie.ifPresent(System.out::println);

		// Affichage de la liste des films
		System.out.println("\nTous les films : ");
		List<Film> lstMovies = movieBean.showAllFilms();
		for (Film movie : lstMovies) {
			System.out.println(movie);
		}
	}
}
