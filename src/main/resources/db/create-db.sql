--DROP TABLE users IF EXISTS;

CREATE TABLE users (
  id INTEGER PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(50)
);

CREATE TABLE pokemons (
  id INTEGER PRIMARY KEY,
  name VARCHAR(30),
  weight  INTEGER,
  speciesName VARCHAR(30),
);
