/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.19 : Database - dormitory
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dormitory` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dormitory`;

/*Table structure for table `absent` */

DROP TABLE IF EXISTS `absent`;

CREATE TABLE `absent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `building_id` int(11) DEFAULT NULL,
  `dormitory_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `dormitory_admin_id` int(11) DEFAULT NULL,
  `create_date` varchar(20) DEFAULT NULL,
  `reason` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `absent` */

insert  into `absent`(`id`,`building_id`,`dormitory_id`,`student_id`,`dormitory_admin_id`,`create_date`,`reason`) values 
(13,1,2,5,16,'2022-04-16','请假'),
(17,1,1,4,20,'2022-10-23','生病'),
(18,1,38,3,20,'2022-10-23','回家');

/*Table structure for table `building` */

DROP TABLE IF EXISTS `building`;

CREATE TABLE `building` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `introduction` varchar(1000) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `building` */

insert  into `building`(`id`,`name`,`introduction`,`admin_id`) values 
(1,'1号楼','医学楼',18),
(2,'2号楼','计算机学院宿舍楼',20),
(16,'5号楼','电信学院宿舍楼',16),
(20,'3号楼','萃英楼',19);

/*Table structure for table `dormitory` */

DROP TABLE IF EXISTS `dormitory`;

CREATE TABLE `dormitory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `building_id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `available` int(11) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `dormitory` */

insert  into `dormitory`(`id`,`building_id`,`name`,`type`,`available`,`telephone`) values 
(1,1,'101',4,2,'88230002'),
(2,1,'102',4,0,'88230002'),
(3,1,'211',4,0,'88230007'),
(4,2,'212',6,0,'88230008'),
(6,2,'322',10,8,'88230016'),
(36,1,'666',6,6,'88136666'),
(38,1,'320',4,3,'777888666');

/*Table structure for table `dormitory_admin` */

DROP TABLE IF EXISTS `dormitory_admin`;

CREATE TABLE `dormitory_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `dormitory_admin` */

insert  into `dormitory_admin`(`id`,`username`,`password`,`name`,`gender`,`telephone`) values 
(1,'ll','123123','宋玉','女','13312345678'),
(2,'ww','123123','王力','男','13612345678'),
(16,'zz','123123','张给力','女','13312345678'),
(18,'zx','123456','张璇','女','18265625344'),
(19,'xxy','1521','夏鑫媛','男','156156144848'),
(20,'gd','123','狗蛋','男','15235416551');

/*Table structure for table `moveout` */

DROP TABLE IF EXISTS `moveout`;

CREATE TABLE `moveout` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(11) DEFAULT NULL,
  `dormitory_id` varchar(50) DEFAULT NULL,
  `reason` varchar(11) DEFAULT NULL,
  `create_date` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `moveout` */

insert  into `moveout`(`id`,`student_id`,`dormitory_id`,`reason`,`create_date`) values 
(17,'18','4','毕业','2022-04-27'),
(18,'3','38','生病','2022-10-23');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `dormitory_id` int(11) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `create_date` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`number`,`name`,`gender`,`dormitory_id`,`state`,`create_date`) values 
(3,'003','薛英杰','男',38,'迁出','2022-04-14'),
(4,'004','赵昭','男',1,'入住','2022-04-14'),
(5,'005','王维利','男',2,'入住','2022-04-14'),
(6,'006','李双','女',2,'入住','2022-04-14'),
(7,'007','李小峰','男',2,'入住','2022-04-14'),
(8,'008','孙奇','男',2,'入住','2022-04-14'),
(9,'009','李立','女',3,'入住','2022-04-14'),
(10,'010','周华发','男',3,'入住','2022-04-14'),
(11,'011','赵正义','男',3,'入住','2022-04-14'),
(12,'012','李明','男',3,'入住','2022-04-14'),
(13,'013','许鹏飞','男',4,'入住','2022-04-14'),
(14,'014','朱海','男',4,'入住','2022-04-14'),
(15,'015','苏苏苏','男',4,'入住','2022-04-14'),
(16,'016','李雪','女',4,'入住','2022-04-14'),
(17,'017','李爽','女',4,'入住','2022-04-14'),
(18,'018','王纯','女',4,'迁出','2022-04-14'),
(65,'320','石头','男',1,'入住','2022-10-21'),
(66,'1111','测试01','男',6,'入住','2022-04-17'),
(67,'222','测试02','男',6,'入住','2022-04-17');

/*Table structure for table `system_admin` */

DROP TABLE IF EXISTS `system_admin`;

CREATE TABLE `system_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `system_admin` */

insert  into `system_admin`(`id`,`username`,`password`,`name`,`telephone`) values 
(1,'admin1','123123','管理员1','88132001'),
(2,'admin2','123123','管理员2','88132002');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
