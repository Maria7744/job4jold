CREATE TABLE company
(
id integer NOT NULL,
name character varying,
CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
id integer NOT NULL,
name character varying,
company_id integer,
CONSTRAINT person_pkey PRIMARY KEY (id)
);
INSERT INTO company (id, name) VALUES
(1, 'sber'),
(2, 'prima'),
(3, 'toy'),
(4, 'go'),
(5, 'google');

INSERT INTO person (id, name, company_id) VALUES
(1, 'Ivan', 1),
(2, 'Roy', 1),
(3, 'Alex', 2),
(4, 'Fedor', 2),
(5, 'Lena', 2),
(6, 'Anna', 3),
(7, 'Yan', 3),
(8, 'Kata', 4),
(9, 'Boby', 4),
(10, 'Sergey', 5);
--1) Retrieve in a single query:
-- names of all persons that are NOT in the company with id = 5
SELECT person.name, company.name FROM person
  LEFT JOIN company ON person.company_id = company.id
  WHERE company.id <>5;
  --или второй вариант:
  SELECT person.name, company.name FROM person
  LEFT JOIN company ON person.company_id = company.id
 WHERE NOT company.id = 5;
--// - company name for each person
SELECT *
FROM company as c
LEFT OUTER JOIN person as p
ON c.id=p.id;
--2) Select the name of the company with the maximum number of
-- persons + number of persons i
SELECT company.name, SUM(1) as persons FROM company
  LEFT JOIN person ON company.id = person.company_id
  GROUP BY (company.name) ORDER BY persons DESC LIMIT 1;
--этот почему-то не проходит
--2) Select the name of the company with the maximum number of persons + number of persons in this company
SELECT * FROM company as c
WHERE c.number person = (SELECT MAX(c.number person) FROM company c );

