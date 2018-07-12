SELECT *
FROM easy_drinks;

SELECT drink_name
FROM easy_drinks
WHERE NOT amount1 < 1.5;

SELECT drink_name
FROM easy_drinks
WHERE amount1 >= 1.5;

/*======================*/

SELECT *
FROM drink_info;

SELECT drink_name
FROM drink_info
WHERE NOT ice = 'Y';

SELECT drink_name
FROM drink_info
WHERE ice <> 'Y';

/*======================*/

SELECT drink_name
FROM drink_info
WHERE NOT calories < 20;

SELECT drink_name
FROM drink_info
WHERE calories >= 20;

/*=====================*/

SELECT *
FROM easy_drinks;

SELECT drink_name
FROM easy_drinks
WHERE main IN ('peach nectar','soda');

SELECT drink_name
FROM easy_drinks
WHERE main='peach nectar' OR main='soda';

/*=======================*/

SELECT *
FROM drink_info;

SELECT drink_name
FROM drink_info
WHERE NOT calories=0;

SELECT drink_name
FROM drink_info
WHERE calories <> 0;

/*======================*/

SELECT drink_name
FROM drink_info
WHERE NOT carbs BETWEEN 3 AND 5;

SELECT drink_name
FROM drink_info
WHERE carbs <= 3 OR carbs >=5;

/*=====================*/

USE gregs_list;

SELECT *
FROM black_book;

SELECT date_name
FROM black_book
WHERE NOT date_name LIKE 'A%' AND NOT date_name LIKE 'B%';

SELECT date_name
FROM black_book
WHERE NOT date_name BETWEEN 'A' AND 'C';