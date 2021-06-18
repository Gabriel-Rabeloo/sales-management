CREATE TABLE category (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO category (name) values ('Tecnologia');
INSERT INTO category (name) values ('Acessórios para veículos');
INSERT INTO category (name) values ('Esporte e Lazer');
INSERT INTO category (name) values ('Casa e Eletrodomésticos');
INSERT INTO category (name) values ('Joias e Relógios');