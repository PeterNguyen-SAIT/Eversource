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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

/*Data for the table `events` */

insert  into `events`(`eid`,`event`,`description`,`start`,`end`,`status`) values (1,'BBQ Event','Free event','2020-08-01 11:00:00','2020-08-01 17:00:00','active');
insert  into `events`(`eid`,`event`,`description`,`start`,`end`,`status`) values (2,'Tomato Harvest Event','1.99/lb only','2020-07-25 10:47:15','2020-08-08 20:00:00','active');
insert  into `events`(`eid`,`event`,`description`,`start`,`end`,`status`) values (3,'Free Radish Event','Free pick up','2020-08-01 10:45:05','2020-08-15 11:00:00','active');
insert  into `events`(`eid`,`event`,`description`,`start`,`end`,`status`) values (4,'Cucumber Harvest Event','0.99/lb only','2020-08-29 10:00:00','2020-08-29 20:00:00','inactive');

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
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

/*Data for the table `orders` */

insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`unit`,`price`,`status`,`createddate`,`deliverydate`,`pickup`,`note`) values (1,'user','cucumber',3,'lb',5.99,'ready','2020-07-08 21:47:44','2020-07-07 21:48:20','16:00-16:10','delivered');
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`unit`,`price`,`status`,`createddate`,`deliverydate`,`pickup`,`note`) values (2,'user','pepper',3,'lb',5.99,'ready','2020-07-07 21:47:52','2020-07-07 21:48:18','16:20-16:30','delivered');
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`unit`,`price`,`status`,`createddate`,`deliverydate`,`pickup`,`note`) values (3,'anne','tomato',10,'lb',4.99,'ready','2020-07-07 21:47:55','2020-07-07 21:48:16','16:00-16:10','delivered');
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`unit`,`price`,`status`,`createddate`,`deliverydate`,`pickup`,`note`) values (4,'anne','tomato',10,'lb',4.99,'complete','2020-07-14 21:47:57','2020-07-07 21:48:14','16:20-16:30','delivered');
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`unit`,`price`,`status`,`createddate`,`deliverydate`,`pickup`,`note`) values (5,'barb','pepper',1,'lb',4.99,'complete','2020-07-06 21:48:00','2020-07-07 21:48:11','16:20-16:30','delivered');
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`unit`,`price`,`status`,`createddate`,`deliverydate`,`pickup`,`note`) values (6,'user','radish',10,'lb',3.99,'hold','2020-07-07 21:48:02','2020-07-07 21:48:08','16:00-16:10','self pickup');
insert  into `orders`(`oid`,`uname`,`pname`,`quantity`,`unit`,`price`,`status`,`createddate`,`deliverydate`,`pickup`,`note`) values (7,'user','pepper',10,'lb',4.99,'hold','2020-07-07 21:48:05','2020-07-22 21:48:09','16:40-16:50','on hold');

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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4;

/*Data for the table `products` */

insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (1,'Cucumber','黄瓜','lb',4.99,0.05,99,'vegetable','snack cucumber','https://pic1.zhimg.com/v2-339cba3a2eb8f61fbd4ee92d9940f09c_1440w.jpg','2020-05-21 00:00:00',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (2,'Pepper','辣椒','lb',5.99,0,20,'vegetable',NULL,'https://img12.360buyimg.com/n1/jfs/t18055/48/2233369149/248536/7896408a/5aec1aebN833d35df.jpg','2020-07-24 21:54:04','');
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (3,'Tomato','西红柿','lb',3.99,0,30,'vegetable','round and red','https://s1.ig.meishij.net/p/20120921/0e7936651dc6a31632317da497358e7e.jpg','2020-05-28 14:55:18',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (4,'Squash','西葫芦','lb',2.99,0,10,'vegetable',NULL,'https://www.zhifure.com/upload/images/2018/1/12155342782.jpg','2020-07-31 21:53:49',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (5,'Indian-lettuce','油麦菜','lb',3.99,0,10,'vegetable',NULL,'https://images-na.ssl-images-amazon.com/images/I/51PWPhDEV%2BL._AC_SX425_.jpg','2020-07-24 21:53:51',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (6,'Celery','芹菜','lb',3.99,0,10,'vegetable',NULL,'https://www.liaotuo.com/uploadfile/2017/0613/20170613032944165.jpeg','2020-07-09 21:54:07',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (7,'Cabbage','小白菜','lb',2.99,0,5,'vegetable',NULL,'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSUZ1Iea8xkXKKNeKWaz16sKHX02cn41UagDw&usqp=CAU','2020-07-24 21:53:54',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (8,'Radish','萝卜','lb',4.99,0,100,'vegetable',NULL,'https://www.zhifure.com/upload/images/2018/1/15155347919.jpg','2020-07-17 21:53:56',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (9,'Water-radish','水萝卜','lb',3.99,0,100,'vegetable',NULL,'https://img95.699pic.com/photo/50077/4007.jpg_wh300.jpg','2020-07-02 21:54:01',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (10,'Brassica-rapa-chinensis','鸡毛菜','lb',6.99,0,10,'vegetable',NULL,'https://s1.ig.meishij.net/p/20121026/6bb006b8788ccf5699d925fccf517ec2.jpg','2020-07-17 21:53:58',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (11,'Water-spinach','空心菜','lb',5.99,0,20,'vegetable',NULL,'https://images-na.ssl-images-amazon.com/images/I/61lN5mpZAGL._SX569_.jpg','2020-07-09 21:54:10',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (12,'Greenbean','四季豆','lb',4.99,0,5,'vegetable',NULL,'https://www.jkmeishi.com/wcs/Upload/201909/20190901161950-1.jpg','2020-07-10 21:54:13',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (13,'Snowbean','雪豆','lb',5.99,0,15,'vegetable',NULL,'https://www.food365.shop/wp-content/uploads/2020/04/%E6%88%AA%E5%9C%96-2020-04-05-%E4%B8%8A%E5%8D%882.37.08.png','2020-07-02 21:54:16',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (14,'Fennel','茴香','lb',6.99,0,10,'vegetable',NULL,'https://img12.360buyimg.com/n1/jfs/t17953/272/2648526768/407810/645b6bb7/5b06a9e1Naa761f1c.jpg','2020-07-10 21:54:25',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (15,'Bok-choy','青菜','lb',3.99,0,10,'vegetable',NULL,'https://i3.meishichina.com/attachment/201512/23/14508636603967.jpg','2020-07-24 21:54:30',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (21,'Chicken-egg','鸡蛋','dozen',6.99,0,10,'egg','large size','https://66how.com/wp-content/uploads/2019/02/%E5%85%B3%E4%BA%8E%E9%B8%A1%E8%9B%8B%E7%9A%84%E6%9C%89%E8%B6%A3%E4%BA%8B%E5%AE%9E-A-3.jpg','2020-05-30 14:56:21',NULL);
insert  into `products`(`pid`,`pname`,`cname`,`unit`,`price`,`discount`,`stock`,`category`,`description`,`image`,`shelf`,`note`) values (22,'Duck-egg','鸭蛋','dozen',7.99,0,10,'egg','medium size','https://n.sinaimg.cn/sinakd20200410ac/303/w640h463/20200410/a192-iryninx3867753.jpg','2020-07-17 21:54:34',NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

/*Data for the table `users` */

insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (1,'admin','ef5f9cb50558970dc5771bccad9d7906','agu31Q9g','123456','admin1','admin1','5871112222','eversource farm','Calgary','A1A2A3','admin@eversource.ca','admin','active','2020-05-11 18:00:07','for farm owner');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (2,'admin2','111','(d)kS1C1','123456','admin2','admin2','0000000000','eversource farm','calgary','A1A2A3','admin2@eversource.ca','admin','active','2020-07-07 15:23:25','for tester');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (3,'barn','222','12345698','123456','Barb','Barber','5871113333','1601 16 Ave','Calgary','A1A2A3','barb@sait.com','user','active','2020-05-11 18:00:07','user');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (4,'carl','333','12345698','123456','Carl','Carler','5870000001','1601 16 Ave','Edmonton','A3A5A7','carl@sait.ca','user','inactive','2020-05-11 18:00:07','not in Calgary');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (5,'user','9bdefc7bf00268b5a8498d39641cba64','(d)kS1C1','123456','User','User','58700001234','1601 16 Ave','Calgary','A1A2A3','user.sait.ca','user','active','2020-06-23 09:51:31','test user');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (6,'user2','111','(d)kS1C1',NULL,'User','User','58700001234','1601 16 Ave','Calgary','A1A2A3','user6.sait.ca','user','active','2020-06-23 09:51:31','test user');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (7,'bin','111','(d)kS1C1',NULL,'User','User','58700001234','1601 16 Ave','Calgary','A1A2A3','user7.sait.ca','user','active','2020-06-23 09:51:31','test user');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (8,'user8','9bdefc7bf00268b5a8498d39641cba64','(d)kS1C1',NULL,'User','User','58700001234','1601 16 Ave','Calgary','A1A2A3','user8.sait.ca','user','active','2020-06-23 09:51:31','test user');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (9,'user9','9bdefc7bf00268b5a8498d39641cba64','(d)kS1C1',NULL,'User','User','58700001234','1601 16 Ave','Calgary','A1A2A3','user9.sait.ca','user','active','2020-06-23 09:51:31','test user');
insert  into `users`(`uid`,`uname`,`password`,`salt`,`token`,`fname`,`lname`,`phone`,`address`,`city`,`code`,`email`,`role`,`status`,`date`,`note`) values (10,'user10','9bdefc7bf00268b5a8498d39641cba64','(d)kS1C1',NULL,'User','User','58700001234','1601 16 Ave','Calgary','A1A2A3','user10.sait.ca','user','active','2020-06-23 09:51:31','test user');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
