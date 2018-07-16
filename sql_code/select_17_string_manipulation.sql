SELECT *
FROM my_contacts;

DESC my_contacts;

SELECT RIGHT(location,2)
FROM my_contacts;

SELECT LEFT(location,2)
FROM my_contacts;

SELECT SUBSTRING_INDEX(location,',',1)
FROM my_contacts;

SELECT SUBSTRING('San Antonio,TX',5,3);

SELECT UPPER('sPa');

SELECT LOWER('spaGHEtti');

SELECT REVERSE('spaGHEtti');

SELECT LTRIM('   dogfood   ');

SELECT RTRIM('   catfood   ');

SELECT LENGTH('San Antonio,TX');

SELECT *
FROM my_contacts;

ALTER TABLE my_contacts
ADD COLUMN city VARCHAR(20) NOT NULL;

ALTER TABLE my_contacts
ADD COLUMN state CHAR(2) NOT NULL;

UPDATE my_contacts
SET city=SUBSTRING_INDEX(location,',',1);

UPDATE my_contacts
SET state=RIGHT(location,2);

ALTER TABLE my_contacts
MODIFY city VARCHAR(20),
MODIFY state CHAR(2);

DESC my_contacts;