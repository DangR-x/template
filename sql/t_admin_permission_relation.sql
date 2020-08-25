/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : template

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-08-25 17:37:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_permission_relation`;
CREATE TABLE `t_admin_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台用户和权限关系表(除角色中定义的权限以外的加减权限)';

-- ----------------------------
-- Records of t_admin_permission_relation
-- ----------------------------
