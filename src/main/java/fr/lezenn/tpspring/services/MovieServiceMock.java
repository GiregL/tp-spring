package fr.lezenn.tpspring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import fr.lezenn.tpspring.model.CategorieFilm;
import fr.lezenn.tpspring.model.Film;
import fr.lezenn.tpspring.model.ParticipantFilm;

@Service
@Profile("dev")
public class MovieServiceMock implements FilmServices {
	// Attributs static pour gérer les valeurs à afficher
	private static List<Film> lstMovies;
	private static List<CategorieFilm> lstGenres;
	private static List<ParticipantFilm> lstParticipantFilms;

	private static final String[] genres = { "Animation", "Science-fiction", "Documentaire", "Action", "Comédie",
			"Drame" };

	public MovieServiceMock() {
		// Création de la liste des genres
		lstGenres = new ArrayList<>();
		for (int index = 0; index < genres.length; index++) {
			lstGenres.add(new CategorieFilm(index + 1, genres[index]));
		}

		// Création de la liste des ParticipantFilms
		lstParticipantFilms = new ArrayList<>();
		// 2 réalisateurs dont 1 pour 2 films
		ParticipantFilm stevenSpielberg = new ParticipantFilm(1, "Spielberg", "Steven");
		ParticipantFilm davidCronenberg = new ParticipantFilm(2, "Cronenberg", "David");
		lstParticipantFilms.add(stevenSpielberg);
		lstParticipantFilms.add(davidCronenberg);

		// 2 acteurs par film et l'un d'eux dans 2 films
		ParticipantFilm richardAttenborough = new ParticipantFilm(3, "Attenborough", "Richard");
		ParticipantFilm jeffGoldblum = new ParticipantFilm(4, "Goldblum", "Jeff");
		List<ParticipantFilm> actorsJurassicPark = new ArrayList<>();
		actorsJurassicPark.add(richardAttenborough);
		actorsJurassicPark.add(jeffGoldblum);
		lstParticipantFilms.addAll(actorsJurassicPark);

		ParticipantFilm geenaDavis = new ParticipantFilm(5, "Davis", "Geena");
		List<ParticipantFilm> actorsTheFly = new ArrayList<>();
		actorsTheFly.add(jeffGoldblum);
		actorsTheFly.add(geenaDavis);
		lstParticipantFilms.add(geenaDavis);

		ParticipantFilm markRylance = new ParticipantFilm(6, "Rylance", "Mark");
		ParticipantFilm rubyBarnhill = new ParticipantFilm(7, "Barnhill", "Ruby");
		List<ParticipantFilm> actorsTheBFG = new ArrayList<>();
		actorsTheBFG.add(markRylance);
		actorsTheBFG.add(rubyBarnhill);
		lstParticipantFilms.addAll(actorsTheBFG);

		// Création de la liste de films
		// 3 films
		lstMovies = new ArrayList<>();
		Film jurassicPark = Film.builder()
				.id(1)
				.nom("Jurassic Park")
				.dateParution(1993)
				.duree(128)
				.synopsis("Le film raconte l'histoire d'un milliardaire et son équipe de généticiens parvenant à ramener à la vie des dinosaures grâce au clonage.")
				.genre(lstGenres.get(1))
				.realisateur(stevenSpielberg)
				.acteurs(actorsJurassicPark)
				.build();
		lstMovies.add(jurassicPark);

		Film theFly = Film.builder()
				.id(2)
				.nom("The Fly")
				.dateParution(1986)
				.duree(95)
				.synopsis("Il s'agit de l'adaptation cinématographique de la nouvelle éponyme de l'auteur George Langelaan.")
				.genre(lstGenres.get(1))
				.realisateur(davidCronenberg)
				.acteurs(actorsTheFly)
				.build();
		lstMovies.add(theFly);

		Film theBFG = Film.builder()
				.id(3)
				.nom("The BFG")
				.dateParution(2016)
				.duree(117)
				.synopsis("Le Bon Gros Géant est un géant bien différent des autres habitants du Pays des Géants.")
				.genre(lstGenres.get(4))
				.realisateur(stevenSpielberg)
				.acteurs(actorsTheBFG)
				.build();
		lstMovies.add(theBFG);
	}

	@Override
	public List<Film> getAllFilms() {
		return lstMovies;
	}

	@Override
	public Optional<Film> getFilmById(long id) {
		for (Film movie : lstMovies) {
			if (movie.getId() == id) {
				return Optional.of(movie);
			}
		}
		return Optional.empty();
	}

	@Override
	public List<CategorieFilm> getCategories() {
		return lstGenres;
	}

	@Override
	public List<ParticipantFilm> getAllParticipants() {
		return lstParticipantFilms;
	}

	@Override
	public Optional<CategorieFilm> getCategorieById(long id) {
		for (CategorieFilm genre : lstGenres) {
			if (genre.getId() == id) {
				return Optional.of(genre);
			}
		}
		return Optional.empty();
	}

	@Override
	public Optional<ParticipantFilm> getParticipantById(long id) {
		for (ParticipantFilm participant : lstParticipantFilms) {
			if (participant.getId() == id) {
				return Optional.of(participant);
			}
		}
		return Optional.empty();
	}

	@Override
	public boolean saveFilm(Film movie) {
		return lstMovies.add(movie);
	}
}
