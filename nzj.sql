/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50535
Source Host           : localhost:3306
Source Database       : nzj

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2017-05-07 18:43:10
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `appliance`
-- ----------------------------
DROP TABLE IF EXISTS `appliance`;
CREATE TABLE `appliance` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appliance
-- ----------------------------
INSERT INTO `appliance` VALUES ('1', '电饭锅');
INSERT INTO `appliance` VALUES ('2', '煤气灶');
INSERT INTO `appliance` VALUES ('3', '电冰箱');
INSERT INTO `appliance` VALUES ('4', '高压锅');
INSERT INTO `appliance` VALUES ('5', '吸尘器');
INSERT INTO `appliance` VALUES ('6', '电磁炉');
INSERT INTO `appliance` VALUES ('7', '微波炉');
INSERT INTO `appliance` VALUES ('8', '消毒柜');
INSERT INTO `appliance` VALUES ('9', '洗衣机');

-- ----------------------------
-- Table structure for `aunt`
-- ----------------------------
DROP TABLE IF EXISTS `aunt`;
CREATE TABLE `aunt` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `sign` varchar(255) NOT NULL,
  `native` varchar(255) NOT NULL,
  `sex` int(11) NOT NULL,
  `education` varchar(255) NOT NULL,
  `marriage` int(11) NOT NULL,
  `nation` varchar(255) NOT NULL,
  `height` double NOT NULL,
  `weight` double NOT NULL,
  `sigh` double NOT NULL,
  `idnumber` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt
-- ----------------------------
INSERT INTO `aunt` VALUES ('30', 'zzz', '1', '3', '3', '6', '1', '2', '2', '4', '3', '4', '111111', '5', '2', '6');
INSERT INTO `aunt` VALUES ('31', '13', '2', '3', '4', '5', '6', '7', '8', '9', '0', '123', '7723', '1', '2', '1');
INSERT INTO `aunt` VALUES ('32', '阿斯蒂芬', '1', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '6');
INSERT INTO `aunt` VALUES ('36', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '2', '3', '6');

-- ----------------------------
-- Table structure for `aunt_appliance`
-- ----------------------------
DROP TABLE IF EXISTS `aunt_appliance`;
CREATE TABLE `aunt_appliance` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `aunt_id` bigint(20) NOT NULL,
  `appliance_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_appliance
-- ----------------------------
INSERT INTO `aunt_appliance` VALUES ('8', '30', '3');
INSERT INTO `aunt_appliance` VALUES ('9', '31', '3');
INSERT INTO `aunt_appliance` VALUES ('10', '32', '3');
INSERT INTO `aunt_appliance` VALUES ('19', '888', '6');
INSERT INTO `aunt_appliance` VALUES ('23', '36', '2');

-- ----------------------------
-- Table structure for `aunt_certificate`
-- ----------------------------
DROP TABLE IF EXISTS `aunt_certificate`;
CREATE TABLE `aunt_certificate` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `aunt_id` bigint(20) NOT NULL,
  `certificate_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_certificate
-- ----------------------------
INSERT INTO `aunt_certificate` VALUES ('8', '30', '5');
INSERT INTO `aunt_certificate` VALUES ('9', '31', '5');
INSERT INTO `aunt_certificate` VALUES ('10', '32', '3');
INSERT INTO `aunt_certificate` VALUES ('14', '36', '2');

-- ----------------------------
-- Table structure for `aunt_contact`
-- ----------------------------
DROP TABLE IF EXISTS `aunt_contact`;
CREATE TABLE `aunt_contact` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) NOT NULL,
  `relation` varchar(255) NOT NULL,
  `workstatus` varchar(255) NOT NULL,
  `cphone` varchar(255) NOT NULL,
  `aunt_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_contact
-- ----------------------------
INSERT INTO `aunt_contact` VALUES ('14', '6', '7', '8', '9', '30');
INSERT INTO `aunt_contact` VALUES ('15', '4', '32', '-', '0', '30');
INSERT INTO `aunt_contact` VALUES ('16', '6', '7', '8', '9', '31');
INSERT INTO `aunt_contact` VALUES ('17', '4', '32', '-', '0', '31');
INSERT INTO `aunt_contact` VALUES ('29', '2', '2', '2', '1', '36');
INSERT INTO `aunt_contact` VALUES ('30', '1', '2', '3', '4', '36');
INSERT INTO `aunt_contact` VALUES ('34', 's', '323', 'dsfa', 'fwef', '32');
INSERT INTO `aunt_contact` VALUES ('35', 'fer', 'f34g', 'vvafd', 'vsdfv', '32');
INSERT INTO `aunt_contact` VALUES ('36', '4g', 'ds', 'vsd', 'vd', '32');

-- ----------------------------
-- Table structure for `aunt_cooking`
-- ----------------------------
DROP TABLE IF EXISTS `aunt_cooking`;
CREATE TABLE `aunt_cooking` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `aunt_id` bigint(20) NOT NULL,
  `cooking_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_cooking
-- ----------------------------
INSERT INTO `aunt_cooking` VALUES ('8', '30', '1');
INSERT INTO `aunt_cooking` VALUES ('9', '31', '1');
INSERT INTO `aunt_cooking` VALUES ('10', '32', '3');
INSERT INTO `aunt_cooking` VALUES ('14', '36', '2');

-- ----------------------------
-- Table structure for `aunt_job`
-- ----------------------------
DROP TABLE IF EXISTS `aunt_job`;
CREATE TABLE `aunt_job` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `aunt_id` bigint(20) NOT NULL,
  `job_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_job
-- ----------------------------
INSERT INTO `aunt_job` VALUES ('8', '30', '4');
INSERT INTO `aunt_job` VALUES ('9', '31', '4');
INSERT INTO `aunt_job` VALUES ('10', '32', '3');
INSERT INTO `aunt_job` VALUES ('14', '36', '2');

-- ----------------------------
-- Table structure for `aunt_language`
-- ----------------------------
DROP TABLE IF EXISTS `aunt_language`;
CREATE TABLE `aunt_language` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `aunt_id` bigint(20) NOT NULL,
  `language_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_language
-- ----------------------------
INSERT INTO `aunt_language` VALUES ('9', '30', '3');
INSERT INTO `aunt_language` VALUES ('10', '31', '3');
INSERT INTO `aunt_language` VALUES ('11', '32', '3');
INSERT INTO `aunt_language` VALUES ('15', '36', '2');

-- ----------------------------
-- Table structure for `aunt_photo`
-- ----------------------------
DROP TABLE IF EXISTS `aunt_photo`;
CREATE TABLE `aunt_photo` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  `aunt_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_photo
-- ----------------------------
INSERT INTO `aunt_photo` VALUES ('8', 'http://192.168.1.128:8080/nzj/upload/aunt_photo/1493956064_8.png', '30');
INSERT INTO `aunt_photo` VALUES ('9', 'http://192.168.1.115:8080/nzj/upload/aunt_photo/1493972091_8.png', '31');
INSERT INTO `aunt_photo` VALUES ('10', 'http://192.168.1.115:8080/nzj/upload/aunt_photo/1494125722_5.png', '32');
INSERT INTO `aunt_photo` VALUES ('14', 'http://192.168.1.115:8080/nzj/upload/aunt_photo/1494125722_5.png', '36');

-- ----------------------------
-- Table structure for `aunt_skill`
-- ----------------------------
DROP TABLE IF EXISTS `aunt_skill`;
CREATE TABLE `aunt_skill` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `aunt_id` bigint(20) NOT NULL,
  `skill_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_skill
-- ----------------------------
INSERT INTO `aunt_skill` VALUES ('8', '30', '2');
INSERT INTO `aunt_skill` VALUES ('9', '31', '2');
INSERT INTO `aunt_skill` VALUES ('10', '32', '3');
INSERT INTO `aunt_skill` VALUES ('14', '36', '2');

-- ----------------------------
-- Table structure for `aunt_work`
-- ----------------------------
DROP TABLE IF EXISTS `aunt_work`;
CREATE TABLE `aunt_work` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `time` varchar(255) NOT NULL,
  `work` varchar(255) NOT NULL,
  `aunt_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_work
-- ----------------------------
INSERT INTO `aunt_work` VALUES ('8', '12', '34', '30');
INSERT INTO `aunt_work` VALUES ('9', '12', '34', '31');
INSERT INTO `aunt_work` VALUES ('14', '3', '5', '36');
INSERT INTO `aunt_work` VALUES ('15', 'v', 'sd', '32');
INSERT INTO `aunt_work` VALUES ('16', 'vdsv', 'f', '32');

-- ----------------------------
-- Table structure for `certificate`
-- ----------------------------
DROP TABLE IF EXISTS `certificate`;
CREATE TABLE `certificate` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of certificate
-- ----------------------------
INSERT INTO `certificate` VALUES ('1', '月嫂证');
INSERT INTO `certificate` VALUES ('2', '育婴师证');
INSERT INTO `certificate` VALUES ('3', '催乳师证');
INSERT INTO `certificate` VALUES ('4', '厨师证');
INSERT INTO `certificate` VALUES ('5', '营养师证');
INSERT INTO `certificate` VALUES ('6', '驾照');
INSERT INTO `certificate` VALUES ('7', '港澳通行证');
INSERT INTO `certificate` VALUES ('8', '学历证');
INSERT INTO `certificate` VALUES ('9', '乙肝两对半');

-- ----------------------------
-- Table structure for `cooking`
-- ----------------------------
DROP TABLE IF EXISTS `cooking`;
CREATE TABLE `cooking` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cooking
-- ----------------------------
INSERT INTO `cooking` VALUES ('1', '广东菜');
INSERT INTO `cooking` VALUES ('2', '辣菜');
INSERT INTO `cooking` VALUES ('3', '北方菜');
INSERT INTO `cooking` VALUES ('4', '面食');
INSERT INTO `cooking` VALUES ('5', '海鲜');

-- ----------------------------
-- Table structure for `employer`
-- ----------------------------
DROP TABLE IF EXISTS `employer`;
CREATE TABLE `employer` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `time` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `adress` varchar(255) DEFAULT '',
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employer
-- ----------------------------
INSERT INTO `employer` VALUES ('24', '1', '1483200000', '小蛋', '18124604560', '深圳市龙岗山海津E栋502', '住家保姆');
INSERT INTO `employer` VALUES ('26', '6', '1483200000', 'wefwef', '2', 'joasdjfasjfjo', 'jj');

-- ----------------------------
-- Table structure for `job`
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES ('1', '保姆');
INSERT INTO `job` VALUES ('2', '育婴师');
INSERT INTO `job` VALUES ('3', '月嫂');
INSERT INTO `job` VALUES ('4', '照顾老人');
INSERT INTO `job` VALUES ('5', '家教');
INSERT INTO `job` VALUES ('6', '钟点');

-- ----------------------------
-- Table structure for `language`
-- ----------------------------
DROP TABLE IF EXISTS `language`;
CREATE TABLE `language` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of language
-- ----------------------------
INSERT INTO `language` VALUES ('1', '普通话');
INSERT INTO `language` VALUES ('2', '白话');
INSERT INTO `language` VALUES ('3', '客家话');
INSERT INTO `language` VALUES ('4', '潮州话');
INSERT INTO `language` VALUES ('5', '英语');

-- ----------------------------
-- Table structure for `skill`
-- ----------------------------
DROP TABLE IF EXISTS `skill`;
CREATE TABLE `skill` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of skill
-- ----------------------------
INSERT INTO `skill` VALUES ('1', '做饭');
INSERT INTO `skill` VALUES ('2', '搞卫生');
INSERT INTO `skill` VALUES ('3', '带小孩');
INSERT INTO `skill` VALUES ('4', '月子餐');
INSERT INTO `skill` VALUES ('5', '辅食添加');
INSERT INTO `skill` VALUES ('6', '手洗衣服');
INSERT INTO `skill` VALUES ('7', '烫衣服');
INSERT INTO `skill` VALUES ('8', '手擦地板');
INSERT INTO `skill` VALUES ('9', '喜欢动物');
INSERT INTO `skill` VALUES ('10', '辅导小孩功课');
INSERT INTO `skill` VALUES ('11', '自行车');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `phone` bigint(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `clock` bigint(20) NOT NULL,
  `rank` int(11) NOT NULL,
  `ack` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '1234', '1493374897', '0', '0');
INSERT INTO `user` VALUES ('6', '13714515160', '123', '1493454720', '-1', '0');
INSERT INTO `user` VALUES ('8', '100861', '123', '1493458084', '-1', '0');
INSERT INTO `user` VALUES ('10', '990', '1', '1493972409', '-1', '0');

-- ----------------------------
-- Table structure for `user_detail`
-- ----------------------------
DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  `company` varchar(255) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `telephone` bigint(20) NOT NULL,
  `dphone` bigint(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `charterurl` varchar(255) DEFAULT '',
  `idcardurl` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_detail
-- ----------------------------
INSERT INTO `user_detail` VALUES ('1', '1', '大声道啊啊啊啊啊啊', 'sy1是是', '小明1晓得撒打算', '3453454351', '14141', 'sadsdsa1111', '', '');
INSERT INTO `user_detail` VALUES ('2', '6', 'r', 'ew', '23', '1239', '7603', 'g3', 'http23', 'http23');
INSERT INTO `user_detail` VALUES ('3', '8', 'gggggg23g', 'ew', '23', '1239', '7603', 'g3', 'http23', 'http23');
INSERT INTO `user_detail` VALUES ('5', '10', 'kakaka', '2', '21', '245', '2', 'la', '', '');

-- ----------------------------
-- View structure for `v_aunt`
-- ----------------------------
DROP VIEW IF EXISTS `v_aunt`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_aunt` AS select `a`.`id` AS `id`,`a`.`name` AS `name`,`a`.`age` AS `age`,`a`.`sign` AS `sign`,`a`.`native` AS `native`,`a`.`sex` AS `sex`,`a`.`education` AS `education`,`a`.`marriage` AS `marriage`,`a`.`nation` AS `nation`,`a`.`height` AS `height`,`a`.`weight` AS `weight`,`a`.`sigh` AS `sigh`,`a`.`idnumber` AS `idnumber`,`a`.`phone` AS `phone`,`a`.`address` AS `address`,`a`.`user_id` AS `user_id`,`ap`.`url` AS `url` from (`aunt` `a` join `aunt_photo` `ap`) where (`a`.`id` = `ap`.`aunt_id`);

-- ----------------------------
-- View structure for `v_language`
-- ----------------------------
DROP VIEW IF EXISTS `v_language`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_language` AS select `al`.`id` AS `id`,`al`.`aunt_id` AS `aunt_id`,`al`.`language_id` AS `language_id`,`l`.`name` AS `name` from (`aunt_language` `al` join `language` `l`) where (`al`.`language_id` = `l`.`id`);

-- ----------------------------
-- View structure for `v_user`
-- ----------------------------
DROP VIEW IF EXISTS `v_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_user` AS select `u`.`id` AS `id`,`u`.`phone` AS `phone`,date_format(from_unixtime(`u`.`clock`),'%Y-%m-%d %H:%i:%S') AS `time`,`u`.`rank` AS `rank`,`u`.`ack` AS `ack`,`ud`.`username` AS `username`,`ud`.`company` AS `company`,`ud`.`contact` AS `contact`,`ud`.`telephone` AS `telephone`,`ud`.`dphone` AS `dphone`,`ud`.`address` AS `address`,`ud`.`charterurl` AS `charterurl`,`ud`.`idcardurl` AS `idcardurl`,`ud`.`id` AS `did` from (`user` `u` join `user_detail` `ud`) where (`u`.`id` = `ud`.`user_id`);
