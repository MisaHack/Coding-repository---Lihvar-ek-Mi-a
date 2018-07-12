SELECT *
FROM doughnut_rating;

UPDATE doughnut_rating
SET rating=5
WHERE comment='too much spice';

SELECT *
FROM clown_info;

SELECT activities
FROM clown_info
WHERE name='Sniffles' AND appearance='M,green and purple suit,pointy nose';

UPDATE clown_info
SET activities='updated_value'
WHERE name='Sniffles' AND appearance='M,green and purple suit,pointy nose';

SELECT name,last_seen
FROM clown_info
WHERE last_seen = '';

UPDATE clown_info
SET last_seen = 'new info 2'
WHERE last_seen = '';