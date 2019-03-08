/*
Navicat MySQL Data Transfer

Source Server         : 10.20.4.161_3306
Source Server Version : 50714
Source Host           : 10.20.4.161:3306
Source Database       : daa-audit

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-03-08 11:14:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for au_object
-- ----------------------------
DROP TABLE IF EXISTS `au_object`;
CREATE TABLE `au_object` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(200) DEFAULT NULL COMMENT 'name',
  `remark` varchar(200) DEFAULT NULL COMMENT 'remark',
  `schedule` int(5) DEFAULT NULL COMMENT 'schedule',
  `enable` int(11) DEFAULT NULL COMMENT 'enable',
  `logtime` int(11) DEFAULT NULL COMMENT 'logtime',
  `groupid` bigint(11) DEFAULT NULL,
  `createtime` varchar(25) DEFAULT NULL COMMENT 'createtime',
  `updatetime` varchar(25) DEFAULT NULL,
  `createuserid` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='审计对象';

-- ----------------------------
-- Records of au_object
-- ----------------------------
INSERT INTO `au_object` VALUES ('5', '审计中心2.0', '优秀的产品', '3', '1', '6', '1', '2019-02-22 10:56:08', '2019-03-07 10:54:43', '1782681579');
INSERT INTO `au_object` VALUES ('17', 'bb', null, null, '0', null, '1', '2019-02-23 14:17:56', '2019-03-06 15:56:29', '49');
INSERT INTO `au_object` VALUES ('23', '审计对象测试', '优秀的审计对象', '5', '0', '6', null, '2019-02-28 14:37:39', null, '111');
INSERT INTO `au_object` VALUES ('25', '审计对象测试22', '优秀的审计对象', '5', '0', '6', null, '2019-02-28 14:38:51', null, '111');
INSERT INTO `au_object` VALUES ('27', 'admin', 'dddd', null, '0', null, null, '2019-02-28 14:42:34', null, '111');
INSERT INTO `au_object` VALUES ('29', '111111111', '1111111111', null, '0', null, '1', '2019-03-01 09:14:29', '2019-03-06 15:56:15', '111');
INSERT INTO `au_object` VALUES ('31', '2222', '222222222', null, '0', null, null, '2019-03-01 09:17:32', null, '111');
INSERT INTO `au_object` VALUES ('35', '对象33', null, null, '0', null, null, '2019-03-07 09:33:17', null, '1');
