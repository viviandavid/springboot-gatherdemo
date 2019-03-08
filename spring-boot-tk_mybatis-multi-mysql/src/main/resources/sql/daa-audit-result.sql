/*
Navicat MySQL Data Transfer

Source Server         : 10.20.4.161_3306
Source Server Version : 50714
Source Host           : 10.20.4.161:3306
Source Database       : daa-audit-result

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-03-08 11:17:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for audit_template
-- ----------------------------
DROP TABLE IF EXISTS `audit_template`;
CREATE TABLE `audit_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `policy_id` int(11) DEFAULT NULL,
  `policy_name` varchar(20) DEFAULT NULL,
  `policy_ip` varchar(15) DEFAULT NULL,
  `policy_mac` varchar(17) DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `starttime` time DEFAULT NULL,
  `endtime` time DEFAULT NULL,
  `policy_class` int(2) DEFAULT NULL,
  `policy_type` int(2) DEFAULT NULL,
  `policy_content` varchar(60) DEFAULT NULL,
  `inserttime` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2636861 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `inserttime` varchar(30) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3943 DEFAULT CHARSET=utf8;
