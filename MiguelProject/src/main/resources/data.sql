DROP TABLE IF EXISTS cliente;

CREATE TABLE clientes (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(250) NOT NULL,
  idade INT
);

INSERT INTO clientes (nome, idade) VALUES
  ('BotGlauco', 22),
  ('Gustavo', 22),
  ('Sara', 24);