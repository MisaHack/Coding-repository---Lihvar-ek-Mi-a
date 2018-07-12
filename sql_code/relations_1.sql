USE gregs_list;

CREATE TABLE fish_info
(
	common VARCHAR(40) NOT NULL,
    species VARCHAR(30) NOT NULL,
    location VARCHAR(40) NOT NULL,
    weight VARCHAR(30) NOT NULL
);

DESC fish_info;

INSERT INTO fish_info
VALUES
('bass,largemouth','M. salmoides','Montgomery Lake,GA','22 lb 4 oz'),
('walleye','S. vitreus','Old Hickory Lake,TN','22 lb 4 oz'),
('trout,cutthroat','O. Clarki','Pyramid Lake,NV','41 lb 0 oz'),
('perch,yellow','P. Flavescent','Bordentown,NJ','4 lb 3 oz'),
('bluegill','L. Macrochirus','Ketona Lake,AL','4 lb 13 oz'),
('gar,longnose','L. Osseus','Trinity River,TX','50 lb 5 oz'),
('crappie,white','P. annularis','Enid Dam,MS','5 lb 3 oz'),
('pickerel,grass','E. americanus','Dewart Lake,IN','1 lb 0 oz'),
('goldfish','C. auratus','Lake Hodges,CA','6 lb 10 oz'),
('salmon,chinook','O. Tshawytscha','Kenai River,AK','97 lb 4 oz');

SELECT *
FROM fish_info;

CREATE TABLE fish_records
(
	first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    common VARCHAR(40) NOT NULL,
    location VARCHAR(40) NOT NULL,
    state CHAR(3) NOT NULL,
    weight VARCHAR(20) NOT NULL,
    date DATE NOT NULL
);

DROP TABLE fish_records;

DESC fish_records;

INSERT INTO fish_records
VALUE
('George','Perry','bass,largemouth','Montgomery Lake','GA','22 lb 4 oz','1932-6-2');

SELECT *
FROM fish_records;

INSERT INTO fish_records
VALUE
('Mabry','Harper','walleye','Old Hickory Lake','TN','25 lb 0 oz','1960-08-02'),
('John','Skimmerhorn','trout,cutthroat','Pyramid Lake','NV','41 lb 0 oz','1925-12-01'),
('C.C.','Abbot','perch,yellow','Bordentown','NJ','4 lb 3 oz','1865-05-01'),
('T.S.','Hudson','bluegill','Ketona Lake','AL','4 lb 12 oz','1950-04-09'),
('Townsend','Miller','gar,longnose','Trinity River','TX','50 lb 5 oz','1954-07-30'),
('Fred','Bright','crappie,white','Enid Dam','MS','5 lb 3 oz','1957-07-31'),
('Mike','Berg','pickerel,grass','Dewart Lake','IN','1 lb 0 oz','1990-06-09'),
('Florentino','Abena','goldfish','Lake Hodges','CA','6 lb 10 oz','1996-04-17'),
('Les','Anderson','salmon,chinook','Kenai River','AK','97 lb 4 oz','1985-05-17');

SELECT *
FROM fish_info
WHERE location LIKE '%NJ';

SELECT *
FROM fish_records
WHERE state = 'NJ';