/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : template

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-08-25 17:37:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_role_relation`;
CREATE TABLE `t_admin_role_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='后台用户和角色关系表';

-- ----------------------------
-- Records of t_admin_role_relation
-- ----------------------------
INSERT INTO `t_admin_role_relation` VALUES ('1', '1', '1');
