ALTER TABLE films DROP COLUMN realisateur;

ALTER TABLE acteurs_films DROP CONSTRAINT FK_id_acteur;
ALTER TABLE acteurs_films DROP CONSTRAINT FK_id_film;
DROP TABLE IF EXISTS acteurs_films;

DROP TABLE IF EXISTS participants;

CREATE TABLE acteurs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    prenom VARCHAR(255) NOT NULL,
    nom VARCHAR(255) NOT NULL
);

CREATE TABLE realisateurs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    prenom VARCHAR(255) NOT NULL,
    nom VARCHAR(255) NOT NULL
);

ALTER TABLE films ADD COLUMN realisateur INT NOT NULL;
ALTER TABLE films ADD CONSTRAINT FK_films_realisateur FOREIGN KEY films (realisateur) REFERENCES realisateurs (id);

CREATE TABLE IF NOT EXISTS acteurs_films (
    id_film INT NOT NULL,
    id_acteur INT NOT NULL,

    CONSTRAINT PK_id_film_id_acteur PRIMARY KEY (id_film, id_acteur),
    CONSTRAINT FK_id_film FOREIGN KEY (id_film) REFERENCES films (id),
    CONSTRAINT FK_id_acteur FOREIGN KEY (id_acteur) REFERENCES acteurs (id)
);
