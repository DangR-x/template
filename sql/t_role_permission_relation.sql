/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : template

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-08-25 17:37:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission_relation`;
CREATE TABLE `t_role_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='后台用户角色和权限关系表';

-- ----------------------------
-- Records of t_role_permission_relation
-- ----------------------------
INSERT INTO `t_role_permission_relation` VALUES ('1', '3', '1');
INSERT INTO `t_role_permission_relation` VALUES ('2', '3', '2');
INSERT INTO `t_role_permission_relation` VALUES ('3', '3', '3');
INSERT INTO `t_role_permission_relation` VALUES ('4', '3', '7');
INSERT INTO `t_role_permission_relation` VALUES ('5', '3', '8');
INSERT INTO `t_role_permission_relation` VALUES ('6', '2', '4');
INSERT INTO `t_role_permission_relation` VALUES ('7', '2', '9');
INSERT INTO `t_role_permission_relation` VALUES ('8', '2', '10');
INSERT INTO `t_role_permission_relation` VALUES ('9', '2', '11');
INSERT INTO `t_role_permission_relation` VALUES ('10', '3', '5');
INSERT INTO `t_role_permission_relation` VALUES ('11', '3', '12');
INSERT INTO `t_role_permission_relation` VALUES ('12', '3', '13');
INSERT INTO `t_role_permission_relation` VALUES ('13', '3', '14');
INSERT INTO `t_role_permission_relation` VALUES ('14', '4', '6');
INSERT INTO `t_role_permission_relation` VALUES ('15', '4', '15');
INSERT INTO `t_role_permission_relation` VALUES ('16', '4', '16');
INSERT INTO `t_role_permission_relation` VALUES ('17', '4', '17');
INSERT INTO `t_role_permission_relation` VALUES ('18', '1', '1');
INSERT INTO `t_role_permission_relation` VALUES ('19', '1', '2');
INSERT INTO `t_role_permission_relation` VALUES ('20', '1', '3');
INSERT INTO `t_role_permission_relation` VALUES ('21', '1', '7');
INSERT INTO `t_role_permission_relation` VALUES ('22', '1', '8');
INSERT INTO `t_role_permission_relation` VALUES ('23', '1', '12');
