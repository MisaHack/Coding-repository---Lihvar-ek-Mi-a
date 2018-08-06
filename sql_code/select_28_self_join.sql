CREATE TABLE clown_info_new
(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    boss_id INT NOT NULL
    /*FOREIGN KEY (boss_id)
    REFERENCES clown_info_new(id)*/
);

SELECT *
FROM clown_info_new;

INSERT INTO clown_info_new
(name,boss_id)
VALUES
('Elsie',3),
('Pickles',5),
('Snuggles',10),
('Mr. Hobo',3),
('Clarabelle',10),
('Scooter',3),
('Zippo',3),
('Babe',5),
('Bonzo',5),
('Mister Sniffles',10);

DROP TABLE clown_info_new;

/*Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails (`gregs_list`.`clown_info_new`, CONSTRAINT `clown_info_new_ibfk_1` FOREIGN KEY (`boss_id`) REFERENCES `clown_info_new` (`id`))*/

SELECT c1.name, c2.name AS boss_name
FROM clown_info_new c1 INNER JOIN clown_info_new c2
WHERE c1.boss_id = c2.id;