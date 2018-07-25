SELECT *
FROM my_contacts;

SELECT *
FROM my_contacts
WHERE last_name='Nigel';

INSERT INTO my_contacts
(last_name,first_name,gender,email,birthday,profession,
location,status,interests,seeking,city,state)
VALUES
('Moore','Nigel','M','nigelmoore@ranchersrule.com','1975-08-28',
'Rancher','Austin,TX','Single','animals,horseback riding,movies','single F','Austin','TX');

INSERT INTO my_contacts
(last_name,first_name,gender,email,birthday,profession,
location,status,interests,seeking,city,state)
VALUES
('Fiore','Carla','F','cfiore@fioreanimalclinic.com','1974-01-07','Veterinarian',
'Round Rock,TX','single','horseback riding,movies,animals,mystery novels,hiking',
'single M','Round Rock','TX');

SELECT *
FROM my_contacts
WHERE gender='F'
AND status='single'
AND state='TX'
AND seeking LIKE '%single M%'
AND birthday > '1970-08-28'
AND birthday < '1980-08-28'
AND interests LIKE '%animals%'
AND interests LIKE '%horse%'
AND interests LIKE '%movies%';

INSERT INTO my_contacts
(last_name,first_name,gender,email,birthday,profession,
location,status,interests,seeking,city,state)
VALUES
('Sullivan','Regis','M','me@kathieleeisaflake.com','1955-03-20','Comedian',
'Cambridge,MA','single','animals,trading cards,geocaching','single F',
'Cambridge','MA');

SELECT *
FROM my_contacts
WHERE gender='F'
AND status='single'
AND seeking LIKE '%single M%'
AND birthday > '1950-03-20'
AND birthday < '1960-03-20';

SELECT *
FROM my_contacts
WHERE gender='F'
AND status='single'
AND state='TX'
AND seeking LIKE '%single M%'
AND birthday > '1970-08-28'
AND birthday < '1980-08-28'
AND SUBSTRING_INDEX(interests,',',1) = 'animals';

INSERT INTO my_contacts
(last_name,first_name,gender,email,birthday,profession,
location,status,interests,seeking,city,state)
VALUES
('Ferguson','Alexis','F','alexangel@yahoo.com','1956-09-19','Artist',
'Pflugerville,MA','single','animals','single M','Pflugerville','MA');

SELECT *
FROM my_contacts;

SELECT *
FROM my_contacts
WHERE gender='F'
AND status='single'
AND seeking LIKE '%single M%'
AND birthday > '1950-03-20'
AND birthday < '1960-03-20'
AND SUBSTRING_INDEX(interests,',',1) = 'animals';

ALTER TABLE my_contacts
ADD COLUMN phone VARCHAR(20) AFTER first_name;

DESC my_contacts;

ALTER TABLE my_contacts
MODIFY gender CHAR(1) AFTER email;

ALTER TABLE my_contacts
MODIFY city VARCHAR(20) AFTER profession;

ALTER TABLE my_contacts
MODIFY state CHAR(2) AFTER city;

ALTER TABLE my_contacts
MODIFY status VARCHAR(20) AFTER state;

ALTER TABLE my_contacts
ADD COLUMN interest1 VARCHAR(25) AFTER interests;

ALTER TABLE my_contacts
ADD COLUMN interest2 VARCHAR(25) AFTER interest1;

ALTER TABLE my_contacts
ADD COLUMN interest3 VARCHAR(25) AFTER interest2;

ALTER TABLE my_contacts
ADD COLUMN interest4 VARCHAR(25) AFTER interest3;

SELECT *
FROM my_contacts;

UPDATE my_contacts
SET interest1='animals'
WHERE last_name='Sullivan' AND first_name='Regis';

UPDATE my_contacts
SET interest2='trading cards',interest3='geocaching'
WHERE last_name='Sullivan' AND first_name='Regis';


DESC my_contacts;