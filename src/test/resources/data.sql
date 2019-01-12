-- 51 - 100 discounts
insert into discount (id, name, percentage) values (51, 'standard 5%', 0.05);
insert into discount (id, name, percentage) values (52, 'old collection', 0.15);
insert into discount (id, name, percentage) values (53, 'sale 10%', 0.1);

-- 2000 - 3000 categories
insert into category (id, name) values (2000, 'Fruits');
insert into category (id, name) values (2001, 'Vegetables');

-- 100 - 1000 product_meta
insert into product_meta (id, name, description, category_id) values (100, 'apple', 'very useful popular fruit', 2000);
insert into product_meta (id, name, description, category_id) values (101, 'banana', 'african banana is sweet and tasty', 2000);
insert into product_meta (id, name, description, category_id) values (102, 'grape', 'Usually people make vine from grapes', 2000);
insert into product_meta (id, name, description, category_id) values (103, 'orange', 'Tasty juice are made of this', 2000);

insert into product_meta (id, name, description, category_id) values (104, 'Огурчик', 'на 90% состоит из воды', 2001);
insert into product_meta (id, name, description, category_id) values (105, 'Помидор', 'Очень сочный овощ', 2001);
insert into product_meta (id, name, description, category_id) values (106, 'Чеснок', 'Обладает дезинфицирующими свойствами', 2001);
insert into product_meta (id, name, description, category_id) values (107, 'Лук', 'Лучще добавлять в поджарку', 2001);
insert into product_meta (id, name, description, category_id) values (108, 'Морковь', 'Очень полезный овощ', 2001);


-- 10000 - 20000 product_store
insert into product_store (id, price, product_meta_id) values (10000, 10.74, 100);
insert into product_store (id, price, product_meta_id) values (10001, 75.45, 101);
insert into product_store (id, price, product_meta_id) values (10002, 88.90, 102);
insert into product_store (id, price, product_meta_id) values (10003, 11.13, 103);


-- 200 - 250 Users
insert into users (id, email, first_name, last_name, social_network) values (200, 'luckykeks@gmail.com', 'Gus', 'Petrovi4', 'https://vk.com/levasfx');
