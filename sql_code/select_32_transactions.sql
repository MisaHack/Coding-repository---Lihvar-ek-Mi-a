SHOW CREATE TABLE my_contacts;

/*InnoDB storage engine allow us transactions*/
CREATE TABLE `my_contacts` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(20) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `profession` varchar(50) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` char(2) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `interests` varchar(100) DEFAULT NULL,
  `interest1` varchar(25) DEFAULT NULL,
  `interest2` varchar(25) DEFAULT NULL,
  `interest3` varchar(25) DEFAULT NULL,
  `interest4` varchar(25) DEFAULT NULL,
  `seeking` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SELECT * FROM piggy_bank_new;

/*Example 1 transaction*/
START TRANSACTION;
SELECT * FROM piggy_bank_new;
UPDATE piggy_bank_new
SET coin='Q'
WHERE coin='P';
SELECT * FROM piggy_bank_new;
ROLLBACK;
SELECT * FROM piggy_bank_new;

/*Example 2 transaction*/
START TRANSACTION;
SELECT * FROM piggy_bank_new;
UPDATE piggy_bank_new
SET coin='Q'
WHERE coin='P';
SELECT * FROM piggy_bank_new;
COMMIT;
SELECT * FROM piggy_bank_new;

SELECT * FROM piggy_bank;

DESC piggy_bank;

ALTER TABLE piggy_bank
ADD COLUMN coin_year INT(4) NOT NULL;

INSERT INTO piggy_bank
(coin,coin_year)
VALUES
('Q',1950),('P',1972),('N',2005),('Q',1999);

/*Task 1*/
START TRANSACTION;
SELECT * FROM piggy_bank;
UPDATE piggy_bank
SET coin='Q'
WHERE coin='P' AND coin_year < 1970;
SELECT * FROM piggy_bank;
COMMIT;
SELECT * FROM piggy_bank;

/*Task 2*/
START TRANSACTION;
SELECT * FROM piggy_bank;
UPDATE piggy_bank
SET coin='N'
WHERE coin='Q';
SELECT * FROM piggy_bank;
ROLLBACK;
SELECT * FROM piggy_bank;

/*Task 3*/
START TRANSACTION;
SELECT * FROM piggy_bank;
UPDATE piggy_bank
SET coin='Q'
WHERE coin='N' AND coin_year > 1950;
SELECT * FROM piggy_bank;
ROLLBACK;
SELECT * FROM piggy_bank;

/*Task 4*/
START TRANSACTION;
SELECT * FROM piggy_bank;
UPDATE piggy_bank
SET coin='D'
WHERE coin='Q' AND coin_year > 1980;
SELECT * FROM piggy_bank;
COMMIT;
SELECT * FROM piggy_bank;

/*Task 5*/
START TRANSACTION;
SELECT * FROM piggy_bank;
UPDATE piggy_bank
SET coin='P'
WHERE coin='N' AND coin_year > 1920;
SELECT * FROM piggy_bank;
COMMIT; 
SELECT * FROM piggy_bank;
