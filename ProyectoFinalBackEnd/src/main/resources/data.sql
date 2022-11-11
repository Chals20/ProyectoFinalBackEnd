DROP database if exists menjador;
create database if not exists menjador;
use menjador;

CREATE TABLE IF NOT EXISTS roles (
id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, 
nombre VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS user(
id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(30) NOT NULL,
email VARCHAR(50) NOT NULL,
idrole INT UNSIGNED not null REFERENCES roles(id) on delete cascade on update cascade
);

INSERT INTO roles(nombre) VALUES ('Repartidor'),('SuperUsuario'),('Usuario');
INSERT INTO user(username,email,idrole) VALUES ('chals','c@a',1),('alvaro','a@a',2),('oscar','o@a',3);