CREATE TABLE cookie_sales
(
	ID INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(30),
    sales DEC(7,2),
    sale_date DATE,
    PRIMARY KEY (ID)
);

DESC cookie_sales;

INSERT INTO cookie_sales
(first_name,sales,sale_date)
VALUES
('Lindsay',32.02,'2007-06-03'),
('Paris',26.53,'2007-06-03'),
('Britney',11.25,'2007-06-03'),
('Nicole',18.96,'2007-06-03'),

('Lindsay',9.16,'2007-07-03'),
('Paris',1.52,'2007-07-03'),
('Britney',43.21,'2007-07-03'),
('Nicole',8.05,'2007-07-03'),

('Lindsay',17.62,'2007-08-03'),
('Paris',24.19,'2007-08-03'),
('Britney',3.40,'2007-08-03'),
('Nicole',15.21,'2007-08-03'),

('Lindsay',0,'2007-09-03'),
('Paris',31.99,'2007-09-03'),
('Britney',2.58,'2007-09-03'),
('Nicole',0,'2007-09-03'),

('Lindsay',2.34,'2007-10-03'),
('Paris',13.44,'2007-10-03'),
('Britney',8.78,'2007-10-03'),
('Nicole',26.82,'2007-10-03'),

('Lindsay',3.71,'2007-11-03'),
('Paris',.56,'2007-11-03'),
('Britney',34.19,'2007-11-03'),
('Nicole',7.77,'2007-11-03'),

('Lindsay',16.23,'2007-12-03'),
('Paris',0,'2007-12-03'),
('Britney',4.50,'2007-12-03'),
('Nicole',19.22,'2007-12-03');

SELECT *
FROM cookie_sales;

SELECT first_name,sales
FROM cookie_sales
ORDER BY first_name,sales DESC;

/*SUM*/
SELECT SUM(sales)
FROM cookie_sales
WHERE first_name='Britney';

/*GROUP BY*/
SELECT first_name,SUM(sales)
FROM cookie_sales
GROUP BY first_name /*names and their sums without order*/
ORDER BY SUM(sales) DESC; /*names and their sums with order - descending*/

/*AVG*/
SELECT first_name,AVG(sales)
FROM cookie_sales
GROUP BY first_name
ORDER BY AVG(sales) DESC;

/*MAX*/
SELECT first_name,MAX(sales)
FROM cookie_sales
GROUP BY first_name
ORDER BY MAX(sales) DESC;

/*MIN*/
SELECT first_name,MIN(sales)
FROM cookie_sales
GROUP BY first_name
ORDER BY MIN(sales) DESC;


SELECT *
FROM cookie_sales;

/*COUNT*/
SELECT COUNT(sale_date)
FROM cookie_sales;

SELECT first_name,COUNT(sale_date)
FROM cookie_sales
WHERE sales > 0
GROUP BY first_name;

/*DISTINCT - keyword*/
SELECT DISTINCT sale_date
FROM cookie_sales;

SELECT COUNT(DISTINCT sale_date)
FROM cookie_sales;

SELECT first_name,COUNT(DISTINCT sale_date)
FROM cookie_sales
WHERE sales > 0
GROUP BY first_name;

/*LIMIT*/
SELECT first_name,SUM(sales)
FROM cookie_sales
GROUP BY first_name
ORDER BY SUM(sales) DESC
LIMIT 2;

/*LIMIT ?,? - 
first place is row index to start from, 
second place is nuber of resuts to show*/
SELECT first_name,SUM(sales)
FROM cookie_sales
GROUP BY first_name
ORDER BY SUM(sales) DESC
LIMIT 1,1;


