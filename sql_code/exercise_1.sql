/*Creating data base 'drinks'*/
CREATE DATABASE drinks;

/*Use data base 'drinks'*/
USE drinks;

/*Creating table 'easy_drinks'*/
CREATE TABLE easy_drinks
(
	drink_name VARCHAR(30) NOT NULL,
    main VARCHAR(30) NOT NULL,
    amount1 DEC(3,1) NOT NULL,
    second VARCHAR(30) NOT NULL,
    amount2 DEC(4,2) NOT NULL,
    directions VARCHAR(200) NOT NULL
);

/*Structure of the table 'easy_drinks'*/
DESC easy_drinks;

/*Inserting rows*/
INSERT INTO easy_drinks
(drink_name,main,amount1,second,amount2,directions)
VALUES
('Blackthorn','tonic water',1.5,'pineapple juice',1,
'stir with ice, strain into coctail glass with lemon twist');


INSERT INTO easy_drinks
(drink_name,main,amount1,second,amount2,directions)
VALUES
('Blue Moon','soda',1.5,'blueberry juice',.75,
'stir with ice, strain into coctail glass with lemon twist');


INSERT INTO easy_drinks
(drink_name,main,amount1,second,amount2,directions)
VALUES
('Oh My Gosh','peach nectar',1,'pineapple juice',1,'stir with ice, strain into shot glass');


INSERT INTO easy_drinks
(drink_name,main,amount1,second,amount2,directions)
VALUES
('Lime Fizz','Sprite',1.5,'lime juice',.75,'stir with ice, strain into coctail glass');


INSERT INTO easy_drinks
(drink_name,main,amount1,second,amount2,directions)
VALUES
('Kiss on the Lips','cherry juice',2,'apricot nectar',7,'serve over ice with straw');


INSERT INTO easy_drinks
(drink_name,main,amount1,second,amount2,directions)
VALUES
('Hot Gold','peach nectar',3,'orange juice',6,
'pour hot orange juice in mug and add peach nectar');


INSERT INTO easy_drinks
(drink_name,main,amount1,second,amount2,directions)
VALUES
('Lone Tree','soda',1.5,'cherry juice',.75,'stir with ice, strain into coctail glass');


INSERT INTO easy_drinks
(drink_name,main,amount1,second,amount2,directions)
VALUES
('Greyhound','soda',1.5,'grapefruit juice',5,'serve over ice, stir well');


INSERT INTO easy_drinks
(drink_name,main,amount1,second,amount2,directions)
VALUES
('Indian Summer','apple juice',2,'hot tea',6,'add juice to mug and top off with hot tea');


INSERT INTO easy_drinks
(drink_name,main,amount1,second,amount2,directions)
VALUES
('Bull Frog','iced tea',1.5,'lemonade',5,'serve over ice with lime slice');


INSERT INTO easy_drinks
(drink_name,main,amount1,second,amount2,directions)
VALUES
('Soda and It','soda',2,'grape juice',1,'shake in coctail glass, no ice');

/*Show table*/
SELECT *
FROM easy_drinks;