-- INSERT INTO users (id, email, firstname, lastname, password)
-- VALUES (1, 'uinan@miu.edu', 'umur', 'inan', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
-- INSERT INTO users (id, email, firstname, lastname, password)
-- VALUES (2, 'john@miu.edu', 'john', 'doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
-- INSERT INTO users (id, email, firstname, lastname, password)
-- VALUES (3, 'dean@miu.edu', 'Dean', 'Altarawneh', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

-- INSERT INTO role (id, role)
-- VALUES (1, 'ADMIN');
-- INSERT INTO role (id, role)
-- VALUES (2, 'CLIENT');


-- INSERT INTO users_roles (user_id, roles_id)
-- VALUES (1, 1);
-- INSERT INTO users_roles (user_id, roles_id)
-- VALUES (2, 2);
-- INSERT INTO users_roles (user_id, roles_id)
-- VALUES (3, 2);


insert into product ( brand, category, count_in_stock, description, image, name, num_reviews, price, rating)
values ('Apple','Electronics',5,'Introducing the iPhone 11 Pro. A transformative triple-camera system that adds tons of capability without complexity. An unprecedented leap in battery life','/images/phone.jpg','Airpods Wireless Bluetooth Headphones',5,455,3.5);