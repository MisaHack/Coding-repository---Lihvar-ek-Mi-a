CREATE TABLE drink_info
(
	drink_name VARCHAR(30) NOT NULL,
    cost DEC(3,1) NOT NULL,
    carbs DEC(3,1) NOT NULL,
    color VARCHAR(20) NOT NULL,
    ice CHAR(1) NOT NULL,
    calories INT NOT NULL
);

DROP TABLE drink_info;

INSERT INTO drink_info
VALUES
('Blackthorn',3,8.4,'yellow','Y',33);


INSERT INTO drink_info
VALUES
('Blue Moon',2.5,3.2,'blue','Y',12);


INSERT INTO drink_info
VALUES
('Oh My Gosh',3.5,8.6,'orange','Y',35);


INSERT INTO drink_info
VALUES
('Lime Fizz',2.5,5.4,'green','Y',24);



INSERT INTO drink_info
VALUES
('Kiss on the Lips',5.5,42.5,'purple','Y',171);


INSERT INTO drink_info
VALUES
('Hot Gold',3.2,32.1,'orange','N',135);


INSERT INTO drink_info
VALUES
('Lone Tree',3.6,4.2,'red','Y',17);


INSERT INTO drink_info
VALUES
('Greyhound',4,14,'yellow','Y',50);


INSERT INTO drink_info
VALUES
('Indian Summer',2.8,7.2,'brown','N',30);


INSERT INTO drink_info
VALUES
('Bull Frog',2.6,21.5,'tan','Y',80);


INSERT INTO drink_info
VALUES
('Soda and It',3.8,4.7,'red','N',19);

SELECT drink_name
FROM drink_info
WHERE cost >= 3.5 AND calories < 50;

/*Greyhound*/
SELECT drink_name,cost
FROM drink_info
WHERE ice='Y' AND color='yellow' AND calories > 33;

/*Blue Moon*/
SELECT drink_name,color
FROM drink_info
WHERE carbs<=4 AND ice='Y';

/*Kiss on the Lips,Hot Gold,Bull Frog*/
SELECT drink_name,cost
FROM drink_info
WHERE calories>=80;

/*Kiss on the Lips, Greyhound*/
SELECT drink_name,color,ice
FROM drink_info
WHERE cost >= 4;

/*Alphabetical search*/
SELECT drink_name
FROM drink_info
WHERE drink_name >= 'L' AND drink_name < 'M';

SELECT drink_name
FROM easy_drinks
WHERE main='cherry juice' OR second='cherry juice';

SELECT *
FROM drink_info;

SELECT *
FROM easy_drinks;