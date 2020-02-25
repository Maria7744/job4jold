CREATE TABLE if NOT EXISTS type (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR (200) NOT NULL
);

CREATE TABLE if NOT EXISTS product (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR (200) NOT NULL,
	type_id INT REFERENCES type(id) NOT NULL,
	expired_date TIMESTAMP NOT NULL,
	price DECIMAL(6,2) NOT NULL
);

INSERT INTO type(name) VALUES ('drink');
INSERT INTO type(name) VALUES ('bread');
INSERT INTO type(name) VALUES ('meat');
INSERT INTO type(name) VALUES ('sweet');
INSERT INTO type(name) VALUES ('cheese');
INSERT INTO type(name) VALUES ('milk');

INSERT INTO product(name, type_id, expired_date, price) VALUES (
	'juse', 1, '2020-03-28 23:59:59', 096.00
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
	'mineralWater', 1, '2020-03-14 23:59:59', 030.52
);

INSERT INTO product(name, type_id, expired_date, price) VALUES (
	'homebread', 2, '2020-03-20 23:59:59', 030.00
);

INSERT INTO product(name, type_id, expired_date, price) VALUES (
	'pork', 3, '2020-03-11 23:59:59', 350.00
);

INSERT INTO product(name, type_id, expired_date, price) VALUES (
	'candy', 4, '2019-12-20 23:59:59', 052.43
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
	'crembrule ice cream', 4, '2020-03-12 23:59:59', 060.10
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
	'mango ice cream', 4, '2020-03-03 23:59:59', 044.43
);

INSERT INTO product(name, type_id, expired_date, price) VALUES (
	'poshehonskiy', 5, '2020-02-28 23:59:59', 106.42
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
	'parmigiano', 5, '2020-02-03 23:59:59', 212.34
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
	'altayherbal', 5, '2020-03-05 23:59:59', 190.12
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
	'roquefort', 5, '2020-04-28 23:59:59', 250.69
);

INSERT INTO product(name, type_id, expired_date, price) VALUES (
	'just a milk', 6, '2020-05-25 23:59:59', 052.20
);

-- Написать запрос получение всех продуктов с типом "СЫР"
SELECT *
FROM product as p
LEFT OUTER JOIN type as t
ON p.type_id=t.id
WHERE t.name = 'cheese';

-- Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT * FROM product
WHERE name LIKE '%ice cream%';

-- Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT * FROM product as p
WHERE p.expired_date BETWEEN date_trunc('month', CURRENT_DATE + interval '1' month)
and date_trunc('month', CURRENT_DATE + interval '2' month);

-- Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT * FROM product as p
WHERE p.expired_date BETWEEN '2020-03-01 00:00:00'
and '2020-03-31 23:59:59';

-- Написать запрос, который выводит самый дорогой продукт.
SELECT * FROM product as p
WHERE p.price = (SELECT MAX(p.price) FROM product p);

-- Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT COUNT(p.id)
FROM product as p
LEFT OUTER JOIN type as t
ON p.type_id=t.id
WHERE t.name = 'bread';

--Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT *
FROM product as p
LEFT OUTER JOIN type as t
ON p.type_id=t.id
WHERE t.name = 'cheese'
OR t.name='milk';

-- Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
SELECT t.name, COUNT(p.name)
FROM product as p
INNER JOIN
type as t
ON p.type_id = t.id
GROUP BY t.name
HAVING COUNT(p.name) < 10;

-- Вывести все продукты и их тип.
SELECT p.name, t.name
FROM product as p
INNER JOIN
type as t
ON p.type_id = t.id;