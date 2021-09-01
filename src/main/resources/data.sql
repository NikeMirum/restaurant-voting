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
       ('Burger King'),
       ('Subway'),
       ('Pizza Hut');

INSERT INTO DISH (name, price, date, restaurant_id)
VALUES ('Big Tasty', '249', CURRENT_DATE(), '1'),
       ('Fries M', '67', CURRENT_DATE(), '1'),
       ('Coca-Cola M', '75', CURRENT_DATE(), '1'),
       ('Boxmaster', '199', CURRENT_DATE(), '2'),
       ('6 Stripes', '214', CURRENT_DATE(), '2'),
       ('Pepsi M', '249', CURRENT_DATE(), '2'),
       ('Whopper', '189', CURRENT_DATE(), '3'),
       ('9 Onion Rings', '129', CURRENT_DATE(), '3'),
       ('Diet Coke M', '119', CURRENT_DATE(), '3'),
       ('Sandwich', '299', CURRENT_DATE(), '4'),
       ('Cookie', '99', CURRENT_DATE(), '4'),
       ('Fuze tea', '99', CURRENT_DATE(), '4'),
       ('Pizza', '299', CURRENT_DATE(), '5'),
       ('Nuggets', '99', CURRENT_DATE(), '5'),
       ('Aqua Minerale', '89', CURRENT_DATE(), '5');