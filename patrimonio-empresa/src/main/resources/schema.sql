CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS Marca (
	marca_id uuid DEFAULT uuid_generate_v4 (), 
	nome VARCHAR (255) UNIQUE NOT NULL, 
	PRIMARY KEY (marca_id)
);

CREATE TABLE IF NOT EXISTS Patrimonio (
	numero_do_tombo uuid DEFAULT uuid_generate_v4 (), 
	descricao TEXT, 
	nome VARCHAR(255), 
	marca_id_marca_id uuid, 
	PRIMARY KEY (numero_do_tombo),
	CONSTRAINT foreign_key_marca
      FOREIGN KEY(marca_id_marca_id) 
	  REFERENCES Marca
);

CREATE TABLE IF NOT EXISTS Users (
	email VARCHAR (255) NOT NULL, 
	nome VARCHAR(255) NOT NULL,
	senha VARCHAR (255) NOT NULL, 
	enabled BOOLEAN NOT NULL, 
 	PRIMARY KEY (email)
);