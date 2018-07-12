CREATE TABLE people
(
	id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    second_name VARCHAR(30) NOT NULL,
    PRIMARY KEY(id)
);

/*Works*/
INSERT INTO people
(id,first_name,second_name)
VALUES
(NULL,'Marcia','Brady');

/*Error: duplicate entry for primary key*/
INSERT INTO people
(id,first_name,second_name)
VALUES
(1,'Jan','Brady');

/*Works*/
INSERT INTO people
VALUES
(2,'Boby','Brady');

/*Error: column count doesn't match value count*/
INSERT INTO people
(first_name,second_name)
VALUES
('Cindy','Brady');

INSERT INTO people
(id,first_name,second_name)
VALUES
(99,'Peter','Brady');

SELECT *
FROM people;