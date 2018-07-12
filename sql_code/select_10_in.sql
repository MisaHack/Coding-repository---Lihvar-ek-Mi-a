USE gregs_list;

CREATE TABLE black_book
(
	date_name VARCHAR(30) NOT NULL,
    rating VARCHAR(30) NOT NULL
);

DROP TABLE black_book;


DESC black_book;

SELECT *
FROM black_book;

INSERT INTO black_book
VALUES
('Alex','innovative');

INSERT INTO black_book
VALUES
('James','boring');

INSERT INTO black_book
VALUES
('Ian','fabulous');

INSERT INTO black_book
VALUES
('Boris','no hum');

INSERT INTO black_book
VALUES
('Melvin','plebian');

INSERT INTO black_book
VALUES
('Eric','pathetic');

INSERT INTO black_book
VALUES
('Anthony','delightful');

INSERT INTO black_book
VALUES
('Sammy','pretty good');

INSERT INTO black_book
VALUES
('Ivan','dismal');

INSERT INTO black_book
VALUES
('Vic','ridiculous');


/*IN set*/
SELECT date_name
FROM black_book
WHERE rating IN ('innovative','fabulous','delightful','pretty good');

/*NOT IN set*/
SELECT date_name
FROM black_book
WHERE rating NOT IN ('innovative','fabulous','delightful','pretty good');

USE drinks;

SELECT *
FROM drink_info;

/*NOT BETWEEN*/
SELECT drink_name
FROM drink_info
WHERE NOT carbs BETWEEN 3 AND 5;

USE gregs_list;

/*NOT LIKE, NOT AND, NOT OR*/
SELECT date_name
FROM black_book
WHERE NOT date_name LIKE 'A%' AND NOT date_name LIKE 'B%';

SELECT *
FROM my_contacts;

/*Exception for IS NULL*/
SELECT *
FROM my_contacts
WHERE NOT birthday IS NULL;

/*Exception for IS NULL*/
SELECT *
FROM my_contacts
WHERE birthday IS NOT NULL;

USE drinks;

SELECT * 
FROM easy_drinks;

/*Exception for IN*/
SELECT *
FROM easy_drinks
WHERE NOT main IN ('soda');

/*Exception for IN*/
SELECT *
FROM easy_drinks
WHERE main NOT IN ('soda');

/*Double negation*/
SELECT *
FROM easy_drinks
WHERE NOT drink_name <> 'Blackthorn';

SELECT *
FROM easy_drinks
WHERE drink_name = 'Blackthorn';

SELECT *
FROM easy_drinks;

/*NOT AND*/
SELECT *
FROM easy_drinks
WHERE NOT main='soda' AND NOT main='iced tea';