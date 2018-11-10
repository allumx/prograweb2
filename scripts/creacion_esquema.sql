-- password is 'noroot' hashed con http://www.nitrxgen.net/hashgen/ - Columna MySQL ≥ v4.1.1 OJO va con '*' adelante
--CREATE USER 'noroot'@'localhost' IDENTIFIED BY PASSWORD '*1e0c5129c5acbb000327810a08a241d08f942637'; 

DROP TABLE IF EXISTS `funcionalidad`;

CREATE TABLE `functionality` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(200) NOT NULL ,
  PRIMARY KEY (`id`)  ); borar esto!! asdasdsadsdsa

INSERT INTO User(address,email, name, password,phone,type) 
VALUES ('asdfasdf','asdf@sdf', 'asdfadsf','asdfasdf',55555,'aaaaa');
  
INSERT INTO product (name, quantity) 
VALUES ('vasito',2);

INSERT INTO product (name, quantity) 
VALUES ('cucurucho',2);

INSERT INTO product (name, quantity) 
VALUES ('cuatro',2);

INSERT INTO product (name, quantity) 
VALUES ('medio',3);

INSERT INTO product (name, quantity) 
VALUES ('kilo',4);

--GRANT ALL PRIVILEGES ON pw2.* TO 'noroot'@'localhost' IDENTIFIED BY PASSWORD '*1e0c5129c5acbb000327810a08a241d08f942637' 
