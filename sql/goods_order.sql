/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2021-02-20 12:55:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods_order
-- ----------------------------
DROP TABLE IF EXISTS `goods_order`;
CREATE TABLE `goods_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;
