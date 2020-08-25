/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : template

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-08-25 17:37:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `after_sale` varchar(255) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `commission` decimal(10,0) DEFAULT NULL,
  `commission_type` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fx_type` int(11) DEFAULT NULL,
  `got_score` int(11) DEFAULT NULL,
  `got_score_type` int(11) DEFAULT NULL,
  `hidden` int(11) DEFAULT NULL,
  `kanjia` tinyint(4) DEFAULT NULL,
  `limitation` tinyint(4) DEFAULT NULL,
  `kanjia_price` varchar(10) DEFAULT NULL,
  `logistics_id` bigint(20) DEFAULT NULL,
  `max_coupons` int(11) DEFAULT NULL,
  `miaosha` tinyint(4) DEFAULT NULL,
  `min_price` varchar(10) DEFAULT NULL,
  `min_score` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number_fav` int(11) DEFAULT NULL,
  `number_goodrequtation` int(11) DEFAULT NULL COMMENT '名声',
  `number_orders` int(11) DEFAULT NULL COMMENT '订单',
  `number_sells` int(11) DEFAULT NULL COMMENT '售卖数量',
  `original_price` varchar(10) DEFAULT NULL COMMENT '原价',
  `paixu` int(11) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `pingtuan` tinyint(4) DEFAULT NULL,
  `pingtuan_price` varchar(10) DEFAULT NULL,
  `recommend_status` int(11) DEFAULT NULL COMMENT '推荐',
  `recommend_statusstr` varchar(255) DEFAULT NULL,
  `sell_end` tinyint(4) DEFAULT NULL,
  `sell_start` tinyint(4) DEFAULT NULL,
  `shop_id` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `statusstr` varchar(255) DEFAULT NULL,
  `store_alert` tinyint(4) DEFAULT NULL,
  `stores` bigint(20) DEFAULT NULL COMMENT '商店',
  `stores_unsale` tinyint(4) DEFAULT NULL,
  `admin_id` bigint(20) DEFAULT NULL,
  `vet_status` int(11) DEFAULT NULL,
  `views` bigint(20) DEFAULT NULL COMMENT '查看人数',
  `weight` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('1', 'haha', '2', '6', '1', '2020-05-23 09:47:52', null, '2', null, '1', '1', '0', '0', null, null, null, '0', null, null, null, null, null, null, null, null, null, null, '0', '3', null, null, '0', '0', null, null, null, '0', null, '0', '1', null, null, null);
INSERT INTO `t_goods` VALUES ('2', 'haha', '2', '6', '1', '2020-05-23 10:21:54', null, '2', null, '1', '1', '0', '0', null, null, null, '0', null, null, null, null, null, null, null, null, null, null, '0', null, null, null, '0', '0', null, null, null, '0', null, '0', '1', null, null, null);
