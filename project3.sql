DROP TABLE IF EXISTS book;
CREATE TABLE book (
  isbn int(11) NOT NULL,
  title varchar(50),
  author varchar(50),
  edition int,
  price int NOT NULL,
  PRIMARY KEY (isbn)
);

DROP TABLE IF EXISTS sale;
CREATE TABLE sale (
  isbn int NOT NULL AUTO_INCREMENT,
  buyBook varchar(50),
  price int NOT NULL,
  customer char(50) REFERENCES user(username),
  PRIMARY KEY (isbn)
);

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id int NOT NULL AUTO_INCREMENT,
  fullname varchar(50),
  username varchar(50),
  password varchar(50),
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS admins;
CREATE TABLE admins (
  id int NOT NULL AUTO_INCREMENT,
  username varchar(50),
  password varchar(50),
  role varchar(50),
  PRIMARY KEY (id)
);