-- 90 - 100 discounts
insert into discount (id, name, percentage) values (90, 'standard 5%', 0.05);
insert into discount (id, name, percentage) values (91, 'old collection', 0.15);
insert into discount (id, name, percentage) values (92, 'sale 10%', 0.1);

-- 100 - 200 product_meta
insert into product_meta (id, name, description) values (100, 'apple', 'very useful popular fruit');
insert into product_meta (id, name, description) values (101, 'banana', 'african banana is sweet and tasty');
insert into product_meta (id, name, description) values (102, 'grape', 'Usually people make vine from grapes');
insert into product_meta (id, name, description) values (103, 'cucumber', 'Contains 90% of water');

-- 1000 - 2000 product_store
insert into product_store (id, price, product_meta_id) values (1000, 10.74, 100);
insert into product_store (id, price, product_meta_id) values (1001, 75.45, 101);
insert into product_store (id, price, product_meta_id) values (1002, 88.90, 102);
insert into product_store (id, price, product_meta_id) values (1003, 11.13, 103);


-- 200 - 250 Users
insert into users (id, email, first_name, last_name, social_network) values (200, 'luckykeks@gmail.com', 'Gus', 'Petrovi4', 'https://vk.com/levasfx');
