
create database `Grupo-09-BDD-OO2-2021`;
use `Grupo-09-BDD-OO2-2021`;

select * from usuario;
select * from perfil;

-- Tablas

CREATE TABLE `perfil` (
  `id_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `tipo_perfil` varchar(45) NOT NULL,
  `updatedat` datetime(6) NOT NULL,
  PRIMARY KEY (`id_perfil`),
  UNIQUE KEY `UK_b2pufreyna80bckf8r5onjdwu` (`tipo_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(45) NOT NULL,
  `createdat` datetime(6) DEFAULT NULL,
  `dni` bigint(20) NOT NULL,
  `email` varchar(60) NOT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `nombre` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `tipo_dni` varchar(255) DEFAULT NULL,
  `updatedat` datetime(6) NOT NULL,
  `username` varchar(45) NOT NULL,
  `id_perfil` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `UK_ma71x4n4tydibsd9qt0m71le7` (`dni`),
  UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`),
  UNIQUE KEY `UK_863n1y3x0jalatoir4325ehal` (`username`),
  KEY `FK131gkl0dt1966rsw6dmesnsxw` (`id_perfil`),
  CONSTRAINT `FK131gkl0dt1966rsw6dmesnsxw` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Perfiles ya precargados

INSERT INTO perfil (id_perfil, tipo_perfil,enabled,createdat, updatedat)
VALUES (1,"ROLE_ADMIN",0b1,'2021-05-28 03:20:21.369000','2021-05-28 03:20:21.369000');

INSERT INTO perfil (id_perfil, tipo_perfil,enabled,createdat, updatedat)
VALUES (2,"ROLE_AUDITOR",0b1,'2021-05-28 03:20:21.369000','2021-05-28 03:20:21.369000');

-- Usuarios

-- username : alan
-- password : 1234
INSERT INTO usuario (id_usuario, apellido, createdat, dni, email, enabled, nombre, password, tipo_dni, updatedat, username, id_perfil) 
VALUES ('1', 'signetti', '2021-05-28 03:20:21.369000', '11111111', 'alan@gmail.com',0b1, 'alan', '$2a$10$y2uERZ8FgyK1hX84onod5Ojq7utrVbT.LyGx3sA/hU47uvZFrbNWe', 'DNI', '2021-05-28 03:20:21.369000', 'alan', '1');

-- username : fer
-- password : 1234

INSERT INTO usuario (id_usuario, apellido, createdat, dni, email, enabled, nombre, password, tipo_dni, updatedat, username, id_perfil) 
VALUES ('2', 'scroppo', '2021-05-28 03:20:21.369000', '22222222', 'fer@gmail.com',0b1, 'fer', '$2a$10$y2uERZ8FgyK1hX84onod5Ojq7utrVbT.LyGx3sA/hU47uvZFrbNWe', 'DNI', '2021-05-28 03:20:21.369000', 'fer', '2');



insert into persona values('1', 'persona1', '1231', 'persona1');


INSERT INTO lugar (idLugar, codigo_postal, lugar) VALUES (1, '1846', 'ADROGUE');
INSERT INTO lugar (idLugar, codigo_postal, lugar) VALUES (2, '7600', 'MAR DEL PLATA');
INSERT INTO lugar (idLugar, codigo_postal, lugar) VALUES (3, '1416', 'CABALLITO');


INSERT INTO rodado (id_rodado, dominio, vehiculo) VALUES ('1', 'AAA123AAA', 'citroen C3');
INSERT INTO rodado (id_rodado, dominio, vehiculo) VALUES ('2', 'BBB456BBB', 'fiat palio');
INSERT INTO rodado (id_rodado, dominio, vehiculo) VALUES ('3', 'CCC789CCC', 'chevrolet agile');



