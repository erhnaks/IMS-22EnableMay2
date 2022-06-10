DROP TABLE IF EXISTS `order_items`;

DROP TABLE IF EXISTS `orders`;

DROP TABLE IF EXISTS `customers`;

DROP TABLE IF EXISTS `items`;





CREATE TABLE IF NOT EXISTS `customers` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(40) DEFAULT NULL,
`surname` VARCHAR(40) DEFAULT NULL,
PRIMARY KEY (`id`)
);




CREATE TABLE IF NOT EXISTS `items` (
`item_id` INT not null AUTO_INCREMENT,
`item_name` VARCHAR(40) DEFAULT NULL,
`price` FLOAT,
PRIMARY KEY (`item_id`)
);



CREATE TABLE IF NOT EXISTS orders (
`id` INT AUTO_INCREMENT,
`customer_id` INT,
total_price double,
quantity INt,
PRIMARY KEY (`id`),
FOREIGN KEY(`customer_id`) REFERENCES customers(id) ON DELETE CASCADE
);



CREATE TABLE IF NOT EXISTS order_items (
id INT AUTO_INCREMENT,
item_id INT,
order_id INT,
PRIMARY KEY (id),
FOREIGN KEY (order_id) REFERENCES orders(id ON DELETE CASCADE),
FOREIGN KEY (item_id) REFERENCES items(item_id) ON DELETE CASCADE
);




