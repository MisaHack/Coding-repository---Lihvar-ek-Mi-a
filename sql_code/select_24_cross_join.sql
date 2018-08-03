CREATE TABLE toys
(
	toy_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	toy VARCHAR(30)
);

CREATE TABLE boys
(
	boy_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    boy VARCHAR(30)
);

INSERT INTO toys
(toy)
VALUES
('hula hoop'),('balsa glider'),
('toy soldiers'),('harmonica'),
('baseball cards');

SELECT *
FROM toys;

INSERT INTO boys
(boy)
VALUES
('Davey'),('Bobby'),('Beaver'),('Richie');

SELECT *
FROM boys;

/*CROSS JOIN*/
SELECT toys.toy,boys.boy
FROM toys CROSS JOIN boys;

/*CROSS JOIN with aliases*/
SELECT t.toy,b.boy
FROM toys AS t CROSS JOIN boys AS b;

/*CROSS JOIN without keyword*/
SELECT t.toy,b.boy
FROM toys t, boys b;


/*CROSS JOIN with all columns - just for test*/
SELECT *
FROM toys,boys;

/*Every boy joined with every boy*/
SELECT b1.boy,b2.boy
FROM boys b1 CROSS JOIN boys b2;

/*
ALTER TABLE boys
ADD COLUMN toy_id INT 
CONSTRAINT toys_toy_id_fk
FOREIGN KEY(toy_id)
REFERENCES toys(toy_id);
*/

ALTER TABLE boys
ADD COLUMN toy_id INT;

ALTER TABLE boys
ADD CONSTRAINT toys_toy_id_fk FOREIGN KEY (toy_id) REFERENCES toys(toy_id);

DESC boys;

SELECT *
FROM boys;

UPDATE boys
SET toy_id = 3
WHERE boy_id = 1;

UPDATE boys
SET toy_id = 5
WHERE boy_id = 2;

UPDATE boys
SET toy_id = 2
WHERE boy_id = 3;

UPDATE boys
SET toy_id = 1
WHERE boy_id = 4;