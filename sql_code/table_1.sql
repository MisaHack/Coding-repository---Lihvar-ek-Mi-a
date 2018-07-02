CREATE DATABASE gregs_list;
USE gregs_list;
CREATE TABLE my_contacts
(
	gender CHAR(1),
    first_name VARCHAR(20),
    last_name VARCHAR(30),
    email VARCHAR(50),
    birthday DATE,
    profession VARCHAR(50),
    location VARCHAR(50),
    status VARCHAR(20),
    interests VARCHAR(100),
    seeking VARCHAR(100)
);