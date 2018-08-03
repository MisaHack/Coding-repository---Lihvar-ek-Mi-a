SELECT *
FROM my_contacts;

/*longer way to make name aliases*/
SELECT first_name AS fn
FROM my_contacts AS mc
GROUP BY fn
ORDER BY fn;

SELECT first_name fn
FROM my_contacts mc
GROUP BY fn
ORDER BY fn;