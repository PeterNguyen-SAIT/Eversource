/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.29-log : Database - eversourcedb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`eversourcedb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `eversourcedb`;

/*Table structure for table `discounts` */

DROP TABLE IF EXISTS `discounts`;

CREATE TABLE `discounts` (
  `discount_id` int(10) NOT NULL AUTO_INCREMENT,
  `discount_name` varchar(20) NOT NULL,
  `discount_rate` double NOT NULL DEFAULT '0',
  `description` varchar(100) DEFAULT NULL,
  `expiry_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`discount_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `discounts` */

insert  into `discounts`(`discount_id`,`discount_name`,`discount_rate`,`description`,`expiry_date`) values (1,'no discount',0,NULL,'2020-05-12 10:25:14');
insert  into `discounts`(`discount_id`,`discount_name`,`discount_rate`,`description`,`expiry_date`) values (2,'summer discount',0.05,'summer','2020-05-30 10:25:18');
insert  into `discounts`(`discount_id`,`discount_name`,`discount_rate`,`description`,`expiry_date`) values (3,'final sale',0.2,'final sale','2020-05-12 10:33:03');

/*Table structure for table `events` */

DROP TABLE IF EXISTS `events`;

CREATE TABLE `events` (
  `event_id` int(10) NOT NULL AUTO_INCREMENT,
  `event_title` varchar(50) NOT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `events` */

insert  into `events`(`event_id`,`event_title`,`Description`,`start_date`,`end_date`) values (1,'Pick Yours','Free','2020-05-12 11:52:47','2020-05-29 11:52:41');
insert  into `events`(`event_id`,`event_title`,`Description`,`start_date`,`end_date`) values (2,'Free onion event','Come and get free onion.','2020-06-01 14:11:05','2020-06-30 14:11:10');

/*Table structure for table `inventories` */

DROP TABLE IF EXISTS `inventories`;

CREATE TABLE `inventories` (
  `inventory_id` int(10) NOT NULL AUTO_INCREMENT,
  `product_id` int(10) NOT NULL,
  `stock` int(10) NOT NULL DEFAULT '0',
  `location` varchar(10) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`inventory_id`,`product_id`),
  KEY `productId` (`product_id`),
  CONSTRAINT `inventories_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `inventories` */

insert  into `inventories`(`inventory_id`,`product_id`,`stock`,`location`,`note`) values (1,1,20,'layer 1','green house #1');
insert  into `inventories`(`inventory_id`,`product_id`,`stock`,`location`,`note`) values (2,2,100,'layer 2','new produced');
insert  into `inventories`(`inventory_id`,`product_id`,`stock`,`location`,`note`) values (3,3,50,'layer 3','green house #3');
insert  into `inventories`(`inventory_id`,`product_id`,`stock`,`location`,`note`) values (4,4,100,'layer 4','green house #4');

/*Table structure for table `order_details` */

DROP TABLE IF EXISTS `order_details`;

CREATE TABLE `order_details` (
  `order_detail_id` int(10) NOT NULL AUTO_INCREMENT,
  `product_id` int(10) NOT NULL,
  `quantity` int(10) NOT NULL,
  `note` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`order_detail_id`),
  KEY `productId` (`product_id`),
  CONSTRAINT `order_details_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `order_details` */

insert  into `order_details`(`order_detail_id`,`product_id`,`quantity`,`note`) values (1,1,2,NULL);
insert  into `order_details`(`order_detail_id`,`product_id`,`quantity`,`note`) values (2,2,10,NULL);

/*Table structure for table `products` */

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `product_id` int(10) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(20) NOT NULL,
  `unit` varchar(10) NOT NULL DEFAULT 'lb',
  `price` double NOT NULL DEFAULT '0',
  `discount_id` int(10) NOT NULL DEFAULT '1',
  `category` varchar(20) DEFAULT 'vegetable',
  `description` varchar(50) DEFAULT NULL,
  `product_image_address` varchar(200) NOT NULL,
  `shelf_time` timestamp NULL DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `discountId` (`discount_id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`discount_id`) REFERENCES `discounts` (`discount_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `products` */

insert  into `products`(`product_id`,`product_name`,`unit`,`price`,`discount_id`,`category`,`description`,`product_image_address`,`shelf_time`,`note`) values (1,'cucumber','lb',2.99,1,'vegetable','snack cucumber','https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/ARS_cucumber.jpg/440px-ARS_cucumber.jpg','2020-05-25 14:55:12',NULL);
insert  into `products`(`product_id`,`product_name`,`unit`,`price`,`discount_id`,`category`,`description`,`product_image_address`,`shelf_time`,`note`) values (2,'tomato','lb',3.99,1,'vegetable','round and red','https://upload.wikimedia.org/wikipedia/commons/8/88/Bright_red_tomato_and_cross_section02.jpg','2020-05-28 14:55:18',NULL);
insert  into `products`(`product_id`,`product_name`,`unit`,`price`,`discount_id`,`category`,`description`,`product_image_address`,`shelf_time`,`note`) values (3,'egg','dozen',6.99,2,'vegetable','small size','https://upload.wikimedia.org/wikipedia/commons/1/12/6-Pack-Chicken-Eggs.jpg','2020-05-30 14:56:21',NULL);
insert  into `products`(`product_id`,`product_name`,`unit`,`price`,`discount_id`,`category`,`description`,`product_image_address`,`shelf_time`,`note`) values (4,'watermelon','ea',9.99,2,'vegetable','local watermelon','https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/Taiwan_2009_Tainan_City_Organic_Farm_Watermelon_FRD_7962.jpg/1280px-Taiwan_2009_Tainan_City_Organic_Farm_Watermelon_FRD_7962.jpg','2020-05-30 14:57:09',NULL);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `phone_number` varchar(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `city` varchar(10) DEFAULT NULL,
  `postal_code` varchar(6) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `is_customer` int(1) DEFAULT '1' COMMENT '0:admin, 1: regular customer',
  `is_active` int(1) DEFAULT '1' COMMENT '0:not active, 1: active',
  `register_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `note` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`user_id`,`user_name`,`password`,`first_name`,`last_name`,`phone_number`,`address`,`city`,`postal_code`,`email`,`is_customer`,`is_active`,`register_date`,`note`) values (1,'anne','user','Anne','Anner','5871112222','1601 16 Ave','Calgary','A1A2A3','anne@sait.com',1,1,'2020-05-11 18:00:07',NULL);
insert  into `users`(`user_id`,`user_name`,`password`,`first_name`,`last_name`,`phone_number`,`address`,`city`,`postal_code`,`email`,`is_customer`,`is_active`,`register_date`,`note`) values (2,'barn','user','Barb','Barber','5871113333','1601 16 Ave','Calgary','A1A2A3','barb@sait.com',1,1,'2020-05-11 18:00:07',NULL);
insert  into `users`(`user_id`,`user_name`,`password`,`first_name`,`last_name`,`phone_number`,`address`,`city`,`postal_code`,`email`,`is_customer`,`is_active`,`register_date`,`note`) values (3,'admin','admin','admin','admin','5870000000','eversource','Calgary','A1A3A5','admin@eversource.ca',0,1,'2020-05-11 18:00:07','for farm owner');
insert  into `users`(`user_id`,`user_name`,`password`,`first_name`,`last_name`,`phone_number`,`address`,`city`,`postal_code`,`email`,`is_customer`,`is_active`,`register_date`,`note`) values (4,'carl','user','Carl','Carler','5870000001','1601 16Ave','Edmonton','A3A5A7','carl@sait.ca',1,0,'2020-05-11 18:00:07','not in Calgary');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
