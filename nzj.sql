/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50535
Source Host           : localhost:3306
Source Database       : nzj

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2017-04-29 18:38:21
*/

SET FOREIGN_KEY_CHECKS=0;
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
