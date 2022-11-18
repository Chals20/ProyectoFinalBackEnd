
CREATE TABLE roles (
id int PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(30) NOT NULL
);

create table users(
id int not null primary key,
user_name varchar(100) not null,
email varchar(50) not null,
rol int not null,
foreign key (rol) references roles(id)
);

create table orders(
id int not null primary key,
fecha DATETIME not null,
"user" int,
FOREIGN KEY ("user")REFERENCES users(id) 
);

create table categorys(
id int primary key,
name varchar(30)
);

create table dishs(
id int primary key,
name VARCHAR(30) NOT NULL,
img varchar(50) NOT NULL,
category int not null,
foreign key(category) references categorys(id)
);

create table dish_order(
id int not null primary key,
"order" int,
dish int,
FOREIGN KEY ("order")REFERENCES orders(id),
FOREIGN KEY (dish)REFERENCES dishs(id) 
);

insert into roles(id,name) values(1,'admin'),
(2,'normal');

insert into users(id,user_name,email,rol) values(1,'Alvaro','a@gmail.com',1);
insert into users(id,user_name,email,rol) values(2,'Juansito','j@gmail.com',2);

insert into orders(id,fecha,"user") values(1,NOW(),2);
insert into orders(id,fecha,"user") values(2,NOW(),1);

insert into categorys(id,name)
values(1,'Pimer Plato'),(2,'Segundo PLato'),(3,'Postre');

insert into dishs(id,name,img,category)
values(1,'Arroz con Pollo','urlFoto',1),
(2,'Ensalada', 'URL FOTO2', 2),(3,'Pastel', 'URL FOTO3', 3);

insert into dish_order(id,dish,"order") values(1,1,1),(2,1,2);


