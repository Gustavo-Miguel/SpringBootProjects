-- CREATE TABLE clientes (
--     ID int NOT NULL AUTO_INCREMENT,
--     nome varchar(255) NOT NULL,
--     idade int,
--     PRIMARY KEY (ID)
-- );
--
INSERT INTO clientes (id, nome, idade) VALUES
  (1, 'Leonardo', 18),
  (2, 'Gustavo', 24),
  (3, 'Sara', 25);


-- CREATE TABLE casos (
--     ID int NOT NULL AUTO_INCREMENT,
--     nome varchar(255) NOT NULL,
--     idade int,
--     sexo varchar(1),
--     endereco varchar(255),
--     cidade varchar(50),
--     estado varchar(2),
--     email varchar(50),
--     telefone varchar(20),
--     doenca varchar(1),
--     data_contagio DATE,
--     data_registro DATE,
--     latitude DOUBLE,
--     longitude DOUBLE,
--
--     PRIMARY KEY (ID)
-- )