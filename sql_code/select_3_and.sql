CREATE TABLE doughnut_rating
(
	location VARCHAR(40) NOT NULL,
    time TIME NOT NULL,
    date DATE NOT NULL,
    type VARCHAR(40) NOT NULL,
    rating INT NOT NULL,
    comment VARCHAR(50) NOT NULL
);

DESC doughnut_rating;



INSERT INTO doughnut_rating
VALUES
('Starbuzz Coffee','07:43','2017-04-23','cinamon glazed',6,'too much spice');

INSERT INTO doughnut_rating
VALUES
('Duncan\'s Donuts','08:56','2017-08-25','plain glazed',5,'greasy');

INSERT INTO doughnut_rating
VALUES
('Duncan\'s Donuts','07:58','2017-04-26','jelly',6,'stale, but tasty');

INSERT INTO doughnut_rating
VALUES
('Starbuzz Coffee','10:35','2017-04-24','plain glazed',7,'warm, but not hot');

INSERT INTO doughnut_rating
VALUES
('Krispy King','09:39','2017-09-26','jelly',6,'not enough jelly');

INSERT INTO doughnut_rating
VALUES
('Starbuzz Coffee','07:48','2017-04-23','rocky road',10,'marshmallows!');

INSERT INTO doughnut_rating
VALUES
('Krispy King','08:56','2017-11-25','plain glazed',8,'maple syrup glaze');

INSERT INTO doughnut_rating
VALUES
('Duncan\'s Donuts','19:58','2017-06-26','rocky road',6,'stale, but tasty');

SELECT location,rating
FROM doughnut_rating
WHERE type='rocky road';

SELECT location,type
FROM doughnut_rating
WHERE rating=10;

SELECT location
FROM doughnut_rating
WHERE type='rocky road' AND rating=10;

SELECT *
FROM doughnut_rating;

