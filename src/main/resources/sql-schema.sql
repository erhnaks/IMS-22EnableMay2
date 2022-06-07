drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`item` (
   `item_id` INT NOT NULL AUTO_INCREMENT UNIQUE,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `price` FLOAT DEFAULT NULL,
    PRIMARY KEY (`item_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`order` (
`order_id` INT(11) NOT NULL AUTO_INCREMENT UNIQUE,
`customer_id` INT(11) NOT NULL,
PRIMARY KEY (`order_id`),
FOREIGN KEY(`customer_id`) REFERENCES `ims`.`customers`(id)
);

CREATE TABLE IF NOT EXISTS `ims`.`order_item` (
order_item_id INT(11) PRIMARY KEY AUTO_INCREMENT UNIQUE,
order_id INT(11) NOT NULL,
item_id INT(11) NOT NULL,
`quantity` INT NOT NULL,
`item_price` FLOAT NOT NULL, 
FOREIGN KEY (order_id) REFERENCES `ims`.`order`(order_id),
FOREIGN KEY (item_id) REFERENCES `ims`.`item`(item_id)
);
