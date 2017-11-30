-- The first statement is for MySQL Workbench where you have to select the database. I named my database project3. 
-- That's why the first statement is there.
USE project3;

CREATE TABLE user (
	id int(11) NOT NULL,
	username varchar(50) NOT NULL,
	pword varchar(50) NOT NULL,
    fullname varchar(50) NOT NULL
)

INSERT INTO user (id, username, pword, fullname) VALUES
(1, 'aluna3', 'test532', 'Alex Luna')

CREATE TABLE inventory (
	id int(11) NOT NULL,
    ISBN varchar(50) NOT NULL,
	title varchar(50) NOT NULL,
    author varchar(50) NOT NULL,
    edition varchar(50) NOT NULL,
    price varchar(50) NOT NULL
)

CREATE TABLE sale (
	booktitle varchar(50) NOT NULL,
    price varchar(50) NOT NULL,
    username varchar(50) NOT NULL
)
