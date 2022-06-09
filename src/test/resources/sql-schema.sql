
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








