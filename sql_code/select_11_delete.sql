USE gregs_list;

CREATE TABLE clown_info
(
	name VARCHAR(20) NOT NULL,
    last_seen VARCHAR(50) NOT NULL,
    appearance VARCHAR(50) NOT NULL,
    activities VARCHAR(50) NOT NULL
);

DESC clown_info;

SELECT *
FROM clown_info;

INSERT INTO clown_info
VALUES ('Elsie','Cherry Hill Senior Center','F,red hair,green dress,huge feet','balloons,little car');

INSERT INTO clown_info
VALUES ('Pickles','Jack Green\'s party','M,orange hair,blue suit,huge feet','mime');

INSERT INTO clown_info
VALUES ('Snuggles','Ball-Mart','F,yellow shirt,baggy red pants','horn,umbrella');


INSERT INTO clown_info
VALUES ('Mr. Hobo','BG Circus','M,cigar,black hair,tiny hat','violin');


INSERT INTO clown_info
VALUES ('Clarabelle','Belmont Senior Center','F,pink hair,huge flower,blue dress','yelling,dancing');


INSERT INTO clown_info
VALUES ('Scooter','Oakland Hospital','M,blue hair,red suit,huge nose','balloons');


INSERT INTO clown_info
VALUES ('Zippo','Millstone Mall','F,orange suit,baggy pants','dancing');


INSERT INTO clown_info
VALUES ('babe','Earl\'s Autos','F,all pink and sparkly','balancing,little car');


INSERT INTO clown_info
VALUES ('Bonzo','','M,in drag,polka dotted dress','singing, dancing');


INSERT INTO clown_info
VALUES ('Sniffles','Tracy\'s','M,green and purple suit,pointy nose','');

SELECT *
FROM clown_info;

INSERT INTO clown_info
VALUES('Zippo','Millstone Mall','F,orange suit,baggy pants','dancing,singing');


INSERT INTO clown_info
VALUES('Snuggles','Ball-Mart','F,yellow shirt,baggy blue pants','horn,umbrella');


INSERT INTO clown_info
VALUES('Bonzo','Dickson Park','M,in drag,polka dotted dress','singing,dancing');


INSERT INTO clown_info
VALUES('Sniffles','Tracy\'s','M,green and purple suit','climbing into tiny car');


INSERT INTO clown_info
VALUES('Mr. Hobo','party for Eric Gray','M,cigar,black hair,tiny hat','violin');

SELECT *
FROM clown_info
WHERE name='Zippo';

SELECT *
FROM clown_info;

DELETE FROM clown_info
WHERE name='Elsie' AND activities='balloons,little car';

DELETE 
FROM clown_info
WHERE name='Mr. Hobo' AND last_seen='BG Circus';

INSERT INTO clown_info
VALUES 
('Zippo','Oakland Hospital','F,orange suit,baggy pants','dancing,singing');

INSERT INTO clown_info
VALUES
('Clarabelle','Belmont Senior Center','F,pink hair,huge flower,blue dress','dancing');

DELETE FROM clown_info
WHERE name='Clarabelle' AND activities='yelling,dancing';