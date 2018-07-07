USE drinks;

/*Narrow search*/
SELECT drink_name,main,second
FROM easy_drinks
WHERE main='soda';

/*Output: Bull Frog*/
SELECT drink_name
FROM easy_drinks
WHERE directions='serve over ice with lime slice';

/*Output: Bull Frog*/
SELECT drink_name
FROM easy_drinks
WHERE second='lemonade';

/*Output: Bull Frog*/
SELECT drink_name
FROM easy_drinks
WHERE main='iced tea';

/*Output: Kiss on the Lips*/
SELECT drink_name
FROM easy_drinks
WHERE second='apricot nectar';

/*Output: Kiss on the Lips*/
SELECT drink_name
FROM easy_drinks
WHERE amount2 = 7;

/*Output: Kiss on the Lips*/
SELECT drink_name
FROM easy_drinks
WHERE directions='serve over ice with straw';

/*Output: Kiss on the Lips*/
SELECT drink_name
FROM easy_drinks
WHERE drink_name='Kiss on the Lips';

SELECT *
FROM easy_drinks;