CREATE TABLE interests
(
	int_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    interest VARCHAR(50) NOT NULL,
    /*foreign key name, INT, NOT NULL*/
    contact_id INT NOT NULL, 
    /*name of the table where key comes from+name of the key+type: foreign key*/
    CONSTRAINT my_contacts_contact_id_fk
    /*column name in parenthesis is name of what will become foreign key*/
    FOREIGN KEY(contact_id)
    /*where foreign key comes from and what is its name in other table*/
    REFERENCES my_contacts(contact_id)
);

DESC interests;