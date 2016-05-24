CREATE TABLE saldo (
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	saldo DOUBLE PRECISION
);

CREATE TABLE cliente (
	codice INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	nome VARCHAR (128),
	cognome VARCHAR (128),
	username VARCHAR (16),
	password VARCHAR (16),
        idsaldo INTEGER,
        FOREIGN KEY (idsaldo) REFERENCES saldo(id)
);

CREATE TABLE venditore (
	codice INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	nome VARCHAR (128),
	cognome VARCHAR (128),
	username VARCHAR (16),
	password VARCHAR (16),
        idsaldo INTEGER,
        FOREIGN KEY (idsaldo) REFERENCES saldo(id)
);

CREATE TABLE oggetto (
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	titolo VARCHAR (128),
	categoria VARCHAR (32),
	quantita INTEGER,
	prezzo DOUBLE PRECISION,
	idvenditore INTEGER,
	idcliente INTEGER
);

CREATE TABLE acquisto (
	idcliente INTEGER,
	idoggetto INTEGER,
        idvenditore INTEGER,
	FOREIGN KEY (idcliente) REFERENCES cliente(codice),
	FOREIGN KEY (idoggetto) REFERENCES oggetto(id),
        FOREIGN KEY (idvenditore) REFERENCES oggetto(codice)
);

INSERT INTO saldo
VALUES
(default, 15),
(default, 80),
(default, 50),
(default, 1500),
(default, 500),
(default, 1000);

INSERT INTO cliente
VALUES
(default, 'Francesca','Bacci', 'FBacci', 'uno', 1),
(default, 'Mario', 'Rossi', 'MRossi', 'due', 2),
(default, 'Paolo', 'Casula', 'PCasula', 'tre', 3);

INSERT INTO venditore
VALUES
(default, 'Marina', 'Floris', 'MFloris', 'quattro', 4),
(default, 'Andrea', 'Loi', 'ALoi', 'cinque', 5),
(default, 'Valerio', 'Carta', 'VCarta', 'sei', 6);

INSERT INTO oggetto
VALUES
(default, 'The Imitation Game', 'Storico', 50, 20, 2, 1),
(default, 'Frozen', 'Animazione', 50, 16, 1, 3),
(default, 'Sherlock - le prime tre stagioni', 'Giallo', 30, 25, 3, 2),
(default, 'Pirati dei Caraibi: La maledizione della prima luna', 'Avventura', 25, 10, 3, 3),
(default, 'Il discorso del Re', 'Storico', 55, 14, 2, 1);

INSERT INTO acquisto
VALUES
(2,1,2),
(3,4,3),
(1,5,2),
(2,2,1),
(3,1,2),
(1,3,3),
(2,4,3),
(3,5,2),
(2,3,3),
(3,3,3);