CREATE TABLE hooptie
(
	color VARCHAR(20),
    year INT(4) NOT NULL,
    make VARCHAR(20) NOT NULL,
    mo VARCHAR(20) NOT NULL,
    howmuch DEC(9,3) NOT NULL
);

DESC hooptie;

SELECT *
FROM hooptie;

INSERT INTO hooptie
(color,year,make,mo,howmuch)
VALUES
('silver',1998,'Porsche','Boxter',17992.540),
(NULL,2000,'Jaguar','XJ',15995),
('red',2002,'Cadillac','Escolade',40215.90);

ALTER TABLE hooptie
RENAME TO car_table,
ADD COLUMN car_id INT NOT NULL AUTO_INCREMENT FIRST,
ADD PRIMARY KEY(car_id),
ADD COLUMN VIN VARCHAR(30) AFTER car_id,
MODIFY COLUMN make VARCHAR(20) AFTER VIN,
CHANGE COLUMN mo model VARCHAR(20) NOT NULL,
MODIFY COLUMN model VARCHAR(20) NOT NULL AFTER make,
CHANGE COLUMN howmuch price DEC(9,3) NOT NULL;

SELECT *
FROM car_table;

ALTER TABLE hooptie
RENAME TO car_table;

ALTER TABLE car_table
ADD COLUMN car_id INT NOT NULL AUTO_INCREMENT FIRST,
ADD PRIMARY KEY (car_id);

ALTER TABLE car_table
ADD COLUMN VIN VARCHAR(30) AFTER car_id;

ALTER TABLE car_table
MODIFY COLUMN make VARCHAR(20) AFTER VIN;

ALTER TABLE car_table
CHANGE COLUMN mo model VARCHAR(20) NOT NULL;

ALTER TABLE car_table
MODIFY COLUMN model VARCHAR(20) NOT NULL AFTER make;

ALTER TABLE car_table
CHANGE COLUMN howmuch price DEC(9,3) NOT NULL;

ALTER TABLE car_table
MODIFY COLUMN price DEC(9,2) NOT NULL;

DELETE
FROM car_table
WHERE car_id IS NULL;