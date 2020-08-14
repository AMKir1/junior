CREATE DATABASE cars_db;

CREATE TABLE bodywork (
    id serial primary key,
    name varchar(200)
);

CREATE TABLE engine (
    id serial primary key,
    name varchar(200)
);

CREATE TABLE transmission (
    id serial primary key,
    name varchar(200)
);

CREATE TABLE cars (
    id serial primary key,
    name varchar(200),
    bodywork_id integer references bodywork(id),
    engine_id integer references engine(id),
    transmission_id integer references transmission(id)
);

INSERT INTO bodywork(name) VALUES ('Кузов_1');
INSERT INTO bodywork(name) VALUES ('Кузов_2');
INSERT INTO bodywork(name) VALUES ('Кузов_3');
INSERT INTO bodywork(name) VALUES ('Кузов_4');

INSERT INTO engine(name) VALUES ('Двигатель_1');
INSERT INTO engine(name) VALUES ('Двигатель_2');
INSERT INTO engine(name) VALUES ('Двигатель_3');
INSERT INTO engine(name) VALUES ('Двигатель_4');

INSERT INTO transmission(name) VALUES ('Коробка_передач_1');
INSERT INTO transmission(name) VALUES ('Коробка_передач_2');
INSERT INTO transmission(name) VALUES ('Коробка_передач_3');
INSERT INTO transmission(name) VALUES ('Коробка_передач_4');
INSERT INTO transmission(name) VALUES ('Коробка_передач_5');

INSERT INTO cars(name, bodywork_id, engine_id, transmission_id) VALUES ('Машина_1', 1, 1, 1);
INSERT INTO cars(name, bodywork_id, engine_id, transmission_id) VALUES ('Машина_2', 2, 2, 2);
INSERT INTO cars(name, bodywork_id, engine_id, transmission_id) VALUES ('Машина_3', 3, 3, 3);

--Вывести список всех машин и все привязанные к ним детали.
SELECT c.name AS name, b.name AS bodywork, e.name AS engine, t.name AS transmission FROM cars AS c
    LEFT OUTER JOIN bodywork AS b ON c.bodywork_id = b.id
    LEFT OUTER JOIN engine AS e ON c.engine_id = e.id
    LEFT OUTER JOIN transmission AS t ON c.transmission_id = t.id;

--Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
SELECT coalesce(b.name, '') AS bodywork, coalesce(e.name, '') AS engine, coalesce(t.name, '') AS transmission FROM cars AS c
    FULL OUTER JOIN bodywork AS b ON c.bodywork_id = b.id
    FULL OUTER JOIN engine AS e ON c.engine_id = e.id
    FULL OUTER JOIN transmission AS t ON c.transmission_id = t.id
WHERE c.name IS NULL
