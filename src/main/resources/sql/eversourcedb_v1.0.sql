/*
*********************************************************************
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.29-log : Database - eversourcedb
AUTHORIZATION: Ever Source Farm
Date Created: Jun 23, 2020
Version: eversourcedb 1.0
Note: 
	No KK in all table, combine inventories table with products table. 
	Only four tables: users, products, orders, events.
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

/*Table structure for table `events` */

DROP TABLE IF EXISTS `events`;

CREATE TABLE `events` (
  `eid` int(10) NOT NULL AUTO_INCREMENT COMMENT 'event_id',
  `event` varchar(50) CHARACTER SET utf8 NOT NULL,
  `description` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `start` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'start_date',
  `end` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'end_date',
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `events` */

insert  into `events`(`eid`,`event`,`description`,`start`,`end`,`status`) values (1,'BBQ Event','Free event','2020-08-01 11:00:00','2020-08-01 17:00:00','active');
insert  into `events`(`eid`,`event`,`description`,`start`,`end`,`status`) values (2,'Tomato Harvest Event','1.99/lb only','2020-06-23 10:47:15','2020-08-08 20:00:00','active');
insert  into `events`(`eid`,`event`,`description`,`start`,`end`,`status`) values (3,'Free Radish Event','Free pick up','2020-06-23 10:45:05','2020-08-15 11:00:00','active');
insert  into `events`(`eid`,`event`,`description`,`start`,`end`,`status`) values (4,'Cucumber Harvest Event','0.99/lb only','2020-08-29 10:00:00','2020-08-29 20:00:00','inactive');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `oid` int(100) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) DEFAULT NULL,
  `pname` varchar(20) DEFAULT NULL,
  `quantity` int(5) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL COMMENT 'delivery status(ready,complete,hold...)',
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `orders` */

insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`status`,`note`) values (1,'user','cucumber',3,'ready',NULL);
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`status`,`note`) values (2,'user','pepper',3,'ready',NULL);
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`status`,`note`) values (3,'user','tomato',10,'ready',NULL);
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`status`,`note`) values (4,'anne','tomato',10,'complete',NULL);
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`status`,`note`) values (5,'barb','pepper',1,'complete',NULL);
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`status`,`note`) values (6,'user','radish',10,'hold','self pickup');

/*Table structure for table `products` */

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `pid` int(10) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) CHARACTER SET utf8 NOT NULL,
  `cname` varchar(50) DEFAULT NULL COMMENT 'chinese name',
  `unit` varchar(10) CHARACTER SET utf8 DEFAULT 'lb',
  `price` double DEFAULT '0',
  `discount` double DEFAULT '0',
  `stock` int(10) DEFAULT '0',
  `category` varchar(20) CHARACTER SET utf8 DEFAULT 'vegetable',
  `description` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `image` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `shelf` timestamp NULL DEFAULT NULL,
  `note` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`pid`),
  UNIQUE KEY `product_name` (`pname`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

/*Data for the table `products` */

insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (1,'cucumber','黄瓜','lb',4.99,0.02,100,'vegetable','snack cucumber','https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/ARS_cucumber.jpg/440px-ARS_cucumber.jpg','2020-05-25 14:55:12',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (2,'pepper','辣椒','lb',5.99,0,20,'vegetable',NULL,NULL,NULL,'');
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (3,'tomato','西红柿','lb',3.99,0,30,'vegetable','round and red','https://upload.wikimedia.org/wikipedia/commons/8/88/Bright_red_tomato_and_cross_section02.jpg','2020-05-28 14:55:18',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (4,'squash','西葫芦','lb',2.99,0,10,'vegetable',NULL,NULL,NULL,NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (5,'indian-lettuce','油麦菜','lb',3.99,0,10,'vegetable',NULL,NULL,NULL,NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (6,'celery','芹菜','lb',3.99,0,10,'vegetable',NULL,NULL,NULL,NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (7,'cabbage','小白菜','lb',2.99,0,1,'vegetable',NULL,NULL,NULL,NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (8,'radish','萝卜','lb',4.99,0,100,'vegetable',NULL,NULL,NULL,NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (9,'water-radish','水萝卜','lb',3.99,0,100,'vegetable',NULL,NULL,NULL,NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (10,'brassica-rapa-chinensis','鸡毛菜','lb',6.99,0,0,'vegetable',NULL,NULL,NULL,NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (11,'water-spinach','空心菜','lb',5.99,0,0,'vegetable',NULL,NULL,NULL,NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (12,'greenbean','四季豆','lb',4.99,0,0,'vegetable',NULL,NULL,NULL,NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (13,'snowbean','雪豆','lb',5.99,0,0,'vegetable',NULL,NULL,NULL,NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (14,'fennel','茴香','lb',6.99,0,0,'vegetable',NULL,NULL,NULL,NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (15,'bok-choy','青菜','lb',3.99,0,0,'vegetable',NULL,NULL,NULL,NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (21,'chicken-egg','鸡蛋','dozen',6.99,0,10,'egg','large size','https://upload.wikimedia.org/wikipedia/commons/1/12/6-Pack-Chicken-Eggs.jpg','2020-05-30 14:56:21',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (22,'duck-egg','鸭蛋','dozen',7.99,0,10,'egg','medium size',NULL,NULL,NULL);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) CHARACTER SET utf8 NOT NULL,
  `password` varchar(60) CHARACTER SET utf8 DEFAULT NULL,
  `salt` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `fname` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `lname` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `city` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `code` varchar(6) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `role` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT 'active or not',
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'register',
  `note` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `user_name` (`uname`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `users` */

insert  into `users`(`uid`,`uname`,`password`,`salt`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (1,'admin','123','12345698','admin','admin','5871112222','eversource farm','Calgary','A1A2A3','admin@eversource.ca','admin','active','2020-05-11 18:00:07','for farm owner');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (2,'user','123','12345698','User','User','58700001234','1601 16 Ave','Calgary','A1A2A3','user.sait.ca','user','active','2020-06-23 09:51:31','test user');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (3,'barn','123','12345698','Barb','Barber','5871113333','1601 16 Ave','Calgary','A1A2A3','barb@sait.com','user','active','2020-05-11 18:00:07',NULL);
insert  into `users`(`uid`,`uname`,`password`,`salt`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (4,'carl','123','12345698','Carl','Carler','5870000001','1601 16 Ave','Edmonton','A3A5A7','carl@sait.ca','user','inactive','2020-05-11 18:00:07','not in Calgary');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (5,'anne','123','11233652','Anne','Anner','5871113333','1601 16 Ave','Calgary','A1A2A3','anne@sait.ca','user','active','2020-06-23 09:00:29',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
