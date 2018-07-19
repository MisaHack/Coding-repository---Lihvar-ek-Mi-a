SELECT *
FROM movie_table;

SELECT title,categories
FROM movie_table
ORDER BY title;

SELECT title,categories
FROM movie_table
ORDER BY categories;

CREATE TABLE order_rules
(
	test_chars CHAR(1)
);

DESC order_rules;

INSERT INTO order_rules
VALUES
(0),(1),(2),(3),('A'),('B'),('C'),('D'),('a'),('b'),('c'),('d'),
('!'),('@'),('#'),('$'),('%'),('^'),('&'),('*'),('('),(')'),('-'),
('+'),('='),('['),(']'),('{'),('}'),(';'),(':'),('\''),('\"'),('|'),
('`'),('˜'),(','),('.'),('<'),('>'),('/'),('?'),(NULL),('');

DELETE FROM order_rules;

SELECT *
FROM order_rules;

SELECT test_chars
FROM order_rules
ORDER BY test_chars;

SELECT *
FROM movie_table;

SELECT title,categories,purchased
FROM movie_table
ORDER BY categories,purchased;

SELECT *
FROM movie_table
ORDER BY categories,purchased,title;

SELECT title,categories,purchased
FROM movie_table
ORDER BY categories DESC,purchased DESC,title;