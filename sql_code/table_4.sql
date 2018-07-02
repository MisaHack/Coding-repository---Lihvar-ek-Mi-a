CREATE TABLE doughnut_list
(
	doughnut_name VARCHAR(10) NOT NULL, 
    doughnut_type VARCHAR(10) NOT NULL,
    doughnut_cost DEC(3,2) NOT NULL DEFAULT 1.00
);

DESC doughnut_list;

SELECT *
FROM doughnut_list;

INSERT INTO doughnut_list
(doughnut_name, doughnut_type,doughnut_cost)
VALUES
('Blooberry','filled',4.00);

INSERT INTO doughnut_list
(doughnut_name, doughnut_type)
VALUES
('Cinnamondo','ring');

INSERT INTO doughnut_list
(doughnut_name, doughnut_type)
VALUES
('Rockstar','cruller');

INSERT INTO doughnut_list
(doughnut_name, doughnut_type)
VALUES
('Carameller','cruller');

INSERT INTO doughnut_list
(doughnut_name,doughnut_type,doughnut_cost)
VALUES
('Appleblush','filled',1.45);