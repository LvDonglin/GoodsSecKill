/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2021-02-20 14:26:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` int(11) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(255) DEFAULT NULL,
  `goodsNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
