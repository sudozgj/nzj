/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50535
Source Host           : localhost:3306
Source Database       : nzj

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2017-05-03 20:14:58
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appliance
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt
-- ----------------------------
INSERT INTO `aunt` VALUES ('13', 'fcc', '2', '3', '4', '5', '6', '7', '8', '9', '0', '11', '12', '13', '14', '6');
INSERT INTO `aunt` VALUES ('14', 'fcc', '2', '3', '4', '5', '6', '7', '8', '9', '0', '11', '12', '13', '14', '6');
INSERT INTO `aunt` VALUES ('15', 'fcc', '2', '3', '4', '5', '6', '7', '8', '9', '0', '11', '12', '13', '14', '6');
INSERT INTO `aunt` VALUES ('16', 'fcc', '2', '3', '4', '5', '6', '7', '8', '9', '0', '11', '12', '13', '14', '6');
INSERT INTO `aunt` VALUES ('17', 'fcc', '2', '3', '4', '5', '6', '7', '8', '9', '0', '11', '12', '13', '14', '6');
INSERT INTO `aunt` VALUES ('18', 'fcc', '2', '3', '4', '5', '6', '7', '8', '9', '0', '11', '12', '13', '14', '6');
INSERT INTO `aunt` VALUES ('19', 'fcc', '2', '3', '4', '5', '6', '7', '8', '9', '0', '11', '12', '13', '14', '6');
INSERT INTO `aunt` VALUES ('20', 'fcc', '2', '3', '4', '5', '6', '7', '8', '9', '0', '11', '12', '13', '14', '6');
INSERT INTO `aunt` VALUES ('21', 'fcc', '2', '3', '4', '5', '6', '7', '8', '9', '0', '11', '12', '13', '14', '6');
INSERT INTO `aunt` VALUES ('22', 'fcc', '2', '3', '4', '5', '6', '7', '8', '9', '0', '11', '12', '13', '14', '6');

-- ----------------------------
-- Table structure for `aunt_appliance`
-- ----------------------------
DROP TABLE IF EXISTS `aunt_appliance`;
CREATE TABLE `aunt_appliance` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `aunt_id` bigint(20) NOT NULL,
  `appliance_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_appliance
-- ----------------------------

-- ----------------------------
-- Table structure for `aunt_certificate`
-- ----------------------------
DROP TABLE IF EXISTS `aunt_certificate`;
CREATE TABLE `aunt_certificate` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `aunt_id` bigint(20) NOT NULL,
  `certificate_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_certificate
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_contact
-- ----------------------------

-- ----------------------------
-- Table structure for `aunt_cooking`
-- ----------------------------
DROP TABLE IF EXISTS `aunt_cooking`;
CREATE TABLE `aunt_cooking` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `aunt_id` bigint(20) NOT NULL,
  `cooking_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_cooking
-- ----------------------------

-- ----------------------------
-- Table structure for `aunt_job`
-- ----------------------------
DROP TABLE IF EXISTS `aunt_job`;
CREATE TABLE `aunt_job` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `aunt_id` bigint(20) NOT NULL,
  `job_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_job
-- ----------------------------

-- ----------------------------
-- Table structure for `aunt_language`
-- ----------------------------
DROP TABLE IF EXISTS `aunt_language`;
CREATE TABLE `aunt_language` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `aunt_id` bigint(20) NOT NULL,
  `language_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_language
-- ----------------------------

-- ----------------------------
-- Table structure for `aunt_photo`
-- ----------------------------
DROP TABLE IF EXISTS `aunt_photo`;
CREATE TABLE `aunt_photo` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  `aunt_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_photo
-- ----------------------------

-- ----------------------------
-- Table structure for `aunt_skill`
-- ----------------------------
DROP TABLE IF EXISTS `aunt_skill`;
CREATE TABLE `aunt_skill` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `aunt_id` bigint(20) NOT NULL,
  `skill_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_skill
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aunt_work
-- ----------------------------

-- ----------------------------
-- Table structure for `certificate`
-- ----------------------------
DROP TABLE IF EXISTS `certificate`;
CREATE TABLE `certificate` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of certificate
-- ----------------------------

-- ----------------------------
-- Table structure for `cooking`
-- ----------------------------
DROP TABLE IF EXISTS `cooking`;
CREATE TABLE `cooking` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cooking
-- ----------------------------

-- ----------------------------
-- Table structure for `job`
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------

-- ----------------------------
-- Table structure for `language`
-- ----------------------------
DROP TABLE IF EXISTS `language`;
CREATE TABLE `language` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of language
-- ----------------------------

-- ----------------------------
-- Table structure for `skill`
-- ----------------------------
DROP TABLE IF EXISTS `skill`;
CREATE TABLE `skill` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of skill
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '1234', '1493374897', '0', '0');
INSERT INTO `user` VALUES ('2', '12', 'edge', '1493376291', '4', '0');
INSERT INTO `user` VALUES ('3', '123', '1234', '1493433745', '0', '0');
INSERT INTO `user` VALUES ('4', '34543535', 'dd', '1493433939', '2', '3');
INSERT INTO `user` VALUES ('5', '137135', '123', '1493444969', '-1', '0');
INSERT INTO `user` VALUES ('6', '13714515160', '123', '1493454720', '-1', '0');
INSERT INTO `user` VALUES ('7', '10086', '123', '1493454834', '-1', '0');
INSERT INTO `user` VALUES ('8', '100861', '123', '1493458084', '-1', '0');

-- ----------------------------
-- Table structure for `user_detail`
-- ----------------------------
DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  `company` varchar(255) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `telephone` bigint(20) NOT NULL,
  `phone` bigint(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `charterurl` varchar(255) DEFAULT '',
  `idcardurl` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_detail
-- ----------------------------
INSERT INTO `user_detail` VALUES ('1', '4', 'zgj', 'sy', '小明', '345345435', '123', 'sa', 'http://fsdfa.jpg', '');
INSERT INTO `user_detail` VALUES ('2', '8', 'r', 'ew', '23', '1239', '7603', 'g3', '', 'http23');
INSERT INTO `user_detail` VALUES ('3', '7', 'gggggg23g', 'ew', '23', '1239', '7603', 'g3', null, 'http23');
