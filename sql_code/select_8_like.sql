SELECT *
FROM my_contacts;

/*Any number of unknown character before 'CA'*/
SELECT *
FROM my_contacts
WHERE location LIKE '%CA';

/*Any number of unknown character before 'a'*/
SELECT *
FROM my_contacts
WHERE first_name LIKE '%a';

/*Just one character before 'om'*/
SELECT *
FROM my_contacts
WHERE first_name LIKE '_om';