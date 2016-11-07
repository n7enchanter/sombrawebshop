CREATE TABLE user
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE role
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL
);
CREATE TABLE user_roles
(
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  CONSTRAINT use_roles_user_id_fk FOREIGN KEY (user_id) REFERENCES user (id),
  CONSTRAINT use_roles_role_id_fk FOREIGN KEY (role_id) REFERENCES role (id)
);
CREATE TABLE product
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  product_name VARCHAR(45) NOT NULL,
  product_price INT NOT NULL,
  product_description VARCHAR(255) NOT NULL,
  product_image VARCHAR(255) NOT NULL
);
CREATE TABLE category
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  category_name VARCHAR(45) NOT NULL
);
CREATE TABLE product_category
(
  product_id INT NOT NULL,
  category_id INT NOT NULL,
  CONSTRAINT product_categ_product_id_fk FOREIGN KEY (product_id) REFERENCES product (id),
  CONSTRAINT product_categ_category_id_fk FOREIGN KEY (category_id) REFERENCES category (id)
);
CREATE TABLE basket
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL
);
CREATE TABLE basket_product
(
  basket_id INT NOT NULL,
  product_id INT NOT NULL,
  CONSTRAINT basket_prod_basket_id_fk FOREIGN KEY (basket_id) REFERENCES basket (id),
  CONSTRAINT basket_prod_product_id_fk FOREIGN KEY (product_id) REFERENCES product (id)
);