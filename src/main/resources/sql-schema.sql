drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS items (
   `item_id` INT AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `price` FLOAT(10,2),
    PRIMARY KEY (`item_id`)
);

CREATE TABLE IF NOT EXISTS orders (
`id` INT AUTO_INCREMENT,
`customer_id` INT,
total_price double(10,2),
quantity INt,
PRIMARY KEY (`id`),
FOREIGN KEY(`customer_id`) REFERENCES customers(id)
);

CREATE TABLE IF NOT EXISTS order_items (
id INT AUTO_INCREMENT,
item_id INT,
order_id INT,
PRIMARY KEY (id),
FOREIGN KEY (order_id) REFERENCES orders(id),
FOREIGN KEY (item_id) REFERENCES items(item_id)
);