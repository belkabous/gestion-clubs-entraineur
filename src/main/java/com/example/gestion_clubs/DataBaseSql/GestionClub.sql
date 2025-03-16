CREATE DATABASE GestionClub;
       USE GestionClub;

    CREATE TABLE membre(
        id_membre int(15) PRIMARY KEY AUTO_INCREMENT,
        nom_membre VARCHAR(100),
        sport_pratiquee VARCHAR(200)
    );

    CREATE TABLE entraineur(
        id_entraineur int(15) PRIMARY KEY AUTO_INCREMENT,
        nom_entraineur VARCHAR(100),
        specialite VARCHAR(200)
    );

    CREATE TABLE seance(
        PRIMARY KEY(id_membre,id_entraineur),
        id_membre int,
        id_entraineur int,
        date_heure TIMESTAMP,

        FOREIGN KEY (id_membre) REFERENCES membre(id_membre),
        FOREIGN KEY (id_entraineur) REFERENCES entraineur(id_entraineur),
    );

    CREATE TABLE utilisateur(
        id_utilisateur int(15) PRIMARY KEY AUTO_INCREMENT,
        nom_utilisateur VARCHAR(100),
        role ENUM('ADMINISTRATEUR','ENTRAINEUR','MEMBRE'),
        password VARCHAR(30)

    );
