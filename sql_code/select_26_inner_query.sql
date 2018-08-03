SELECT *
FROM my_contacts;

SELECT profession
FROM my_contacts
GROUP BY profession
ORDER BY profession;

SELECT first_name,last_name,profession
FROM my_contacts;

/*OUTER Query*/
SELECT first_name,last_name,profession
FROM my_contacts
WHERE profession IN 
(
/*INNER Query*/
SELECT profession
FROM my_contacts
GROUP BY profession
ORDER BY profession
);

SELECT *
FROM toys;

SELECT *
FROM boys;

/*OUTER QUERY*/
SELECT boy_id,boy
FROM boys
WHERE toy_id =
(
	/*INNER QUERY*/
	SELECT toy_id
    FROM toys
    WHERE toy='baseball cards'
);

/*Same thing with JOIN but different syntax*/
SELECT b.boy_id,b.boy
FROM boys AS b NATURAL JOIN toys AS t
WHERE t.toy='baseball cards';