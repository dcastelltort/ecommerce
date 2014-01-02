CREATE DATABASE ecommerce DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE USER 'ecommerce_user'@'localhost' IDENTIFIED BY 'dumb_password';
GRANT ALL ON ecommerce.* TO 'ecommerce_user'@'Any' IDENTIFIED BY 'dumb_password';

