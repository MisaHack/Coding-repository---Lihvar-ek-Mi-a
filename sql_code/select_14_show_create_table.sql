SELECT *
FROM my_contacts;

DESC my_contacts;

SHOW CREATE TABLE my_contacts;

/*Right click on column and select 'Copy Field(uniquoted)'*/
/*We can remove backticks and last line for nicer look, but it is not necessary*/
/*We must to rename my_contacts to some new name*/
/*We also add new columns for holding primary key*/
/*We add AUTO_INCREMENT to contact_id*/
CREATE TABLE `my_contacts_2` (
  contact_id INT NOT NULL AUTO_INCREMENT,
  `last_name` varchar(20) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `profession` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `interests` varchar(100) DEFAULT NULL,
  `seeking` varchar(100) DEFAULT NULL,
  PRIMARY KEY(contact_id)
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


/*SHOW commands*/
SHOW COLUMNS FROM my_contacts;

SHOW CREATE DATABASE gregs_list;

/*result*/
CREATE DATABASE `gregs_list` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

SHOW WARNINGS;



