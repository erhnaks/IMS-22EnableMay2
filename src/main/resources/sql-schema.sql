drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
   `item_id` INT NOT NULL AUTO_INCREMENT UNIQUE,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `price` FLOAT DEFAULT NULL,
    PRIMARY KEY (`item_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
`orders_id` INT(11) NOT NULL AUTO_INCREMENT UNIQUE,
`customer_id` INT(11) NOT NULL,
PRIMARY KEY (`orders_id`),
FOREIGN KEY(`customer_id`) REFERENCES `ims`.`customers`(id)
);

CREATE TABLE IF NOT EXISTS `ims`.`order_items` (
order_items_id INT(11) PRIMARY KEY AUTO_INCREMENT UNIQUE,
orders_id INT(11) NOT NULL,
item_id INT(11) NOT NULL,
`quantity` INT NOT NULL,
`item_price` FLOAT NOT NULL, 
FOREIGN KEY (orders_id) REFERENCES `ims`.`orders`(orders_id),
FOREIGN KEY (item_id) REFERENCES `ims`.`items`(item_id)
);