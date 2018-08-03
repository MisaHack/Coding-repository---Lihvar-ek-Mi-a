/*Write queries that can retrieve the status, profession, interests, and
seeking values from the old my_contacts table, without producing
any duplicates. */

SELECT *
FROM my_contacts;

SELECT status
FROM my_contacts;

SELECT status
FROM my_contacts
GROUP BY status;

SELECT status
FROM my_contacts
GROUP BY status
ORDER BY status;

SELECT profession
FROM my_contacts;

SELECT profession
FROM my_contacts
GROUP BY profession;

SELECT profession
FROM my_contacts
GROUP BY profession
ORDER BY profession;

SELECT interests
FROM my_contacts;

SELECT interests
FROM my_contacts
GROUP BY interests;

/*this column has multiple values so query is doesn't provide corect answer*/
SELECT interests
FROM my_contacts
GROUP BY interests
ORDER BY interests;

SELECT seeking
FROM my_contacts;

SELECT seeking
FROM my_contacts
GROUP BY seeking;

SELECT seeking
FROM my_contacts
GROUP BY seeking
ORDER BY seeking;

SELECT *
FROM my_contacts;

/*Add columns interests1,insterests2,interests3,interests4 u my_contacts tabelu*/
ALTER TABLE my_contacts
ADD COLUMN interest1 VARCHAR(30),
ADD COLUMN interest2 VARCHAR(30),
ADD COLUMN interest3 VARCHAR(30),
ADD COLUMN interest4 VARCHAR(30);

/**/
UPDATE my_contacts
SET interests = SUBSTR(interests,LENGTH(interest1)+2);

UPDATE my_contacts
SET interests = SUBSTR(interests,2);

UPDATE my_contacts
SET interest1 = SUBSTRING_INDEX(interests,',',1);

UPDATE my_contacts
SET interest2 = SUBSTRING_INDEX(interests,',',1);

UPDATE my_contacts
SET interests= 'int1,int2,int3';

/*Create new interest table and copy values from my_contacts into it*/
CREATE TABLE interest_table
(
	interest1 VARCHAR(30), 
    interest2 VARCHAR(30),
    interest3 VARCHAR(30),
    interest4 VARCHAR(30)
);

DESC interest_table;

SELECT *
FROM interest_table;

SELECT interest1 
FROM my_contacts
GROUP BY interest1 
ORDER BY interest1;

/*
UPDATE interest_table
SET interest1 = (SELECT interest1 FROM my_contacts);
*/


INSERT INTO interest_table
(interest1)
SELECT interest1 FROM my_contacts GROUP BY interest1;

INSERT INTO interest_table
(interest2)
SELECT interest2 FROM my_contacts GROUP BY interest2 ORDER BY interest2;

/*
ALTER TABLE interest_table
ADD COLUMN id INT NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST */

SELECT profession
FROM my_contacts
GROUP BY profession
ORDER BY profession;

CREATE TABLE profession
(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    profession VARCHAR(30)
)
AS
SELECT profession
FROM my_contacts
GROUP BY profession
ORDER BY profession;

SELECT *
FROM profession;