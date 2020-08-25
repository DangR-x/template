/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : template

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-08-25 17:36:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT '头像',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` int(11) DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='后台用户表';

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'DangR-X', '$2a$10$45yJ4lHWpVwXAx4nkUjwc.ugfsDhndGUVZlmnfWIE7vz4eTvtYZza', null, '1023056792@qq.com', '牛逼', null, '2020-08-25 17:02:36', null, '1');
