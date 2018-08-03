/*Equijoin*/
/*tests for key equality*/
SELECT boys.boy,toys.toy
FROM boys INNER JOIN toys
ON toys.toy_id=boys.toy_id
ORDER BY boys.boy; 

/*Non Equijoin*/
/*tests for inequality*/
SELECT boys.boy, toys.toy
FROM boys INNER JOIN toys
ON toys.toy_id <> boys.toy_id
ORDER BY boys.boy;