SELECT *
FROM my_contacts;

SELECT email
FROM my_contacts
WHERE profession='Programmer';

USE drinks;

SELECT *
FROM easy_drinks;

SELECT drink_name
FROM easy_drinks
WHERE main='soda' AND amount1=1.5;

SELECT drink_name
FROM easy_drinks
WHERE main='soda' AND amount1=2;

SELECT drink_name
FROM easy_drinks
WHERE main='soda' AND amount1 > 1;

SELECT drink_name
FROM easy_drinks
WHERE 'soda'=main AND 1 < amount1;