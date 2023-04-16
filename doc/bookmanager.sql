/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.48 : Database - bookmanager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookmanager` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookmanager`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `publish` varchar(255) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT '1' COMMENT '状态 1上架0下架',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `book` */

insert  into `book`(`id`,`book_name`,`type_id`,`author`,`publish`,`price`,`number`,`status`,`remark`) values (4,'西游记',3,'吴承恩','机械工业出版社',23.00,213,1,'四大名著之一'),(6,'SpringCloud微服务架构开发',1,'黑马程序员','人民邮电出版社',28.00,20,1,'微服务实战开发'),(7,'水浒传',3,'施耐庵 ','人民文学出版社',29.00,30,1,'四大名著之一'),(8,'Java基础入门（第2版）',1,'黑马程序员','清华大学出版社',30.20,22,1,'提高Java编程功底必备'),(9,'中国文学编年史',2,'陈文新','湖南人民出版社',35.30,36,1,'中国文学编年史'),(10,'JavaWeb程序设计任务教程',1,'黑马程序员','人民邮电出版社',25.50,16,1,'学习JavaWeb的好帮手'),(11,'SSH框架整合实战教程',1,'传智播客高教产品研发部','清华大学出版社',59.00,12,1,'SSH项目开发实战'),(12,'朝花夕拾',3,'鲁迅','辽海出版社',44.60,30,1,'鲁迅小说全集系列'),(13,'彷徨',3,'鲁迅','辽海出版社',44.60,16,1,'鲁迅小说全集系列'),(14,'呐喊',3,'鲁迅','辽海出版社',44.50,16,1,'鲁迅小说全集系列'),(15,'阿Q正传',3,'鲁迅','辽海出版社',29.00,33,1,'鲁迅小说全集系列');

/*Table structure for table `book_type` */

DROP TABLE IF EXISTS `book_type`;

CREATE TABLE `book_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `book_type` */

insert  into `book_type`(`id`,`type_name`,`remark`) values (1,'技术','技术类'),(2,'人文','人文类'),(3,'小说','人生情感小说');

/*Table structure for table `borrowdetail` */

DROP TABLE IF EXISTS `borrowdetail`;

CREATE TABLE `borrowdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `status` int(11) NOT NULL COMMENT '状态  1在借2已还',
  `borrow_time` bigint(20) DEFAULT NULL,
  `return_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `borrowdetail` */

insert  into `borrowdetail`(`id`,`user_id`,`book_id`,`status`,`borrow_time`,`return_time`) values (1,1,2,2,1546414916391,1546414948498),(2,1,3,2,1546414932877,1556417443285),(3,1,2,2,1546416530026,1546416640210),(4,1,1,2,1546565100120,1556334334816),(5,1,4,1,1546565102870,NULL),(8,1,1,1,1556427836809,NULL),(20,1,5,1,1556539946226,NULL),(25,1,12,2,1556845403233,1680867524787),(27,1,6,2,1680867506803,1680867514994),(28,2,6,1,1680875446712,NULL),(29,2,8,1,1680875450808,NULL),(30,1,10,1,1680957684456,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int(255) DEFAULT NULL COMMENT '角色  1学生 2管理员',
  `sex` varchar(1) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`role`,`sex`,`phone`) values (1,'demo','123',1,'男','13195648799'),(2,'admin','111111',2,'男','13198645975');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
