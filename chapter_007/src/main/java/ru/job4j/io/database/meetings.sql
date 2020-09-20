CREATE TABLE users
(
    id   serial primary key,
    name character varying(2000)
);

CREATE TABLE meetings
(
    id   serial primary key,
    name character varying(2000)
);

CREATE TABLE meetings_users
(
    id         serial primary key,
    meeting_id integer references meetings (id),
    user_id    integer references users (id),
    come       boolean
);

INSERT INTO users(name)
VALUES ('Андрей');
INSERT INTO users(name)
VALUES ('Александр');

INSERT INTO meetings(name)
VALUES ('IT-отдел');
INSERT INTO meetings(name)
VALUES ('Отдел продаж');
INSERT INTO meetings(name)
VALUES ('Встреча уборщиц');

INSERT INTO meetings_users(meeting_id, user_id, come)
VALUES (1, 1, true);
INSERT INTO meetings_users(meeting_id, user_id, come)
VALUES (1, 2, false);
INSERT INTO meetings_users(meeting_id, user_id, come)
VALUES (2, 1, true);
INSERT INTO meetings_users(meeting_id, user_id, come)
VALUES (2, 2, true);
-- 2. Нужно написать запрос, который получит список всех заяков и количество подтвердивших участников.
SELECT m.name as meeting_name, COUNT(*) as users_count
FROM meetings_users AS mu
         LEFT JOIN meetings AS m ON mu.meeting_id = m.id
WHERE mu.come IS TRUE
GROUP BY meeting_name;
-- 3. Нужно получить все совещания, где не было ни одной заявки на посещения
SELECT m.name as meeting_name, COUNT(mu.id) AS users_count
FROM meetings AS m
         LEFT JOIN meetings_users AS mu ON m.id = mu.meeting_id
WHERE mu.meeting_id IS NULL
GROUP BY m.name;