SELECT *
FROM boys;

SELECT *
FROM my_contacts;

SELECT boy
FROM boys;

SELECT first_name
FROM my_contacts;

/*combines names from two tables without duplicates*/
SELECT boy FROM boys
UNION
SELECT first_name FROM my_contacts;

/*if we want order of the results we can use ORDER BY after last SELECT*/
SELECT boy FROM boys
UNION
SELECT first_name FROM my_contacts
ORDER BY boy;

/*returns all column values with duplicates if there are some*/
SELECT boy FROM boys
UNION ALL
SELECT first_name FROM my_contacts
ORDER BY boy;


/*we can create tables from Unions using CREATE TABLE AS*/
CREATE TABLE boys_and_contacts AS
SELECT boy FROM boys
UNION
SELECT first_name FROM my_contacts
ORDER BY boy;

SELECT *
FROM boys_and_contacts;

DESC boys_and_contacts;

SELECT *
FROM my_contacts; /*contact_id*/

SELECT *
FROM cookie_sales; /*sales*/

SELECT contact_id FROM my_contacts
UNION
SELECT sales FROM cookie_sales;

CREATE TABLE cookie_contacts AS
SELECT contact_id FROM my_contacts
UNION
SELECT sales FROM cookie_sales;

SELECT *
FROM cookie_contacts;

DESC cookie_contacts;