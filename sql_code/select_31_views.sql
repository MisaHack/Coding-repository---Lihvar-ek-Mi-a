SELECT *
FROM boys;

SELECT *
FROM toys;

/*Creating view in database*/
CREATE VIEW boys_and_toys AS
SELECT b.boy,t.toy
FROM boys b NATURAL JOIN toys t;

/*Using view we just created*/
SELECT * FROM boys_and_toys;

CREATE TABLE piggy_bank_new
(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    coin CHAR(1) NOT NULL,
    coin_year INT
);

INSERT INTO piggy_bank_new
(coin,coin_year)
VALUES
('Q',1950),('P',1972),('N',2005),('Q',1999),('Q',1981),
('D',1940),('Q',1980),('P',2001),('D',1926),('P',1999);

SELECT * FROM piggy_bank_new;

CREATE VIEW pb_quarters AS
SELECT * FROM piggy_bank_new
WHERE coin = 'Q';

SELECT * FROM pb_quarters;

CREATE VIEW pd_dimes AS
SELECT * FROM piggy_bank_new
WHERE coin = 'D' WITH CHECK OPTION;

SELECT * FROM piggy_bank_new;

SELECT * FROM pb_quarters;

SELECT * FROM pd_dimes;

INSERT INTO pb_quarters
(coin,coin_year) 
VALUES ('Q',1993);

INSERT INTO pb_quarters
(coin,coin_year)
VALUES
('D',1942);

INSERT INTO pd_dimes
(coin,coin_year)
VALUES
('Q',2005);

SHOW CREATE VIEW pd_dimes;

SHOW CREATE TABLE piggy_bank_new;

DELETE FROM pb_quarters
WHERE coin='P' OR coin='D';

UPDATE pb_quarters
SET coin='Q'
WHERE coin='P';

CREATE VIEW mc_gender AS
SELECT * FROM my_contacts
WHERE gender IN ('M','F') WITH CHECK OPTION;

SELECT * FROM mc_gender;

INSERT INTO mc_gender
(gender)
VALUES 
('X');


SHOW TABLES;