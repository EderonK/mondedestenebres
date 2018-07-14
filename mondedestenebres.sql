-- Supprimer une base de données
DROP DATABASE IF EXISTS mondedestenebres;
-- Créer une base de données
CREATE DATABASE  mondedestenebres;
-- Selection de la base de donnée courante
USE mondedestenebres;

-- Supprimer la table
DROP TABLE IF EXISTS vampire;

-- Créer une table 
CREATE TABLE vampire
(
  id int AUTO_INCREMENT,
  nom varchar(30),
  prenom varchar(30),
  clan varchar(20),
  etreinte int,
  generation int,
  PRIMARY KEY (id)
);

INSERT INTO vampire (nom, prenom, clan, etreinte, generation) VALUES ('Thrace', 'Oliver', 'Tremere', 1496, 6);
INSERT INTO vampire (nom, prenom, clan, etreinte, generation) VALUES ('de Sparte', 'Helene', 'Toreador', -1207, 4);
