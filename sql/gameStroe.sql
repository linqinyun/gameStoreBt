CREATE DATABASE IF NOT EXISTS gamestroe DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE `gamestroe`;

CREATE TABLE IF NOT EXISTS `gs_product`
(
    `product_id`      INT(100) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `product_category_id`     INT(11) UNSIGNED  NULL COMMENT '分类ID',
    `name`            VARCHAR(100)      NOT NULL COMMENT '名称',
    `normal_price`    DECIMAL(10, 2)             DEFAULT 0.00 COMMENT '普通价格',
    `promotion_price` DECIMAL(10, 2)             DEFAULT 0.00 COMMENT '促销价格',
    `product_desc`    VARCHAR(2000)              DEFAULT NULL COMMENT '描述',
    `img_path`        VARCHAR(2000)              DEFAULT '' COMMENT '图片地址',
    `total`           int(10)                    DEFAULT '0' COMMENT '数量',
    `priority`        int(2)            NOT NULL DEFAULT '0' COMMENT '优先级',
    `is_active`       TINYINT(1)                 DEFAULT 0 COMMENT '是否上下架 0未上架默认，1上架展示',
    `create_time`     DATETIME                   DEFAULT NULL COMMENT '创建时间',
    `update_time`     DATETIME                   DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`product_id`),
    FOREIGN KEY `fk_category` (`product_category_id`) REFERENCES `gs_category` (`category_id`) ON DELETE SET NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `gs_category`
(
    `category_id`        INT(11) UNSIGNED NOT NULL COMMENT 'ID',
    `name`               VARCHAR(100)     NOT NULL COMMENT '名称',
    `parent_category_id` INT(11) UNSIGNED NOT NULL COMMENT '父ID',
    `create_time`        DATETIME DEFAULT NULL COMMENT '创建时间',
    `update_time`        DATETIME DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`category_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `gs_auth_user`
(
    `auth_id`     INT(100) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'auth_id',
    `username`    VARCHAR(100)      NOT NULL COMMENT '用户名',
    `password`    VARCHAR(100)      NOT NULL COMMENT '密码',
    `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
    `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`auth_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;