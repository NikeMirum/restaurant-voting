INSERT INTO USERS (name, email, password)
VALUES ('User', 'user@yandex.ru', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO USER_ROLES (role, user_id)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

INSERT INTO RESTAURANT (name)
VALUES ('McDonalds'),
       ('KFC'),
       ('Burger King');

INSERT INTO DISH (name, price, date_entry, restaurant_id)
VALUES ('Big Tasty', '249', CURRENT_DATE, '1'),
       ('Nuggets', '69', CURRENT_DATE, '1'),
       ('Sprite M', '75', CURRENT_DATE, '1'),
       ('Boxmaster', '199', CURRENT_DATE, '2'),
       ('6 Stripes', '214', CURRENT_DATE, '2'),
       ('Pepsi M', '79', CURRENT_DATE, '2'),
       ('Whopper', '189', CURRENT_DATE, '3'),
       ('9 Onion Rings', '129', CURRENT_DATE, '3'),
       ('Diet Coke M', '119', CURRENT_DATE, '3'),
       ('BigMac', '301', '2021-09-01', '1'),
       ('Fries', '201', '2021-09-01', '1'),
       ('Cola', '101', '2021-09-01', '1'),
       ('Twister', '302', '2021-09-01', '2'),
       ('Fries', '202', '2021-09-01', '2'),
       ('Cola', '102', '2021-09-01', '2');

INSERT INTO VOTE (date_entry, restaurant_id, user_id)
VALUES ('2021-09-01', '1', '1'),
       ('2021-09-01', '1', '2'),
       (CURRENT_DATE, '1', '1');