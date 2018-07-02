/*Error Code: 1136. Column count doesn't match value count at row 1*/
INSERT INTO my_contacts
(
	last_name,first_name,email,gender,birthday,profession,location,status,interests,seeking
)
VALUES
(
	'Anderson','Jillian','jill_anderson@breakneckpizza.net','F','1980-09-05',
    'Technical Writer','Single','Kayaking,Reptiles','Relationship,Friends'
);

DESC my_contacts;

/*Error Code: 1136. Column count doesn't match value count at row 1*/
INSERT INTO my_contacts
(
	last_name,first_name,gender,birthday,profession,location,status,interests,seeking
)
VALUES
(
	'Anderson','Jillian','jill_anderson@breakneckpizza.net','F','1980-09-05',
    'Technical Writer','Paolo Alto,CA','Single','Kayaking,Reptiles','Relationship,Friends'
);

/*1 row(s) affected*/
INSERT INTO my_contacts
(
	last_name,first_name,email,gender,birthday,profession,location,status,interests,seeking
)
VALUES
(
	'Anderson','Jillian','jill_anderson@breakneckpizza.net','F','1980-09-05','Technical Writer',
    'Paolo Alto,CA','Single','Kayaking,Reptiles','Relationship,Friends'
);

/*Error code: 1064
You have an error in your SQL syntax;
check the manual that corresponds to your MySQL server version for the right syntax to
use near "Relationship,Friends)' at line 8*/
INSERT INTO my_contacts
(
	last_name,first_name,email,gender,birthday,profession,location,status,interests,seeking
)
VALUES
(
	'Anderson','Jillian','jill_anderson@breakneckpizza.net','F','1980-09-05','Technical Writer',
    'Paolo Alto,CA','Single','Kayaking,Reptiles','Relationship,Friends
);
