/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 5.7.19-log : Database - leetutorial
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`leetutorial` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `leetutorial`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `address_id` int(20) NOT NULL AUTO_INCREMENT,
  `street` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `address` */

insert  into `address`(`address_id`,`street`,`city`,`country`) values 
(29,'kochinrr','errr','india'),
(30,'ww','rr','tt');

/*Table structure for table `admin_table` */

DROP TABLE IF EXISTS `admin_table`;

CREATE TABLE `admin_table` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(50) DEFAULT NULL,
  `aemail` varchar(50) DEFAULT NULL,
  `apass` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `admin_table` */

insert  into `admin_table`(`aid`,`aname`,`aemail`,`apass`,`status`) values 
(1,'leejo','lee@gmail.com','123',0),
(2,'sebin','sebin@gmail.com','123',0);

/*Table structure for table `login_table` */

DROP TABLE IF EXISTS `login_table`;

CREATE TABLE `login_table` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `uemail` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `utype` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `login_table` */

insert  into `login_table`(`lid`,`uid`,`uemail`,`pass`,`utype`,`status`) values 
(1,1,'lee@gmail.com','123','admin',0),
(3,2,'sebin@gmail.com','123','admin',0),
(9,39,'arun@f.crr','123','student',0),
(10,40,'amala@f.c','123','student',0);

/*Table structure for table `phone_table` */

DROP TABLE IF EXISTS `phone_table`;

CREATE TABLE `phone_table` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `ptype` varchar(50) DEFAULT NULL,
  `pnum` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `phone_table` */

/*Table structure for table `student_table` */

DROP TABLE IF EXISTS `student_table`;

CREATE TABLE `student_table` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(50) DEFAULT NULL,
  `spassword` varchar(50) DEFAULT NULL,
  `semail` varchar(50) DEFAULT NULL,
  `sphone` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  `s_address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

/*Data for the table `student_table` */

insert  into `student_table`(`student_id`,`sname`,`spassword`,`semail`,`sphone`,`status`,`s_address_id`) values 
(39,'arun','123','arun@f.crr','123455',0,29),
(40,'amala','123','amala@f.c','12333',0,30);

/*Table structure for table `user_link_table` */

DROP TABLE IF EXISTS `user_link_table`;

CREATE TABLE `user_link_table` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `lname` varchar(50) DEFAULT NULL,
  `laction` varchar(50) DEFAULT NULL,
  `usertype` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  `ordernum` int(11) DEFAULT '0',
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `user_link_table` */

insert  into `user_link_table`(`lid`,`lname`,`laction`,`usertype`,`status`,`ordernum`) values 
(1,'View Student','viewAllStudent','admin',0,2),
(2,'Add Student','addStudent','admin',0,3),
(3,'Delete Student','deleteStudent','admin123',0,4),
(5,'Home','studentHome','student',0,1),
(6,'Home','adminHome','admin',0,1);

/*Table structure for table `wstudent` */

DROP TABLE IF EXISTS `wstudent`;

CREATE TABLE `wstudent` (
  `student_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `home_address_id` bigint(20) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `section` varchar(30) NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wstudent` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
