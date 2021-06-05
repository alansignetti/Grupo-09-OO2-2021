
create database `Grupo-09-BDD-OO2-2021`;
use `Grupo-09-BDD-OO2-2021`;


select * from perfil;
select * from usuario;
select * from lugar;
select * from permiso;
select * from permiso_diario;
select * from permiso_periodo;
select * from permisoxlugar;
select * from persona;
select * from rodado;


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


INSERT INTO lugar (idLugar, codigo_postal, lugar) VALUES (1, '1846', 'ADROGUE');
INSERT INTO lugar (idLugar, codigo_postal, lugar) VALUES (2, '7600', 'MAR DEL PLATA');
INSERT INTO lugar (idLugar, codigo_postal, lugar) VALUES (3, '1416', 'CABALLITO');
 


