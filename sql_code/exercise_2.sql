USE gregs_list;

SELECT *
FROM doughnut_rating;

SELECT type
FROM doughnut_rating
WHERE location='Krispy King' AND rating <> 6;

SELECT type
FROM doughnut_rating
WHERE location='Krispy King' AND rating=3;

SELECT type
FROM doughnut_rating
WHERE location='Snappy Bagel' AND rating >= 6;

SELECT type
FROM doughnut_rating
WHERE location='Krispy King' OR rating > 5;

SELECT type
FROM doughnut_rating
WHERE location='Krispy King' OR rating=3;

SELECT type
FROM doughnut_rating
WHERE location='Snappy Bagiel' OR rating=6;