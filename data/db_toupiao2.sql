/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50087
Source Host           : localhost:3306
Source Database       : db_toupiao2

Target Server Type    : MYSQL
Target Server Version : 50087
File Encoding         : 65001

Date: 2018-03-31 22:49:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `userId` int(11) NOT NULL auto_increment,
  `userName` varchar(50) default NULL,
  `userPw` varchar(50) default NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'a', 'a');
INSERT INTO `t_admin` VALUES ('2', 'admin', 'admin');
INSERT INTO `t_admin` VALUES ('3', '陈小西', '123');

-- ----------------------------
-- Table structure for `t_gonggao`
-- ----------------------------
DROP TABLE IF EXISTS `t_gonggao`;
CREATE TABLE `t_gonggao` (
  `gonggao_id` int(11) NOT NULL auto_increment,
  `gonggao_title` varchar(50) default NULL,
  `gonggao_content` varchar(255) default NULL,
  `gonggao_data` varchar(50) default NULL,
  `gonggao_fabuzhe` varchar(50) default NULL,
  `gonggao_del` varchar(50) default NULL,
  PRIMARY KEY  (`gonggao_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gonggao
-- ----------------------------
INSERT INTO `t_gonggao` VALUES ('1', '测试公告测试公告测试公告测试告测', '测试公告测试公告测试公告测试公告测试公告', '2012-4-18 12:21:28', null, null);
INSERT INTO `t_gonggao` VALUES ('2', '222222222222222222222222', '1111111111111111111111111111111111', '2012-4-18 12:21:36', null, null);

-- ----------------------------
-- Table structure for `t_toupiao`
-- ----------------------------
DROP TABLE IF EXISTS `t_toupiao`;
CREATE TABLE `t_toupiao` (
  `id` varchar(255) NOT NULL default '',
  `title` varchar(255) default NULL,
  `type` int(11) default NULL,
  `wenjuan_id` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_toupiao
-- ----------------------------
INSERT INTO `t_toupiao` VALUES ('1522501728254', '顺序题目1', '1', '1522500992236');
INSERT INTO `t_toupiao` VALUES ('1522501872899', '跳转题目1', '1', '1522500998573');
INSERT INTO `t_toupiao` VALUES ('1522501914591', '跳转题目2', '3', '1522500998573');
INSERT INTO `t_toupiao` VALUES ('1522503984176', '顺序题目2', '2', '1522500992236');
INSERT INTO `t_toupiao` VALUES ('1522504000102', '顺序题目3', '3', '1522500992236');
INSERT INTO `t_toupiao` VALUES ('1522504966021', '跳转题目3', '1', '1522500998573');

-- ----------------------------
-- Table structure for `t_toupiaoxuanxiang`
-- ----------------------------
DROP TABLE IF EXISTS `t_toupiaoxuanxiang`;
CREATE TABLE `t_toupiaoxuanxiang` (
  `id` varchar(255) NOT NULL default '',
  `xuanxiangneirong` varchar(255) default NULL,
  `piaoshu` int(11) default NULL,
  `toupiao_id` varchar(255) default NULL,
  `toupiao_rel_id` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_toupiaoxuanxiang
-- ----------------------------
INSERT INTO `t_toupiaoxuanxiang` VALUES ('1522501728761', '1', '1', '1522501728254', null);
INSERT INTO `t_toupiaoxuanxiang` VALUES ('1522501728765', '2', '4', '1522501728254', null);
INSERT INTO `t_toupiaoxuanxiang` VALUES ('1522501728767', '3', '0', '1522501728254', null);
INSERT INTO `t_toupiaoxuanxiang` VALUES ('1522501872903', '1', '2', '1522501872899', '1522501914591');
INSERT INTO `t_toupiaoxuanxiang` VALUES ('1522501872906', '2', '1', '1522501872899', '1522504966021');
INSERT INTO `t_toupiaoxuanxiang` VALUES ('1522501872908', '3', '1', '1522501872899', '');
INSERT INTO `t_toupiaoxuanxiang` VALUES ('1522501914595', '正确答案是', '0', '1522501914591', null);
INSERT INTO `t_toupiaoxuanxiang` VALUES ('1522503984188', '4', '4', '1522503984176', null);
INSERT INTO `t_toupiaoxuanxiang` VALUES ('1522503984190', '5', '2', '1522503984176', null);
INSERT INTO `t_toupiaoxuanxiang` VALUES ('1522503984193', '6', '2', '1522503984176', null);
INSERT INTO `t_toupiaoxuanxiang` VALUES ('1522504000105', '正确答案是', '0', '1522504000102', null);
INSERT INTO `t_toupiaoxuanxiang` VALUES ('1522504966025', '10', null, '1522504966021', '1522501914591');
INSERT INTO `t_toupiaoxuanxiang` VALUES ('1522504966027', '11', null, '1522504966021', '');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL auto_increment,
  `user_name` varchar(50) default NULL,
  `user_pw` varchar(50) default NULL,
  `user_realname` varchar(50) default NULL,
  `user_address` varchar(50) default NULL,
  `user_sex` varchar(50) default NULL,
  `user_tel` varchar(50) default NULL,
  `user_email` varchar(50) default NULL,
  `user_qq` varchar(50) default NULL,
  `user_del` varchar(50) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'liusan', '000000', '刘三', '北京路', '男', '13888888888', 'liusan@yahoo.cn', '11111', 'no');
INSERT INTO `t_user` VALUES ('2', 'lisisi', '000000', '李思思', '北京路', '男', '13999999999', 'lisisi@yaho.cn', '2223', 'yes');
INSERT INTO `t_user` VALUES ('3', 'cj', 'cj', 'cj', '重庆', '男', '123456', '123@qq.com', '12345678', 'no');
INSERT INTO `t_user` VALUES ('4', '123', '123', '123', '123', '男', '123', '123', '123', 'no');
INSERT INTO `t_user` VALUES ('5', '你好', '123', '123', '123', '男', '123', '123', '123', 'no');
INSERT INTO `t_user` VALUES ('6', '123', '123', '123', '123', '男', '123', '123', '123', 'no');

-- ----------------------------
-- Table structure for `t_web`
-- ----------------------------
DROP TABLE IF EXISTS `t_web`;
CREATE TABLE `t_web` (
  `id` int(20) NOT NULL auto_increment,
  `content_info` varchar(200) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_web
-- ----------------------------
INSERT INTO `t_web` VALUES ('1', '123');

-- ----------------------------
-- Table structure for `t_wenjuan`
-- ----------------------------
DROP TABLE IF EXISTS `t_wenjuan`;
CREATE TABLE `t_wenjuan` (
  `id` varchar(255) NOT NULL default '',
  `mingcheng` varchar(255) default NULL,
  `shijian` varchar(255) default NULL,
  `mingcheng_type` int(11) default '1',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_wenjuan
-- ----------------------------
INSERT INTO `t_wenjuan` VALUES ('1522500992236', 'test1', '2018-03-31', '1');
INSERT INTO `t_wenjuan` VALUES ('1522500998573', 'test2', '2018-03-31', '2');
