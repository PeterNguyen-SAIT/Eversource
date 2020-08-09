/*
*********************************************************************
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.29-log : Database - eversourcedb
Version: 1.0.5
Author: Bin Zhang
Date: July 30,2020
New update:
1. Add images in order table
2. Adjust some contents in order table and user table
3. Update images in events table
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
  `image` varchar(100) DEFAULT NULL,
  `description` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `start` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'start_date',
  `end` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'end_date',
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `events` */

insert  into `events`(`eid`,`event`,`image`,`description`,`start`,`end`,`status`) values (1,'BBQ Event','https://i.postimg.cc/5yWB2JVJ/event1.jpg','Free entry and enjoy all the fresh vegetable in our farm','2020-07-30 23:48:50','2020-08-01 17:00:00','active');
insert  into `events`(`eid`,`event`,`image`,`description`,`start`,`end`,`status`) values (2,'Tomato Harvest Event','https://i.postimg.cc/cHn7WHPT/event2.jpg','Only $1.99/lb','2020-07-30 23:48:56','2020-08-08 20:00:00','active');
insert  into `events`(`eid`,`event`,`image`,`description`,`start`,`end`,`status`) values (3,'Free Radish Event','https://i.postimg.cc/90PG4km7/event3.jpg','Free pick up','2020-07-30 23:49:01','2020-08-15 11:00:00','active');
insert  into `events`(`eid`,`event`,`image`,`description`,`start`,`end`,`status`) values (4,'Cucumber Harvest Event','https://i.postimg.cc/L4jk0Jt8/event4.jpg','Only $0.99/lb','2020-07-30 23:49:04','2020-08-29 20:00:00','inactive');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `oid` int(100) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) DEFAULT NULL,
  `pname` varchar(20) DEFAULT NULL,
  `quantity` int(5) DEFAULT NULL,
  `unit` varchar(10) DEFAULT NULL COMMENT 'lb,ea,dozen',
  `price` double DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL COMMENT 'delivery status(ready,complete,hold...)',
  `createddate` timestamp NULL DEFAULT NULL COMMENT 'date created',
  `deliverydate` timestamp NULL DEFAULT NULL COMMENT 'date delivery',
  `pickup` varchar(30) DEFAULT NULL COMMENT 'pickup time range',
  `note` varchar(100) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

/*Data for the table `orders` */

insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`unit`,`price`,`status`,`createddate`,`deliverydate`,`pickup`,`note`,`image`) values (1,'user','cucumber',3,'lb',5.99,'ready','2020-07-08 21:47:44','2020-07-07 21:48:20','16:00-16:10','delivered','https://i.postimg.cc/J0TNkcXR/1.jpg');
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`unit`,`price`,`status`,`createddate`,`deliverydate`,`pickup`,`note`,`image`) values (2,'user','pepper',3,'lb',5.99,'ready','2020-07-07 21:47:52','2020-07-07 21:48:18','16:20-16:30','delivered','https://i.postimg.cc/DZTPkzF3/2.jpg');
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`unit`,`price`,`status`,`createddate`,`deliverydate`,`pickup`,`note`,`image`) values (3,'anne','tomato',10,'lb',4.99,'ready','2020-07-07 21:47:55','2020-07-07 21:48:16','16:00-16:10','delivered','https://i.postimg.cc/bJ9HzjND/3.jpg');
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`unit`,`price`,`status`,`createddate`,`deliverydate`,`pickup`,`note`,`image`) values (4,'anne','tomato',10,'lb',4.99,'complete','2020-07-14 21:47:57','2020-07-07 21:48:14','16:20-16:30','delivered','https://i.postimg.cc/bJ9HzjND/3.jpg');
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`unit`,`price`,`status`,`createddate`,`deliverydate`,`pickup`,`note`,`image`) values (5,'barb','pepper',1,'lb',4.99,'complete','2020-07-06 21:48:00','2020-07-07 21:48:11','16:20-16:30','delivered','https://i.postimg.cc/DZTPkzF3/2.jpg');
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`unit`,`price`,`status`,`createddate`,`deliverydate`,`pickup`,`note`,`image`) values (6,'bin','radish',10,'lb',3.99,'hold','2020-07-07 21:48:02','2020-07-07 21:48:08','16:00-16:10','self pickup','https://i.postimg.cc/CLQCM7YN/8.jpg');
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`unit`,`price`,`status`,`createddate`,`deliverydate`,`pickup`,`note`,`image`) values (7,'bin','pepper',10,'lb',4.99,'hold','2020-07-07 21:48:05','2020-07-22 21:48:09','16:40-16:50','on hold','https://i.postimg.cc/DZTPkzF3/2.jpg');
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`unit`,`price`,`status`,`createddate`,`deliverydate`,`pickup`,`note`,`image`) values (8,'bin','Cucumber',4,'lb',4.99,'hold','2020-07-23 16:18:11','2020-07-30 16:18:15','16:40-16:50','on hold','https://i.postimg.cc/J0TNkcXR/1.jpg');

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

/*Data for the table `products` */

insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (1,'Cucumber','黄瓜','lb',4.99,0,99,'vegetable','snack cucumber','https://i.postimg.cc/J0TNkcXR/1.jpg','2020-05-21 00:00:00',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (2,'Pepper','辣椒','lb',5.99,0,20,'vegetable',NULL,'https://i.postimg.cc/DZTPkzF3/2.jpg','2020-07-24 21:54:04','');
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (3,'Tomato','西红柿','lb',4.99,0,30,'vegetable','round and red','https://i.postimg.cc/bJ9HzjND/3.jpg','2020-05-28 14:55:18',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (4,'Squash','西葫芦','lb',2.99,0,10,'vegetable',NULL,'https://i.postimg.cc/J7Kcvm2S/4.jpg','2020-07-31 21:53:49',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (5,'Indian-lettuce','油麦菜','lb',3.99,0,10,'vegetable',NULL,'https://i.postimg.cc/XYBfr5Y0/5.jpg','2020-07-24 21:53:51',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (6,'Celery','芹菜','lb',3.99,0,10,'vegetable',NULL,'https://i.postimg.cc/J4ncWvw0/6.jpg','2020-07-09 21:54:07',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (7,'Cabbage','小白菜','lb',3.99,0,5,'vegetable',NULL,'https://i.postimg.cc/cC17C5rD/7.jpg','2020-07-24 21:53:54',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (8,'Radish','萝卜','lb',4.99,0,100,'vegetable',NULL,'https://i.postimg.cc/CLQCM7YN/8.jpg','2020-07-17 21:53:56',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (9,'Water-radish','水萝卜','lb',3.99,0,100,'vegetable',NULL,'https://i.postimg.cc/XvMwdvrB/9.jpg','2020-07-02 21:54:01',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (10,'Brassica-rapa-chinensis','鸡毛菜','lb',6.99,0,10,'vegetable',NULL,'https://i.postimg.cc/Pqm14kD3/10.jpg','2020-07-17 21:53:58',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (11,'Water-spinach','空心菜','lb',5.99,0,20,'vegetable',NULL,'https://i.postimg.cc/rmMxZYC8/11.jpg','2020-07-09 21:54:10',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (12,'Greenbean','四季豆','lb',4.99,0,5,'vegetable',NULL,'https://i.postimg.cc/mDjMvN87/12.jpg','2020-07-10 21:54:13',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (13,'Snowbean','雪豆','lb',5.99,0,15,'vegetable',NULL,'https://i.postimg.cc/gj0RmXTQ/13.jpg','2020-07-02 21:54:16',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (14,'Fennel','茴香','lb',6.99,0,10,'vegetable',NULL,'https://i.postimg.cc/rsY4my6m/14.jpg','2020-07-10 21:54:25',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (15,'Bok-choy','青菜','lb',3.99,0,10,'vegetable',NULL,'https://i.postimg.cc/xjsMg5k2/15.jpg','2020-07-24 21:54:30',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (16,'Chicken-egg','鸡蛋','dozen',5.99,0,10,'egg','egg','https://i.postimg.cc/L6nfWPfZ/16.jpg','2020-05-30 14:56:21',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (17,'Duck-egg','鸭蛋','dozen',7.99,0,10,'egg','egg','https://i.postimg.cc/wTZJYBc4/17.jpg','2020-07-17 21:54:34',NULL);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `uid` int(30) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) CHARACTER SET utf8 NOT NULL,
  `password` varchar(60) CHARACTER SET utf8 NOT NULL,
  `salt` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `token` varchar(60) DEFAULT NULL,
  `fname` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `lname` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `city` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `code` varchar(6) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8 NOT NULL,
  `role` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT 'active or not',
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'register date',
  `note` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `user_name` (`uname`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

/*Data for the table `users` */

insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (1,'admin1','21232f297a57a5a743894a0e4a801fc3','L%x1p*1p','hTJF$A4l5$sEe^Sp2MMoDba&mEl5U1rX','admin1','admin1','5871112222','eversource farm','Calgary','A1A2A3','admin@eversource.ca','admin','active','2020-05-11 18:00:07','farm owner');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (2,'admin2','c84258e9c39059a89ab77d846ddab909','MjI&HP!7','Rc5LCEtNetaGJKxcUl6Unv&gQcbCUo^H','admin2','admin2','5871234567','eversource farm','calgary','A1A2A3','admin2@eversource.ca','admin','active','2020-07-07 15:23:25','farm admin2');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (3,'barn','5dfcc0aab2f3db925b2d51ba73e48946','F)YHykK6','x4V))UCyUUnppWo@&3jVg(8l9Ua80pwe','Barb','Barber','5871113333','1601 16 Ave','Calgary','A1A2A3','barb@sait.com','user','active','2020-05-11 18:00:07','user');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (4,'carl','a0df931e7a7f9b608c165504bde9b620','e2Tj835P','AuDtlgaJA@*8dgSS76DINSXe5DKrQ)wM','Carl','Carler','5870000011','1601 16 Ave','Edmonton','A3A5A7','carl@sait.ca','user','inactive','2020-05-11 18:00:07','not in Calgary');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (5,'user1','user1','tGP5Fn7W','AAEymHHg&$ErGyEWHmK^gL!2(nElek9s','User','User','5870001234','1601 16 Ave','Calgary','A1A2A3','user1@sait.ca','user','active','2020-06-23 09:51:31','new user');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (6,'user2','7e58d63b60197ceb55a1c487989a3720','Cp%4fWJW','X5WPw2M4t!li(Oe%@nVdc4eFr(atPtxh','User','User','5870001235','1601 16 Ave','Calgary','A1A2A3','user2@sait.ca','user','active','2020-06-23 09:51:31','new user');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (7,'bin','c1111bd512b29e821b120b86446026b8','!yky5YsW','jL&A8eI7jM4yTRoCuxVmMOphwPEoC2(R','Bin','Zhang','5871111234','1601 16 Ave','Calgary','A1A2A3','bin.zhang@sait.ca','user','active','2020-06-17 00:00:00','dev');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (8,'test1','5a105e8b9d40e1329780d62ea2265d8a','OATK&aTa','MFpo4grEh*^1BfIjOx5p4Q9llYfLUfe@','Test','Test','5872221234','1601 16 Ave','Calgary',NULL,'test1@sait.ca','user','active','2020-07-15 00:00:00','test user');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (9,'test2','ad0234829205b9033196ba818f7a872b','TuX%NP22','&)Nd39Q@rPoCXdd^NxvXsVXfeMensE!A','Test','Test','5872221235','1601 16 Ave','Calgary','A1A2A3','test2@sait.ca','user','active','2020-07-16 09:51:31','test user');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
