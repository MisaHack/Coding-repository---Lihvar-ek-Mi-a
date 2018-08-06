SELECT *
FROM toys;

SELECT *
FROM boys;

/*connects all rows from left table with rows from right table*/
SELECT b.boy, t.toy
FROM boys b LEFT OUTER JOIN toys t
ON b.toy_id = t.toy_id;

SELECT b.boy,t.toy
FROM boys b INNER JOIN toys t
ON b.toy_id = t.toy_id;

/*if we dont have appropriate match then our row will show but with null value*/
SELECT b.boy, t.toy
FROM toys t LEFT OUTER JOIN boys b
ON b.toy_id = t.toy_id;

/*Right outer join - does same thing as Left outer join*/
SELECT b.boy,t.toy
FROM toys t RIGHT OUTER JOIN boys b
ON b.toy_id = t.toy_id;



