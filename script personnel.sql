DROP DATABASE IF EXISTS personnel; 
CREATE DATABASE personnel ;
USE personnel;



DROP TABLE IF EXISTS Employe;
DROP TABLE IF EXISTS Ligue;

create table Employe (
id_employe BIGINT(8) , 
nomEmploye varchar(25),
prenomEmploye varchar(25) ,
password varchar(25) not null,
mail varchar(70) not null,
DateArrivee DATE,
DateDepart DATE, 
id_ligue BIGINT,

constraint PK_EMP primary key(id_employe)
)ENGINE=INNODB;
DESC Employe;

create table Ligue(
id_ligue  BIGINT(4), 
nom varchar(255) not null, 
administrateur varchar(50) not null, 


constraint PK_LIG primary key(id_ligue)
)ENGINE=INNODB;
DESC Ligue;

ALTER TABLE `Employe` ADD FOREIGN KEY (`id_ligue`) REFERENCES `ligue` (`id_ligue`);
ALTER TABLE `Ligue` ADD FOREIGN KEY (`id_ligue`) REFERENCES `Employe` (`id_employe`);
