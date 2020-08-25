/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : template

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-08-25 17:38:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` bigint(20) DEFAULT NULL,
  `menu` varchar(255) DEFAULT NULL,
  `file` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '小明', '123', '1', null, 'http://localhost:9001/xiong/15d0a5bc1918d6.png');
INSERT INTO `t_user` VALUES ('2', '小花', '321', '1', null, 'http://localhost:9001/xiong/5ebb4ba00b868.png');
INSERT INTO `t_user` VALUES ('3', '小米', '123', '1', null, 'http://localhost:9001/xiong/5ebb4b71ebfe4.png');
