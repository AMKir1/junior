-- Фильтры [#1732]

--   product(id, name, type_id, expired_date, price)
--   type(id, name)

-- 1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT * FROM product AS p INNER JOIN type AS t ON p.type_id = t.id WHERE t.name = 'СЫР' ;

-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT * FROM product WHERE name LIKE '%мороженное%';

-- 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT * FROM product WHERE expired_date BETWEEN (DATE_TRUNC('month', CURRENT_DATE) + interval '1 month' - interval '1 day') AND (DATE_TRUNC('month', CURRENT_DATE) + interval '2 month' - interval '1 day');

-- 4. Написать запрос, который выводит самый дорогой продукт.
SELECT * FROM product ORDER BY price DESC LIMIT 1;

-- 5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT COUNT(id) FROM product WHERE type_id = 1;

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT p.name AS name, p.expired_date AS expired_date, p.price AS price, t.name AS type FROM product AS p INNER JOIN type AS t ON p.type_id = t.id WHERE t.name = 'СЫР' OR t.name = 'МОЛОКО';

-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.

-- 8. Вывести все продукты и их тип.
SELECT p.name AS name, t.name AS type FROM product AS p LEFT JOIN type AS t ON p.type_id = t.id;