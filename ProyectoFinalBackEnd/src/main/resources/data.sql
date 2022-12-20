DROP Schema if exists railway;
CREATE Schema railway;
use railway; 

create table alergenos(
id int primary key not null auto_increment,
lacteos BIT,
gluten BIT,
vegan BIT
);

create table roles(
id int primary key auto_increment,
namee varchar(10)
);


create table users(
id int not null auto_increment primary key,
user_name varchar(20) not null,
email varchar(30) not null,
password varchar(400),
rol int,
foreign key(rol) references roles(id)
);


create table categorys(
id int not null auto_increment primary key,
namee varchar(50)
);
INSERT INTO categorys(namee) values("Entrantes"),("Principal"),("Postre");

create table dishs(
id int not null auto_increment primary key,
namee varchar(30),
img varchar(300),
price DECIMAL(4,2),
category int,
alergeno int,
foreign key(category) references categorys(id),
foreign key(alergeno) references alergenos(id)
);

create table orders(
id int not null auto_increment primary key,
fecha DATE,
users int not null,
hora DECIMAL(4,2),
total DECIMAL(4,2),
foreign key(users) references users(id)
);

create table dish_order(
id int not null auto_increment primary key,
orden int,
dish int,
amount int,
foreign key(orden) references orders(id),
foreign key(dish) references dishs(id)
);

#Insertamos datos;
#INSERT INTO timetable(id,hora) values(1,'12.00'),(2,'12.15'),(3,'12.30'),(4,'12.45'),(5,'13.00'),(6,'13.15'),(7,'13.30'),(8,'13.45'),
#(9,'14.00'),(10,'14.15'),(11,'14.30'),(12,'14.45'),(13,'15.00'),(14,'15.15'),(15,'15.30'),(16,'15.45');
INSERT INTO alergenos(id,lacteos,gluten,vegan) values(1,1,1,1),(2,0,0,0),(3,0,1,0),(4,0,1,1),(5,0,0,1),(6,1,0,1);
INSERT INTO roles(id,namee) values (1,"ADMIN"),(2,"USER");
INSERT INTO users(user_name,email,password,rol) values("admin","admin@gmail.com","123456",1),("oscar","oscar@gmail.com","123456",2),
("juancarlo","juancarlo@gmail.com","123456",2),("oscar","oscar@gmail.com","123456",2),("ramiro","ramiro@gmail.com","123456",2),
("alvaro","alvaro,@gmail.com","123456",2);
INSERT INTO dishs(namee,img,price,category,alergeno) values
("Arroz con Pollo","https://i.ibb.co/pXRcYcC/image.png",'10.50',2,5),
("Patatas Bravas","https://i.ibb.co/sPnNyYT/image.png",'7.30',1,2),
("Pan con Alioli","https://i.ibb.co/5K3b0qL/image.png",'3.00',1,1),
("Aceitunas","https://i.ibb.co/MBK6Rxg/image.png","2.00",1,2),
("Pizza Margarita","https://i.ibb.co/QrJyVSD/image.png",'11.00',2,1),
("Pizza 4 Quesos","https://i.ibb.co/rQN6BRD/image.png",'14.00',2,1),
("Pizza Vegana","https://i.ibb.co/JdnHCqD/image.png",'11.00',2,3),
("Pizza sin Glutten","https://i.ibb.co/KsN5kY3/image.png",'11.00',2,6),
("Empanada JYQ","https://i.ibb.co/5KLRspW/image.png",'2.00',1,1),
("Empanada de Carne","https://i.ibb.co/5KLRspW/image.png",'2.00',1,4),
("Empanada Vegana","https://i.ibb.co/5KLRspW/image.png",'2.00',2,3),
("CheeseCake","https://i.ibb.co/sQ0KR2Q/image.png",'8.00',3,1),
("Helado de Vainilla","https://i.ibb.co/GPpT2Q7/image.png",'5',3,6),
("Tiramisú vegano","https://i.ibb.co/1rZqsFT/image.png",'6.30',3,3);
INSERT INTO orders(id,fecha,users,hora,total) values(1,'2022-03-12',2,'14.00','14.00'),(2,'2022-03-12',2,'14.00','14.00'),(3,'2022-03-12',2,'14.00','14.00'),(4,'2022-03-12',2,'14.00','14.00'),
(5,'2022-03-12',2,'14.00','14.00'),(6,'2022-03-12',2,'14.00','14.00'),(7,'2022-03-12',3,'14.00','14.00'),(8,'2022-03-12',2,'14.00','14.00'),(9,'2022-10-22',3,'14.00','14.00'),
(10,'2022-10-22',3,'14.00','14.00'),(11,'2022-10-22',3,'14.00','14.00'),(12,'2022-10-22',3,'14.00','14.00'),(13,'2022-10-22',3,'14.00','14.00');
INSERT INTO dish_order(orden,dish,amount)values(1,1,2),(1,2,2),(1,4,1),(2,3,1),(2,2,1),(2,6,2),(3,5,2),(3,10,3),(3,11,1),(3,14,1),(3,5,2),
(4,1,1),(4,2,2),(4,3,1),(4,4,2),(4,11,1),(4,12,2),(5,2,1),(5,3,2),(6,1,2),(6,2,1),(6,5,2),(6,8,1),(6,9,1),(6,3,2),(7,13,4),(7,12,2);
