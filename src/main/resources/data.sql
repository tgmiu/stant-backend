insert into public.role ( role) values ('ADMIN');
insert into public.role ( role) values ('BUYER');
insert into public.role ( role)values ('SELLER');

insert into users  (email,name, address,city,country,postal_code,is_active) values('john@example.com','John Doe','1000 N 4th','Fairfield','USA','111',true);
insert into users_roles values(1,1);

insert into product ( brand, category, count_in_stock, description, image, name, num_reviews, price)
values ('Cannon','Electronics',5,'Characterized by versatile imaging specs, the Canon EOS 80D further clarifies itself using a pair of robust focusing systems and an intuitive design','/images/camera.jpg','Cannon EOS 80D DSLR Camera',5, 929.99);

insert into product ( brand, category, count_in_stock, description, image, name, num_reviews, price)
values ('Apple','Electronics',8,'Introducing the iPhone 11 Pro. A transformative triple-camera system that adds tons of capability without complexity. An unprecedented leap in battery life','/images/phone.jpg','Airpods Wireless Bluetooth Headphones',5,455);

insert into orders (created_at, is_paid, is_delivered,shipping_price,tax_price, total_price, payment_method,items_price, user_id) VALUES (now(), true, true, 10,1.5,11.5,'PayPal',33, 1);

insert into item( image, name, price, qty, order_id) VALUES ('/images/airpods.jpg','Airpods Wireless Bluetooth Headphones',586,2,1);

insert into review ( comment, is_approved, rating, user_id, product_id, created_at)
values ('Very good product', true, 4,1,1, now());