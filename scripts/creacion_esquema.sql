-- password is 'noroot' hashed con http://www.nitrxgen.net/hashgen/ - Columna MySQL ≥ v4.1.1 OJO va con '*' adelante
--CREATE USER 'noroot'@'localhost' IDENTIFIED BY PASSWORD '*1e0c5129c5acbb000327810a08a241d08f942637'; 

INSERT INTO AUTHORITIES VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITIES VALUES (2, 'ROLE_ADMIN');

INSERT INTO User(address,email, name, password,phone,type) 
VALUES ('asdfasdf','asdf@sdf', 'asdfadsf','asdfasdf',55555,'aaaaa');
  
INSERT INTO product (name, quantity,price,imagePath) 
VALUES ('vasito',2,10,'/resources/images/vasito.jpg');

INSERT INTO product (name, quantity,price,imagePath) 
VALUES ('cucurucho',2,15, '/resources/images/cucurucho.jpg');

INSERT INTO product (name, quantity,price,imagePath)  
VALUES ('cuarto',2,20, '/resources/images/cuarto.jpg');

INSERT INTO product (name, quantity,price,imagePath) 
VALUES ('medio',3,50,'/resources/images/medio.jpg');

INSERT INTO product (name, quantity,price,imagePath) 
VALUES ('kilo',4,100, '/resources/images/kilo.jpg');

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
