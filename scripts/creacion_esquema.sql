-- password is 'noroot' hashed con http://www.nitrxgen.net/hashgen/ - Columna MySQL ≥ v4.1.1 OJO va con '*' adelante
--CREATE USER 'noroot'@'localhost' IDENTIFIED BY PASSWORD '*1e0c5129c5acbb000327810a08a241d08f942637'; 

DROP TABLE IF EXISTS `funcionalidad`;

CREATE TABLE `functionality` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(200) NOT NULL ,
  PRIMARY KEY (`id`)  ); borar esto!! asdasdsadsdsa

INSERT INTO User(address,email, name, password,phone,type) 
VALUES ('asdfasdf','asdf@sdf', 'asdfadsf','asdfasdf',55555,'aaaaa');
  
INSERT INTO product (name, quantity,price) 
VALUES ('vasito',2,10.2);

INSERT INTO product (name, quantity,price) 
VALUES ('cucurucho',2,15.1);

INSERT INTO product (name, quantity,price)  
VALUES ('cuarto',2,20.4);

INSERT INTO product (name, quantity,price) 
VALUES ('medio',3,50,5);

INSERT INTO product (name, quantity,price) 
VALUES ('kilo',4,100.5);

insert into Flavour (costPrice, name, salePrice) 
values (12,'vainilla',20);

insert into Flavour (costPrice, name, salePrice) 
values (22,'chocolate',30);

insert into Flavour (costPrice, name, salePrice) 
values (20,'dulce de leche',30);

insert into Flavour (costPrice, name, salePrice) 
values (15,'frutilla',20);

insert into Flavour (costPrice, name, salePrice) 
values (14,'limon',20);

select * from product

--GRANT ALL PRIVILEGES ON pw2.* TO 'noroot'@'localhost' IDENTIFIED BY PASSWORD '*1e0c5129c5acbb000327810a08a241d08f942637' 
