USE drinks;

SELECT *
FROM drink_info;

UPDATE drink_info
SET cost=cost+1
WHERE drink_name IN('Blue Moon','Oh My Gosh','Lime Fizz');

UPDATE drink_info
SET cost=cost+1
WHERE drink_name='Blue Moon' OR drink_name='Oh My Gosh' OR drink_name='Lime Fizz';

UPDATE drink_info
SET cost=cost*2
WHERE drink_name IN('Blue Moon','Oh My Gosh','Lime Fizz');