DROP TABLE IF EXISTS book;
CREATE TABLE book (
  isbn INT(11) NOT NULL,
  title CHAR(50),
  author char(50),
  edition INT,
  price INT NOT NULL,
  PRIMARY KEY (isbn)
);

DROP TABLE IF EXISTS sale;
CREATE TABLE sale (
  isbn INT NOT NULL AUTO_INCREMENT,
  buyBook CHAR(50),
  price INT NOT NULL,
  customer char(50) REFERENCES user(username),
  PRIMARY KEY (isbn)
);

DROP TABLE IF EXISTS cart;
CREATE TABLE cart (
  isbn INT NOT NULL AUTO_INCREMENT,
  buyBook CHAR(50),
  price INT NOT NULL,
  customer char(50) REFERENCES user(username),
  PRIMARY KEY (isbn)
);

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT,
  fullname CHAR(50),
  username CHAR(50),
  password CHAR(50),
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS admins;
CREATE TABLE admins (
  id INT NOT NULL AUTO_INCREMENT,
  username CHAR(50),
  password CHAR(50),
  role CHAR(50),
  PRIMARY KEY (id)
);