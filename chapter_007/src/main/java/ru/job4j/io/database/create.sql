CREATE DATABASE java_from_a_to_b;

CREATE TABLE roles (
    id serial primary key,
    name character varying(2000),
    description character varying(2000)
);

CREATE TABLE users (
    id serial primary key,
    name character varying(2000),
    login character varying(2000),
    password character varying(2000),
    create_date timestamp,
    role_id integer references roles(id),
    active boolean
);

CREATE TABLE rules (
    id serial primary key,
    name character varying(2000),
    description character varying(2000)
);

CREATE TABLE categories (
    id serial primary key,
    name character varying(2000)
);

CREATE TABLE states (
    id serial primary key,
    name character varying(2000)
);

CREATE TABLE items (
    id serial primary key,
    user_id integer references users(id),
    name character varying(2000),
    description character varying(2000),
    state_id integer references states(id),
    category_id integer references categories(id)
);

CREATE TABLE comments (
    id serial primary key,
    item_id integer references items(id),
    comment text,
    create_date timestamp
);

CREATE TABLE attachs (
    id serial primary key,
    item_id integer references items(id),
    name character varying(10000),
    path character varying(10000),
    create_date timestamp
);

CREATE TABLE roles_rules (
    id serial primary key,
    role_id integer references roles(id),
    rule_id integer references rules(id)
);

--RULES
INSERT INTO rules(name, description) VALUES ('CREATE_ITEM', 'Создание заявки в системе');
INSERT INTO rules(name, description) VALUES ('CHANGE_ITEM', 'Изменение заявки в системе');
INSERT INTO rules(name, description) VALUES ('DELETE_ITEM', 'Удаление заявки в системе');
INSERT INTO rules(name, description) VALUES ('VIEW_ITEM', 'Просмотр заявки в системе');
INSERT INTO rules(name, description) VALUES ('CHANGE_ITEM_STATUS', 'Смента статуса заявки в системе');
INSERT INTO rules(name, description) VALUES ('DELETE_ITEM_FILE', 'Удаление файлов из заявки в системе');
--ROLE
INSERT INTO roles(name, description) VALUES ('USER', 'Пользователь');
INSERT INTO roles(name, description) VALUES ('MANAGER', 'Менеджер');
INSERT INTO roles(name, description) VALUES ('ADMIN', 'Администратор');
--ROLES AND RULES
INSERT INTO roles_rules(role_id, rule_id) VALUES (1, 1);
INSERT INTO roles_rules(role_id, rule_id) VALUES (1, 2);
INSERT INTO roles_rules(role_id, rule_id) VALUES (1, 4);

INSERT INTO roles_rules(role_id, rule_id) VALUES (2, 1);
INSERT INTO roles_rules(role_id, rule_id) VALUES (2, 2);
INSERT INTO roles_rules(role_id, rule_id) VALUES (2, 3);
INSERT INTO roles_rules(role_id, rule_id) VALUES (2, 4);
INSERT INTO roles_rules(role_id, rule_id) VALUES (2, 5);

INSERT INTO roles_rules(role_id, rule_id) VALUES (3, 1);
INSERT INTO roles_rules(role_id, rule_id) VALUES (3, 2);
INSERT INTO roles_rules(role_id, rule_id) VALUES (3, 3);
INSERT INTO roles_rules(role_id, rule_id) VALUES (3, 4);
INSERT INTO roles_rules(role_id, rule_id) VALUES (3, 5);
INSERT INTO roles_rules(role_id, rule_id) VALUES (3, 6);
--USERS
INSERT INTO users(name, login, password, create_date, role_id, active) VALUES ('Андрей', 'userlogin', '1234', '2020-10-19 10:23:54', 1, true);
INSERT INTO users(name, login, password, create_date, role_id, active) VALUES ('Саша', 'managerlogin', '1234', '2020-11-19 10:23:54', 2, true);
INSERT INTO users(name, login, password, create_date, role_id, active) VALUES ('Антон', 'adminlogin', '1234', '2020-12-19 10:23:54', 3, true);
--STATES
INSERT INTO states(name) VALUES ('К выполнению');
INSERT INTO states(name) VALUES ('В работе');
INSERT INTO states(name) VALUES ('Готово');
--CATEGORIES
INSERT INTO categories(name) VALUES ('Баг');
INSERT INTO categories(name) VALUES ('Задача');
--ITEMS
INSERT INTO items(user_id, name, description, state_id, category_id) VALUES (2, 'Шэйринг задач', 'Добавить возможность делиться задачами', 1, 2);
INSERT INTO items(user_id, name, description, state_id, category_id) VALUES (1, 'Текст отображается с ошибкой', 'При чтении комментариев, текст отображается в другой кодировке', 2, 1);
--COMMENTS
INSERT INTO comments(item_id, comment, create_date) VALUES (1, 'Необходимо возможность делиться задачами, чтобы передавать их другим сотрудникам', '2020-06-19 10:23:54');
INSERT INTO comments(item_id, comment, create_date) VALUES (2,'Пример в скриншоте', '2020-11-19 10:23:00');
--ATTACHES
INSERT INTO attachs(item_id, name, path, create_date) VALUES (1, 'tz.txt', 'items/attachs/tasks', '2020-06-19 10:23:54');
INSERT INTO attachs(item_id, name, path, create_date) VALUES (2, 'picture.png', 'items/attachs/bags', '2020-11-19 10:23:00');