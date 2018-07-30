-- 90 - 100 discounts
insert into discount (id, name, percentage) values (90, 'standard 5%', 0.05);
insert into discount (id, name, percentage) values (91, 'old collection', 0.15);
insert into discount (id, name, percentage) values (92, 'sale 10%', 0.1);

-- 100 - 200 products
insert into product (id, name, description) values (100, 't-shirt awesome', 'foo bar description');
insert into product (id, name, description) values (101, 'pants awesome', 'foo bar description');
insert into product (id, name, description) values (102, 'body h&m', 'foo bar description');
insert into product (id, name, description) values (103, 'baby jacket', 'foo bar description');

-- 200 - 250 Users
insert into users (id, email, first_name, last_name, social_network) values (200, 'luckykeks@gmail.com', 'Gus', 'Petrovi4', 'https://vk.com/levasfx');

-- 1000 + store items
insert into store_item (id, item_price, discount_id, product_id) values (1000, 50.05, null, 100);
insert into store_item (id, item_price, discount_id, product_id) values (1001, 150.0, 92, 103);
insert into store_item (id, item_price, discount_id, product_id) values (1002, 60.48, null, 100);
insert into store_item (id, item_price, discount_id, product_id) values (1003, 69.99, 90, 101);
insert into store_item (id, item_price, discount_id, product_id) values (1004, 99.99, 91, 102);
insert into store_item (id, item_price, discount_id, product_id) values (1005, 94.40, 91, 102);

-- 2000 + variants
insert into store_product_variant (id, amount, size_id, store_id) values (2000, 4, null, 1000);
