-- password is 'noroot' hashed con http://www.nitrxgen.net/hashgen/ - Columna MySQL ≥ v4.1.1 OJO va con '*' adelante
--CREATE USER 'noroot'@'localhost' IDENTIFIED BY PASSWORD '*1e0c5129c5acbb000327810a08a241d08f942637'; 

DROP TABLE IF EXISTS `funcionalidad`;

CREATE TABLE `functionality` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(200) NOT NULL ,
  PRIMARY KEY (`id`)  ); borar esto!! asdasdsadsdsa
  
--GRANT ALL PRIVILEGES ON pw2.* TO 'noroot'@'localhost' IDENTIFIED BY PASSWORD '*1e0c5129c5acbb000327810a08a241d08f942637' 
