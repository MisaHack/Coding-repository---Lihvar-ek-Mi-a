SELECT *
FROM cookie_sales;

SELECT AVG(sales)
FROM cookie_sales
WHERE first_name = 'Lindsay';

SELECT SUM(sales)
FROM cookie_sales
WHERE first_name = 'Lindsay';

SELECT SUM(sales)-AVG(sales)
FROM cookie_sales
WHERE first_name = 'Lindsay';

SELECT *
FROM cookie_sales
ORDER BY first_name,sales DESC;

SELECT *
FROM cookie_sales
ORDER BY sales DESC;

SELECT first_name,MAX(sales)
FROM cookie_sales;

SELECT first_name,MIN(sales)
FROM cookie_sales;