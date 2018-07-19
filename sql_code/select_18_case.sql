CREATE TABLE movie_table
(
	movie_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(40) NOT NULL,
    rating CHAR(1) NOT NULL,
    drama CHAR(1) NOT NULL,
    comedy CHAR(1) NOT NULL,
    action CHAR(1) NOT NULL,
    gore CHAR(1) NOT NULL,
    scifi CHAR(1) NOT NULL,
    for_kids CHAR(1) NOT NULL,
    cartoon CHAR(1) NOT NULL,
    purchased DATE NOT NULL,
	PRIMARY KEY(movie_id)
);

DESC movie_table;

SELECT *
FROM movie_table;

ALTER TABLE movie_table
MODIFY rating CHAR(2);

INSERT INTO movie_table
(title,rating,drama,comedy,action,gore,scifi,for_kids,cartoon,purchased)
VALUES
('Monsters, Inc.','G','F','T','F','F','F','T','T','2002-03-06'),
('The Godfather','R','F','F','T','T','F','F','F','2001-02-05'),
('Gone with the Wind','G','T','F','F','F','F','F','F','1999-11-20'),
('American Pie','R','F','T','F','F','F','F','F','2003-04-19'),
('Nightmare on Elm Street','R','F','F','T','T','F','F','F','2003-04-19'),
('Casablanca','PG','T','F','F','F','F','F','F','2001-02-05');

DELETE FROM movie_table;

ALTER TABLE movie_table
ADD COLUMN categories VARCHAR(20);

UPDATE movie_table
SET categories=
CASE
	WHEN drama='T' THEN 'drama'
    WHEN comedy='T' THEN 'comedy'
    WHEN action='T' THEN 'action'
    WHEN gore='T' THEN 'horror'
    WHEN scifi='T' THEN 'scifi'
    WHEN for_kids='T' THEN 'family'
    WHEN cartoon='T' THEN 'cartoon'
    ELSE 'misc'
END;

INSERT INTO movie_table
(title,rating,drama,comedy,action,gore,scifi,for_kids,cartoon,purchased)
VALUES
('Big Adventure','PG','F','F','F','F','F','F','T','2018-01-01'),
('Greg: The Untold Story','PG','F','F','T','F','F','F','F','2018-01-01'),
('Mad Clowns','R','F','F','F','T','F','F','F','2018-01-01'),
('Paraskavedekatriaphobia','R','T','T','T','F','T','F','F','2018-01-01'),
('Rat named Darcy, A','G','F','F','F','F','F','T','F','2018-01-01'),
('End of the Line','R','T','F','F','T','T','F','T','2018-01-01'),
('Shiny Things,The','PG','T','F','F','F','F','F','F','2018-01-01'),
('Take it Back','R','F','T','F','F','F','F','F','2018-01-01'),
('Shark bait','G','F','F','F','F','F','T','F','2018-01-01'),
('Angry Pirate','PG','F','T','F','F','F','F','T','2018-01-01'),
('Potentially Habitable Planet','PG','F','T','F','F','T','F','F','2018-01-01');


SELECT *
FROM movie_table
WHERE categories='comedy';