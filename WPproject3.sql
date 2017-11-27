-- The first statement is for MySQL Workbench where you have to select the database. I named my database project3. 
-- That's why the first statement is there.
USE project3;

CREATE TABLE user (
	id int(11) NOT NULL,
	username varchar(50) NOT NULL,
	pword varchar(50) NOT NULL,
    firstname varchar(50) NOT NULL,
    lastname varchar(50) NOT NULL,
    billinginfo varchar(50) NOT NULL
)

CREATE TABLE admin (
	id int(11) NOT NULL,
	adminName varchar(50) NOT NULL,
	pword varchar(50) NOT NULL,
	role varchar(50) NOT NULL
)

INSERT INTO admin (id, adminName, pword, role) VALUES
(1, 'admin', 'admin', 'Admin')

CREATE TABLE inventory (
	id int(11) NOT NULL,
    ISBN varchar(50) NOT NULL,
	title varchar(50) NOT NULL,
    author varchar(50) NOT NULL,
    edition varchar(50) NOT NULL,
    price varchar(50) NOT NULL,
    quantity int(11) NOT NULL
)

CREATE TABLE tracking (
	id int(11) NOT NULL,
	ISBN varchar(50) NOT NULL,
    userID varchar(50) NOT NULL
)

