SELECT *
FROM clown_info_new;

SELECT c1.name, (SELECT name FROM clown_info_new WHERE c1.boss_id = id) AS boss
FROM clown_info_new c1;

SELECT *
FROM my_contacts;

SELECT COUNT(gender) AS Females
FROM my_contacts
WHERE gender='F';

SELECT COUNT(gender) AS Males
FROM my_contacts
WHERE gender='M';

SELECT COUNT(gender) AS Total
FROM my_contacts;