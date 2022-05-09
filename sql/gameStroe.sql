CREATE DATABASE IF NOT EXISTS gamestroe DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS `product`
(
    `product_id`  INT UNSIGNED AUTO_INCREMENT,
    `name`        VARCHAR(100) NOT NULL,
    `create_time` datetime,
    `update_time` datetime
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `category`
(
    `product_id`  INT UNSIGNED AUTO_INCREMENT,
    `name`        VARCHAR(100) NOT NULL,
    `create_time` datetime,
    `update_time` datetime
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `admin_user`
(
    `product_id`  INT UNSIGNED AUTO_INCREMENT,
    `name`        VARCHAR(100) NOT NULL,
    `create_time` datetime,
    `update_time` datetime
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;