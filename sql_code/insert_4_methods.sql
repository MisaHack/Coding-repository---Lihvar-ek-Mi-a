/*Changing order of columns*/
INSERT INTO my_contacts
(
	interests,first_name,last_name,gender,email,birthday,profession,location,status,seeking
)
VALUES
(
	'Masine,Poljoprivreda','Franja','Lihvarcek','M','franjalihvarcek@yahoo.com',
    '1965-05-31','Zemljoradnik','Maradik,RS','Ozenjen','Trgovina,Poznanstva'
);

/*Ommiting column names*/
INSERT INTO my_contacts
VALUES
(
	'Boris','Lihvarcek','M','lihvarcekboris@gmail.com','1997-03-31','Student','Maradik,RS',
    'U vezi','Pcelarstvo,Automobili','Diploma'
);

/*Leaving some columns out*/
INSERT INTO my_contacts
(
	last_name,first_name,gender
)
VALUES
(
	'Jovanovic','Marko','M'
);