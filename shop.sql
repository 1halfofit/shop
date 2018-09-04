/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.27 : Database - maven
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`maven` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `maven`;

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cdis` varchar(64) DEFAULT NULL,
  `uid` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `uid` (`uid`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `cart` */

insert  into `cart`(`cid`,`cdis`,`uid`) values (13,'测试的购物车','3ae7db45-3680-4e63-873f-bc702dc46566');

/*Table structure for table `cartitem` */

DROP TABLE IF EXISTS `cartitem`;

CREATE TABLE `cartitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subtotal` double DEFAULT NULL,
  `pid` varchar(64) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pid` (`pid`),
  KEY `cid` (`cid`),
  CONSTRAINT `cartitem_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`),
  CONSTRAINT `cartitem_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `cart` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `cartitem` */

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `cid` varchar(32) NOT NULL,
  `cname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`cid`,`cname`) values ('1','手机数码'),('2','潮流女装'),('3','家具家居'),('4','鞋靴箱包'),('5','名烟名酒');

/*Table structure for table `evaluate` */

DROP TABLE IF EXISTS `evaluate`;

CREATE TABLE `evaluate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dis` varchar(128) DEFAULT NULL,
  `username` varchar(32) DEFAULT NULL,
  `pid` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pid` (`pid`),
  CONSTRAINT `evaluate_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `orderitem` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `evaluate` */

/*Table structure for table `orderitem` */

DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `orderitem` (
  `itemid` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `pid` varchar(32) DEFAULT NULL,
  `oid` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `fk_0001` (`pid`),
  KEY `fk_0002` (`oid`),
  CONSTRAINT `fk_0001` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`),
  CONSTRAINT `fk_0002` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `orderitem` */

insert  into `orderitem`(`itemid`,`count`,`subtotal`,`pid`,`oid`) values (7,5,885,'25','c9bf42b47dd642fa80ac5189ddde785c'),(8,5,885,'25','c9bf42b47dd642fa80ac5189ddde785c'),(9,4,3552,'34','c9bf42b47dd642fa80ac5189ddde785c'),(10,6,1062,'25','a75fd0c4bb2d4881a88407214c60c380'),(11,6,1062,'25','a75fd0c4bb2d4881a88407214c60c380'),(12,3,38997,'1','a75fd0c4bb2d4881a88407214c60c380'),(13,6,1062,'25','93cf70bacee14cf0abbfd3ebbc657368'),(14,5,885,'25','b93c51c713d84e2684efed23a4c0d4b3'),(15,5,885,'25','b93c51c713d84e2684efed23a4c0d4b3'),(16,5,1495,'28','b93c51c713d84e2684efed23a4c0d4b3'),(17,5,885,'25','b93c51c713d84e2684efed23a4c0d4b3'),(18,5,1495,'28','b93c51c713d84e2684efed23a4c0d4b3'),(19,5,4440,'34','b93c51c713d84e2684efed23a4c0d4b3'),(20,5,2495,'29','4efaa49d73394e8fa6be3ee7487148f6'),(21,5,2495,'29','4efaa49d73394e8fa6be3ee7487148f6'),(22,4,51996,'1','4efaa49d73394e8fa6be3ee7487148f6'),(23,4,8000,'22','b42f46b830dc47279bcf879da537d07e'),(24,4,8000,'22','b42f46b830dc47279bcf879da537d07e'),(25,3,2664,'34','b42f46b830dc47279bcf879da537d07e');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `oid` varchar(128) NOT NULL,
  `ordertime` datetime DEFAULT NULL,
  `total` double DEFAULT NULL,
  `state` varchar(32) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `uid` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `uid` (`uid`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`oid`,`ordertime`,`total`,`state`,`address`,`name`,`telephone`,`uid`) values ('4efaa49d73394e8fa6be3ee7487148f6','2018-08-21 22:57:52',54491,NULL,'深圳9','测试','13311111111','3ae7db45-3680-4e63-873f-bc702dc46566'),('93cf70bacee14cf0abbfd3ebbc657368','2018-08-21 22:03:36',1062,NULL,'深圳9','测试','13311111111','3ae7db45-3680-4e63-873f-bc702dc46566'),('a75fd0c4bb2d4881a88407214c60c380','2018-08-21 22:02:11',40059,NULL,'深圳9','测试','13311111111','3ae7db45-3680-4e63-873f-bc702dc46566'),('b42f46b830dc47279bcf879da537d07e','2018-09-04 19:18:00',10664,NULL,'aaa','测试','13311111111','3ae7db45-3680-4e63-873f-bc702dc46566'),('b93c51c713d84e2684efed23a4c0d4b3','2018-08-21 22:04:59',6820,NULL,'深圳9','测试','13311111111','3ae7db45-3680-4e63-873f-bc702dc46566'),('c9bf42b47dd642fa80ac5189ddde785c','2018-08-21 22:01:11',4437,NULL,'深圳9','测试','13311111111','3ae7db45-3680-4e63-873f-bc702dc46566');

/*Table structure for table `pro_cat` */

DROP TABLE IF EXISTS `pro_cat`;

CREATE TABLE `pro_cat` (
  `pid` varchar(32) NOT NULL,
  `cid` varchar(32) NOT NULL,
  PRIMARY KEY (`pid`,`cid`),
  KEY `cid` (`cid`),
  CONSTRAINT `pro_cat_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`),
  CONSTRAINT `pro_cat_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pro_cat` */

insert  into `pro_cat`(`pid`,`cid`) values ('1','1'),('10','1'),('11','1'),('12','1'),('13','1'),('14','1'),('15','1'),('16','1'),('17','1'),('18','1'),('19','1'),('2','1'),('3','1'),('4','1'),('5','1'),('6','1'),('7','1'),('8','1'),('20','2'),('21','2'),('22','2'),('23','2'),('24','2'),('25','2'),('26','2'),('27','2'),('28','2'),('29','2'),('30','2'),('31','2'),('32','2'),('33','2'),('9','2'),('34','3');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `pid` varchar(32) NOT NULL,
  `pname` varchar(50) DEFAULT NULL,
  `marketprice` double DEFAULT NULL,
  `shopprice` double DEFAULT NULL,
  `pimage` varchar(200) DEFAULT NULL,
  `pdate` date DEFAULT NULL,
  `ishot` int(11) DEFAULT NULL,
  `pdesc` varchar(255) DEFAULT NULL,
  `pflag` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `floated` double DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`pid`,`pname`,`marketprice`,`shopprice`,`pimage`,`pdate`,`ishot`,`pdesc`,`pflag`,`weight`,`floated`) values ('1','小米 4c 标准版',NULL,12999,'products/1/c_0001.jpg','2018-08-13',1,NULL,NULL,NULL,NULL),('10','华为 Ascend Mate7',2699,2599,'products/1/c_0010.jpg','2018-04-02',1,'华为 Ascend Mate7 月光银 移动4G手机 双卡双待双通6英寸高清大屏，纤薄机身，智能超八核，按压式指纹识别！!选择下方“移动老用户4G飞享合约”，无需换号，还有话费每月返还！',0,30,1),('11','vivo X5Pro',2399,2298,'products/1/c_0014.jpg','2018-04-03',1,'移动联通双4G手机 3G运存版 极光白【购机送蓝牙耳机+蓝牙自拍杆】新升级3G运行内存·双2.5D弧面玻璃·眼球识别技术',0,20,1),('12','努比亚（nubia）My 布拉格',1899,1799,'products/1/c_0013.jpg','2018-04-04',0,'努比亚（nubia）My 布拉格 银白 移动联通4G手机 双卡双待【嗨11，下单立减100】金属机身，快速充电！布拉格相机全新体验！',0,40,4),('13','华为 麦芒4',2599,2499,'products/1/c_0012.jpg','2018-04-05',1,'华为 麦芒4 晨曦金 全网通版4G手机 双卡双待金属机身 2.5D弧面屏 指纹解锁 光学防抖',0,50,1),('14','vivo X5M',1899,1799,'products/1/c_0011.jpg','2018-04-06',0,'vivo X5M 移动4G手机 双卡双待 香槟金【购机送蓝牙耳机+蓝牙自拍杆】5.0英寸大屏显示·八核双卡双待·Hi-Fi移动KTV',0,79,1),('15','Apple iPhone 6 (A1586)',4399,4288,'products/1/c_0015.jpg','2018-04-07',1,'Apple iPhone 6 (A1586) 16GB 金色 移动联通电信4G手机长期省才是真的省！点击购机送费版，月月送话费，月月享优惠，畅享4G网络，就在联通4G！',0,45,4),('16','华为 HUAWEI Mate S 臻享版',4200,4087,'products/1/c_0016.jpg','2018-04-08',0,'华为 HUAWEI Mate S 臻享版 手机 极昼金 移动联通双4G(高配)满星评价即返30元话费啦；买就送电源+清水套+创意手机支架；优雅弧屏，mate7升级版',0,45,3),('17','索尼(SONY) E6533 Z3+',4099,3999,'products/1/c_0017.jpg','2018-04-09',0,'索尼(SONY) E6533 Z3+ 双卡双4G手机 防水防尘 涧湖绿索尼z3专业防水 2070万像素 移动联通双4G',0,234,23),('18','HTC One M9+',3599,3499,'products/1/c_0018.jpg','2018-04-10',0,'HTC One M9+（M9pw） 金银汇 移动联通双4G手机5.2英寸，8核CPU，指纹识别，UltraPixel超像素前置相机+2000万/200万后置双镜头相机！降价特卖，惊喜不断！',0,324,23),('19','HTC Desire 826d 32G 臻珠白',1599,1469,'products/1/c_0020.jpg','2018-04-11',1,'后置1300万+UltraPixel超像素前置摄像头+【双】前置扬声器+5.5英寸【1080p】大屏！',0,23,1),('2','中兴 AXON',2899,2699,'products/1/c_0002.jpg','2018-04-12',1,'中兴 AXON 天机 mini 压力屏版 B2015 华尔金 移动联通电信4G 双卡双待',0,45,32),('20','新款女装a',399,200,'products/1/cs10001.jpg','2018-04-09',0,'最新款女装,春季必备',0,500,50),('21','新款女装b',299,200,'products/1/cs10002.jpg','2018-04-08',1,'最新款女装,春季必备',0,56,5),('22','新款女装c',2199,2000,'products/1/cs10003.jpg','2018-04-07',0,'最新款女装,春季必备',0,67,6),('23','新款女装d',2999,2099,'products/1/cs10004.jpg','2018-04-06',1,'最新款女装,春季必备',0,78,7),('24','新款女装e',288,188,'products/1/cs10005.jpg','2018-04-05',0,'最新款女装,春季必备',0,89,8),('25','新款女装f',277,177,'products/1/cs10006.jpg','2018-04-15',0,'最新款女装,春季必备',0,89,7),('26','新款女装g',266,166,'products/1/cs10007.jpg','2018-04-16',1,'最新款女装,春季必备',0,66,6),('27','新款女装h',299,100,'products/1/cs10008.jpg','2018-04-13',0,'最新款女装,春季必备',0,77,7),('28','新款女装i',399,299,'products/1/cs10009.jpg','2018-04-14',1,'最新款女装,春季必备',0,88,8),('29','新款女装g',599,499,'products/1/cs10010.jpg','2018-04-03',0,'最新款女装,春季必备',0,99,9),('3','华为荣耀6',1599,1499,'products/1/c_0003.jpg','2018-04-01',0,'荣耀 6 (H60-L01) 3GB内存标准版 黑色 移动4G手机',0,34,3),('30','新款女装',299,200,'products/1/cs100011.png','2018-04-03',1,'最新款女装,春季必备',0,455,45),('31','新款女装k',99,66,'products/1/cs100012.png','2018-04-09',0,'最新款女装,春季必备',0,34,2),('32','新款女装m',299,200,'products/1/cs100013.png','2018-04-17',0,'最新款女装,春季必备',0,234,21),('33','新款女装l',345,123,'products/1/cs100014.jpg','2018-04-11',1,'最新款女装,春季必备',0,23,2),('34','精品家具',999,888,'products/1/cs100015.png','2018-08-07',1,'你值得拥有',0,5000,200),('4','联想 P1',2199,1999,'products/1/c_0004.jpg','2018-04-13',0,'联想 P1 16G 伯爵金 移动联通4G手机充电5分钟，通话3小时！科技源于超越！品质源于沉淀！5000mAh大电池！高端商务佳配！',0,234,2),('5','摩托罗拉 moto x（x+1）',1799,1699,'products/1/c_0005.jpg','2018-04-14',0,'摩托罗拉 moto x（x+1）(XT1085) 32GB 天然竹 全网通4G手机11月11天！MOTO X震撼特惠来袭！1699元！带你玩转黑科技！天然材质，原生流畅系统！',0,34,2),('6','魅族 MX5 16GB 银黑色',1899,1799,'products/1/c_0006.jpg','2018-04-15',0,'魅族 MX5 16GB 银黑色 移动联通双4G手机 双卡双待送原厂钢化膜+保护壳+耳机！5.5英寸大屏幕，3G运行内存，2070万+500万像素摄像头！长期省才是真的省！',0,23,5),('7','三星 Galaxy On7',1499,1398,'products/1/c_0007.jpg','2018-04-16',0,'三星 Galaxy On7（G6000）昂小七 金色 全网通4G手机 双卡双待新品火爆抢购中！京东尊享千元良机！5.5英寸高清大屏！1300+500W像素！评价赢30元话费券！',0,23,3),('8','NUU NU5',1288,1190,'products/1/c_0008.jpg','2018-04-15',0,'NUU NU5 16GB 移动联通双4G智能手机 双卡双待 晒单有礼 晨光金香港品牌 2.5D弧度前后钢化玻璃 随机附赠手机套+钢化贴膜 晒单送移动电源+蓝牙耳机',0,23,2),('9','新款女装kkk',299,200,'products/1/cs100015.png','2018-04-05',0,'最新款女装,春季必备',0,2,2);

/*Table structure for table `productdetail` */

DROP TABLE IF EXISTS `productdetail`;

CREATE TABLE `productdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dis` varchar(64) DEFAULT NULL,
  `imagepath` varchar(64) DEFAULT NULL,
  `pid` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pid` (`pid`),
  CONSTRAINT `productdetail_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `productdetail` */

insert  into `productdetail`(`id`,`dis`,`imagepath`,`pid`) values (1,'图片1','products/detil/1.jpg','20'),(2,'图片2','products/detil/2.jpg','20');

/*Table structure for table `role_auth` */

DROP TABLE IF EXISTS `role_auth`;

CREATE TABLE `role_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) DEFAULT NULL,
  `authid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `authid` (`authid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `role_auth_ibfk_1` FOREIGN KEY (`authid`) REFERENCES `t_auth` (`authid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=gbk;

/*Data for the table `role_auth` */

insert  into `role_auth`(`id`,`roleid`,`authid`) values (2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,10),(23,2,1),(24,2,7),(25,2,8);

/*Table structure for table `t_auth` */

DROP TABLE IF EXISTS `t_auth`;

CREATE TABLE `t_auth` (
  `authid` int(11) NOT NULL AUTO_INCREMENT,
  `authname` varchar(20) DEFAULT NULL,
  `authpath` varchar(100) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  `authdis` varchar(200) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `iconcls` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`authid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_auth` */

insert  into `t_auth`(`authid`,`authname`,`authpath`,`parentid`,`authdis`,`state`,`iconcls`) values (1,'个人信息管理','',NULL,NULL,'closed','icon-item'),(2,'商品管理','',NULL,NULL,'closed','icon-permission'),(3,'用户管理','',NULL,NULL,'closed','icon-student'),(4,'订单管理','',NULL,NULL,'closed','icon-course'),(5,'商品信息维护','goods.jsp',2,NULL,'open','icon-item'),(6,'查看全部订单','allorders.jsp',4,NULL,'open','icon-item'),(7,'个人信息管理','user.jsp',1,NULL,'open','icon-item'),(8,'个人订单查看','orders.jsp',1,NULL,'open','icon-item'),(10,'查看全部用户信息','alluser.jsp',3,NULL,'open','icon-item');

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(20) DEFAULT NULL,
  `roledis` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`roleid`),
  CONSTRAINT `t_role_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `role_auth` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`roleid`,`rolename`,`roledis`) values (1,'后台管理员','具有最高权限'),(2,'普通用户','普通用户的基本权限');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` varchar(128) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uid`,`username`,`password`,`name`,`email`,`telephone`,`birthday`,`sex`,`state`) values ('3ae7db45-3680-4e63-873f-bc702dc46566','asdasd','asdasd','测试','sa@qq.com','13311111111','2018-01-01','female',1),('3ae7db45-3680-4e63-873f-bc702dc46567','admin','admin',NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) DEFAULT NULL,
  `userid` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `roleid` (`roleid`),
  KEY `userid` (`userid`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `role_auth` (`roleid`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
