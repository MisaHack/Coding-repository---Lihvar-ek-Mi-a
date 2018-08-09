/*Setting password for root user account*/
SET PASSWORD FOR 'root'@'localhost' = '1111';

/*Creating new user*/
CREATE USER misa
IDENTIFIED BY '11';

SELECT *
FROM my_contacts;

/*Granting SELECT statement to user 'misa'*/
GRANT SELECT ON
my_contacts
TO
misa;


/*Removing SELECT permision*/
REVOKE SELECT ON
my_contacts
FROM
misa;

/*We give ability to user to grant SELECT and DELETE to another user*/
GRANT SELECT,DELETE ON
my_contacts
TO
misa
WITH GRANT OPTION;

/*We remove DELETE granted option*/
REVOKE DELETE ON my_contacts FROM misa CASCADE;

/*We allow our user to use DELETE on all tables in our database*/
GRANT DELETE ON
*.*
TO
misa;

/*Creating role*/
CREATE ROLE new_role;

/*Adding privileges to our role*/
GRANT SELECT,INSERT ON
my_contacts
TO
new_role;

/*Adding role to user*/
GRANT new_role TO misa;

