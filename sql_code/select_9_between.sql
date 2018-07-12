USE drinks;

SELECT *
FROM drink_info;

SELECT drink_name
FROM drink_info
WHERE calories >= 30 AND calories <= 60;

SELECT drink_name
FROM drink_info
WHERE calories BETWEEN 30 AND 60;

/*Drink names that start with G through O*/
SELECT drink_name
FROM drink_info
WHERE drink_name BETWEEN 'G' AND 'P';

SELECT drink_name
FROM drink_info
WHERE calories BETWEEN 0 AND 30 OR calories > 60;

SELECT drink_name
FROM drink_info
WHERE calories<=30 OR calories>=60;

/*No results because order matters!*/
SELECT drink_name
FROM drink_info
WHERE calories BETWEEN 60 AND 30;