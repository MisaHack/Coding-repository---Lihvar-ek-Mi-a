SELECT *
FROM my_contacts;

/*FIRST - keyword says column will be first in table*/
ALTER TABLE my_contacts
ADD COLUMN contact_id INT NOT NULL AUTO_INCREMENT FIRST,
ADD PRIMARY KEY(contact_id);

CREATE TABLE projekts
(
	number INT,
    descriptionofproj VARCHAR(40),
    contractorofjob VARCHAR(40)
);

INSERT INTO projekts
VALUES
(1,'outside house painting','Murpfy'),
(2,'kitchen remodel','Valdez'),
(3,'wood floor instalation','Keller'),
(4,'roofing','Jackson');

SELECT *
FROM projekts;

DESC projekts;

/*Renaming table with RENAME TO*/
ALTER TABLE projekts
RENAME TO project_list;

SELECT *
FROM project_list;

/*CHANGE - changes column name and it's type*/
ALTER TABLE project_list
CHANGE COLUMN number project_id INT NOT NULL AUTO_INCREMENT,
ADD PRIMARY KEY(project_id);

DESC project_list;

/*Changing two column names and types at the same time*/
ALTER TABLE project_list
CHANGE COLUMN descriptionofproj project_description VARCHAR(100) NOT NULL,
CHANGE COLUMN contractorofjob company_name VARCHAR(30) NOT NULL;

/*Modify - changes only type or position of column without changin name*/
ALTER TABLE project_list
MODIFY COLUMN project_description VARCHAR(120) NOT NULL;

/*Adding 3 more columns to our table*/
ALTER TABLE project_list
ADD COLUMN phone_number VARCHAR(50) NOT NULL,
ADD COLUMN start_date DATE NOT NULL,
ADD COLUMN estimated_cost DEC(9,2) NOT NULL;

/*DROP - removing column from table*/
ALTER TABLE project_list
DROP phone_number;

