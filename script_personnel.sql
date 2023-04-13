DROP DATABASE IF EXISTS personnel;
CREATE DATABASE personnel;
USE personnel;

DROP TABLE IF EXISTS Employe;
DROP TABLE IF EXISTS Ligue;

CREATE TABLE Employe (
id_employe BIGINT(8) auto_increment not null,
nomEmploye VARCHAR(25),
prenomEmploye VARCHAR(25),
password VARCHAR(25) NOT NULL,
mail VARCHAR(70) NOT NULL,
DateArrivee DATE,
DateDepart DATE,
id_ligue BIGINT,
CONSTRAINT PK_EMP PRIMARY KEY(id_employe)
) ENGINE=InnoDB;

CREATE TABLE Ligue (
id_ligue BIGINT(4) auto_increment NOT null ,
nom VARCHAR(255) NOT NULL,
administrateur BIGINT(50),
CONSTRAINT PK_LIG PRIMARY KEY(id_ligue)
) ENGINE=InnoDB;

ALTER TABLE Employe add FOREIGN KEY FK_EMP_LIG (id_ligue) REFERENCES Ligue (id_ligue);