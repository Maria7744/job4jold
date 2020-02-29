CREATE DATABASE TABLECar;

CREATE TABLE if NOT EXISTS transmission (
	id SERIAL PRIMARY KEY NOT NULL,
	type VARCHAR (200) NOT NULL
);

CREATE TABLE if NOT EXISTS engine (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR (200) NOT NULL
);

CREATE TABLE if NOT EXISTS car_body (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR (100) NOT NULL
);

CREATE TABLE if NOT EXISTS car (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR (100) NOT NULL,
	id_transmission INT REFERENCES transmission(id) NOT NULL,
  id_engine INT REFERENCES engine(id) NOT NULL,
  id_car_body INT REFERENCES car_body(id) NOT NULL
);

INSERT INTO transmission(type) VALUES ('manual');
INSERT INTO transmission(type) VALUES ('robot');
INSERT INTO transmission(type) VALUES ('automatic');
INSERT INTO transmission(type) VALUES ('cvt');

INSERT INTO engine(name) VALUES ('gas');
INSERT INTO engine(name) VALUES ('diesel');
INSERT INTO engine(name) VALUES ('bensin');

INSERT INTO car_body(name) VALUES ('universal');
INSERT INTO car_body(name) VALUES ('picap');
INSERT INTO car_body(name) VALUES ('sedan');
INSERT INTO car_body(name) VALUES ('krosover');
INSERT INTO car_body(name) VALUES ('lefbec');

INSERT INTO car(name, id_transmission, id_engine, id_car_body)
VALUES ('granta', 1, 2, 1);
INSERT INTO car(name, id_transmission, id_engine, id_car_body)
VALUES ('porshe', 3, 2, 1);
INSERT INTO car(name, id_transmission, id_engine, id_car_body)
VALUES ('ford', 1, 2, 1);
INSERT INTO car(name, id_transmission, id_engine, id_car_body)
VALUES ('mersedes', 1, 3, 2);
INSERT INTO car(name, id_transmission, id_engine, id_car_body)
VALUES ('bmv', 1, 3, 2);

INSERT INTO car(name, id_transmission, id_engine, id_car_body)
VALUES ('lada vesta', 2, 3, 3);
INSERT INTO car(name, id_transmission, id_engine, id_car_body)
VALUES ('mazda3', 3, 3, 3);
INSERT INTO car(name, id_transmission, id_engine, id_car_body)
VALUES ('toyota corolla', 3, 3, 3);
INSERT INTO car(name, id_transmission, id_engine, id_car_body)
VALUES ('volkswagen passat', 3, 2, 3);

-- Вывести список всех машин и все привязанные к ним детали.
SELECT c.name, t.type, e.name, c_b.name
FROM car as c
LEFT OUTER JOIN transmission as t ON c.id_transmission=t.id
LEFT OUTER JOIN engine e ON c.id_engine=e.id
LEFT OUTER JOIN car_body c_b ON c.id_car_body=c_b.id;

-- Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
SELECT t.type
FROM car as c
RIGHT OUTER JOIN transmission as t ON c.id_transmission=t.id
WHERE c.id IS NULL;

	SELECT e.name
	FROM car as c
	RIGHT OUTER JOIN engine as e ON c.id_engine=e.id
	WHERE c.id IS NULL;

		SELECT c_b.name
		FROM car c

		RIGHT OUTER JOIN car_body c_b ON c.id_car_body=c_b.id
		WHERE c.id IS NULL;
//детали трансмиссии которые не используються в кузове
		SELECT t.type
                FROM transmission as t
                LEFT OUTER JOIN car_body as c_b ON c_b.id_transmission=t.id
                WHERE c_b.id IS NULL;
