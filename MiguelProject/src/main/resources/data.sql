CREATE TABLE clientes (
    ID int NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    idade int,
    PRIMARY KEY (ID)
);

INSERT INTO clientes (id, nome, idade) VALUES
  (1, 'Leonardo', 18),
  (2, 'Gustavo', 24),
  (3, 'Sara', 25);