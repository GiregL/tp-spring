CREATE TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE participants (
    id INT PRIMARY KEY AUTO_INCREMENT,
    prenom VARCHAR(255) NOT NULL,
    nom VARCHAR(255) NOT NULL
);

CREATE TABLE utilisateurs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom_utilisateur VARCHAR(255) NOT NULL,
    adresse_email VARCHAR(255) NOT NULL UNIQUE,
    mot_de_passe VARCHAR(255) NOT NULL
);

CREATE TABLE roles_utilisateurs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(128) NOT NULL
);

CREATE TABLE films (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255) NOT NULL,
    date_parution INT NOT NULL,
    duree INT NOT NULL,
    synopsis TEXT NOT NULL,

    genre INT NOT NULL,
    realisateur INT NOT NULL
);

CREATE TABLE acteurs_films (
    id_film INT NOT NULL,
    id_acteur INT NOT NULL,

    CONSTRAINT PK_id_film_id_acteur PRIMARY KEY (id_film, id_acteur),
    CONSTRAINT FK_id_film FOREIGN KEY (id_film) REFERENCES films (id),
    CONSTRAINT FK_id_acteur FOREIGN KEY (id_acteur) REFERENCES participants (id)
);

CREATE TABLE avis (
    id INT PRIMARY KEY AUTO_INCREMENT,
    note INT NOT NULL,
    commentaire VARCHAR(256) NOT NULL,

    utilisateur INT NOT NULL,
    film INT NOT NULL,

    CONSTRAINT FK_avis_utilisateur FOREIGN KEY (utilisateur) REFERENCES utilisateurs (id),
    CONSTRAINT FK_avis_film FOREIGN KEY (film) REFERENCES films (id)
);