/*
Navicat MySQL Data Transfer

Source Server         : guigu
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : hzguigu

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2018-01-30 21:05:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `anthorty_info`
-- ----------------------------
DROP TABLE IF EXISTS `anthorty_info`;
CREATE TABLE `anthorty_info` (
  `anthorty_id` int(11) NOT NULL auto_increment,
  `anthorty_pid` int(11) default NULL,
  `anthorty_nane` varchar(100) default NULL,
  `anthorty_desc` varchar(1000) default NULL,
  `anthorty_url` varchar(1000) default NULL,
  PRIMARY KEY  (`anthorty_id`),
  KEY `FK_Reference_2` (`anthorty_pid`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`anthorty_pid`) REFERENCES `anthorty_info` (`anthorty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of anthorty_info
-- ----------------------------

-- ----------------------------
-- Table structure for `attendance_info`
-- ----------------------------
DROP TABLE IF EXISTS `attendance_info`;
CREATE TABLE `attendance_info` (
  `attendance_id` int(11) NOT NULL auto_increment,
  `student_id` int(11) default NULL,
  `attendance_desc` varchar(100) default NULL,
  `attendance_state` varchar(10) default NULL,
  `attendance_time` datetime default NULL,
  `attendance_remark` varchar(2000) default NULL,
  PRIMARY KEY  (`attendance_id`),
  KEY `FK_Reference_22` (`student_id`),
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`student_id`) REFERENCES `student_info` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendance_info
-- ----------------------------

-- ----------------------------
-- Table structure for `audition_info`
-- ----------------------------
DROP TABLE IF EXISTS `audition_info`;
CREATE TABLE `audition_info` (
  `audition_id` int(11) NOT NULL auto_increment,
  `student_id` int(11) default NULL,
  `audition_time` datetime default NULL,
  `audition_addr` varchar(300) default NULL,
  `audition_course` int(11) default NULL,
  `audition_desc` varchar(2000) default NULL,
  PRIMARY KEY  (`audition_id`),
  KEY `FK_Reference_10` (`student_id`),
  KEY `FK_audition_discipline` (`audition_course`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`student_id`) REFERENCES `student_info` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_audition_discipline` FOREIGN KEY (`audition_course`) REFERENCES `discipline_info` (`discipline_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of audition_info
-- ----------------------------
INSERT INTO `audition_info` VALUES ('1', '2', '2018-01-19 00:00:00', '杭州公共实训基地', '1', '上课有些听不懂，感觉很高大上');
INSERT INTO `audition_info` VALUES ('6', '1', '2018-01-17 00:00:00', '杭州公共实训基地', '2', '老师上课很好');
INSERT INTO `audition_info` VALUES ('7', '5', '2018-01-29 00:00:00', '杭州公共实训基地', '1', '喜欢老师的讲课方式');
INSERT INTO `audition_info` VALUES ('8', '1', '2018-01-17 00:00:00', '杭州公共实训基地', '1', '这个老师的style我不喜欢，我再考虑一下');
INSERT INTO `audition_info` VALUES ('10', '2', '2018-01-24 00:00:00', '杭州公共实训基地', '3', '无');

-- ----------------------------
-- Table structure for `class_info`
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `class_id` int(11) NOT NULL auto_increment,
  `discipline_id` int(11) default NULL,
  `syllabus_id` int(11) default NULL,
  `classroom_id` int(11) default NULL,
  `staff_id` int(11) default NULL,
  `class_name` varchar(100) default NULL,
  `class_number` int(11) default NULL,
  `class_start_time` datetime default NULL,
  `class_end_time` datetime default NULL,
  `class_isused` varchar(10) default NULL,
  `class_state` varchar(10) default NULL,
  `class_desc` varchar(2000) default NULL,
  PRIMARY KEY  (`class_id`),
  KEY `FK_Reference_17` (`discipline_id`),
  KEY `FK_Reference_18` (`syllabus_id`),
  KEY `FK_Reference_19` (`classroom_id`),
  KEY `FK_Reference_20` (`staff_id`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`discipline_id`) REFERENCES `discipline_info` (`discipline_id`),
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`syllabus_id`) REFERENCES `syllabus_info` (`syllabus_id`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`classroom_id`) REFERENCES `classroom_info` (`classroom_id`),
  CONSTRAINT `FK_Reference_20` FOREIGN KEY (`staff_id`) REFERENCES `staff_info` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_info
-- ----------------------------

-- ----------------------------
-- Table structure for `class_transaction_info`
-- ----------------------------
DROP TABLE IF EXISTS `class_transaction_info`;
CREATE TABLE `class_transaction_info` (
  `class_transaction_id` int(11) NOT NULL auto_increment,
  `class_id` int(11) default NULL,
  `class_transaction_tile` varchar(100) default NULL,
  `class_transaction_content` varchar(2000) default NULL,
  `class_transaction_person` varchar(100) default NULL,
  `class_transaction_time` datetime default NULL,
  `class_transaction_remar` varchar(2000) default NULL,
  PRIMARY KEY  (`class_transaction_id`),
  KEY `FK_Reference_21` (`class_id`),
  CONSTRAINT `FK_Reference_21` FOREIGN KEY (`class_id`) REFERENCES `class_info` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_transaction_info
-- ----------------------------

-- ----------------------------
-- Table structure for `classroom_info`
-- ----------------------------
DROP TABLE IF EXISTS `classroom_info`;
CREATE TABLE `classroom_info` (
  `classroom_id` int(11) NOT NULL auto_increment,
  `classroom_name` varchar(100) default NULL,
  `classroom_max` int(11) default NULL,
  `classroom_info` varchar(1000) default NULL,
  `classroom_remark` varchar(2000) default NULL,
  `classroom_mark` varchar(10) default NULL,
  PRIMARY KEY  (`classroom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classroom_info
-- ----------------------------

-- ----------------------------
-- Table structure for `communication_info`
-- ----------------------------
DROP TABLE IF EXISTS `communication_info`;
CREATE TABLE `communication_info` (
  `communication_id` int(11) NOT NULL auto_increment,
  `student_id` int(11) default NULL,
  `staff_id` int(11) default NULL,
  `communication_time` datetime default NULL,
  `communication_content` varchar(2000) default NULL,
  PRIMARY KEY  (`communication_id`),
  KEY `FK_Reference_12` (`student_id`),
  KEY `FK_Reference_13` (`staff_id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`student_id`) REFERENCES `student_info` (`student_id`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`staff_id`) REFERENCES `staff_info` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of communication_info
-- ----------------------------

-- ----------------------------
-- Table structure for `data_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `data_dictionary`;
CREATE TABLE `data_dictionary` (
  `data_id` int(11) NOT NULL auto_increment,
  `data_content` varchar(100) default NULL,
  `data_type` varchar(100) default NULL,
  `data_desc` varchar(2000) default NULL,
  PRIMARY KEY  (`data_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for `discipline_info`
-- ----------------------------
DROP TABLE IF EXISTS `discipline_info`;
CREATE TABLE `discipline_info` (
  `discipline_id` int(11) NOT NULL auto_increment,
  `discipline_name` varchar(100) default NULL,
  `discipline_tuition` int(11) default NULL,
  `discipline_bring` int(11) default NULL,
  `discipline_desc` varchar(2000) default NULL,
  `discipline_isused` varchar(10) default NULL,
  PRIMARY KEY  (`discipline_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of discipline_info
-- ----------------------------
INSERT INTO `discipline_info` VALUES ('1', 'cs_java', '9800', '4400', 'cs', 'no');
INSERT INTO `discipline_info` VALUES ('2', 'cs_c', '9800', '4400', 'cs', 'no');
INSERT INTO `discipline_info` VALUES ('3', 'cs_spring', '9800', '4400', 'cs', 'yes');

-- ----------------------------
-- Table structure for `email_info`
-- ----------------------------
DROP TABLE IF EXISTS `email_info`;
CREATE TABLE `email_info` (
  `email_id` int(11) NOT NULL auto_increment,
  `staff_id` int(11) default NULL,
  `email_title` varchar(1000) default NULL,
  `email_content` varchar(2000) default NULL,
  `email_time` datetime default NULL,
  `email_man` varchar(100) default NULL,
  `email_addr` varchar(300) default NULL,
  `email_state` varchar(10) default NULL,
  PRIMARY KEY  (`email_id`),
  KEY `FK_Reference_7` (`staff_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`staff_id`) REFERENCES `staff_info` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of email_info
-- ----------------------------

-- ----------------------------
-- Table structure for `evaluation_info`
-- ----------------------------
DROP TABLE IF EXISTS `evaluation_info`;
CREATE TABLE `evaluation_info` (
  `evaluation_id` int(11) NOT NULL auto_increment,
  `student_id` int(11) default NULL,
  `evaluation_tile` varchar(100) default NULL,
  `evaluation_content` varchar(2000) default NULL,
  `evaluation_course` varchar(100) default NULL,
  `evaluation_teacher` varchar(100) default NULL,
  `evaluation_time` datetime default NULL,
  PRIMARY KEY  (`evaluation_id`),
  KEY `FK_Reference_11` (`student_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`student_id`) REFERENCES `student_info` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluation_info
-- ----------------------------

-- ----------------------------
-- Table structure for `market_active`
-- ----------------------------
DROP TABLE IF EXISTS `market_active`;
CREATE TABLE `market_active` (
  `active_id` int(11) NOT NULL auto_increment,
  `staff_id` int(11) default NULL,
  `active_name` varchar(300) default NULL,
  `active_state` int(11) default NULL,
  `active_start` datetime default NULL,
  `active_end` datetime default NULL,
  `active_type` int(11) default NULL,
  `active_coste_estimate` double default NULL,
  `active_coste` double default NULL,
  `active_refect_estimate` int(11) default NULL,
  `active_student` varchar(300) default NULL,
  `active_content` varchar(2000) default NULL,
  PRIMARY KEY  (`active_id`),
  KEY `FK_Reference_5` (`staff_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`staff_id`) REFERENCES `staff_info` (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of market_active
-- ----------------------------
INSERT INTO `market_active` VALUES ('1', '1', '活动1', '0', '2017-12-31 13:40:50', '2018-01-25 00:00:00', '0', '1000', '800', '0', '28', 'ms');
INSERT INTO `market_active` VALUES ('2', '2', '活动2', '1', '2018-01-14 13:40:57', '2018-01-25 00:00:00', '1', '1900', '1800', '0', '30', 'ms');
INSERT INTO `market_active` VALUES ('3', '3', '活动3', '1', '2017-12-31 13:40:54', '2018-02-02 13:41:00', '1', '1800', '1700', '0', '19', 'ms');
INSERT INTO `market_active` VALUES ('4', '1', '活动4', '1', '2018-01-01 18:50:17', '2018-01-27 18:50:21', '1', '400', '500', '0', '15', 'ms');

-- ----------------------------
-- Table structure for `message_info`
-- ----------------------------
DROP TABLE IF EXISTS `message_info`;
CREATE TABLE `message_info` (
  `message_id1` int(11) NOT NULL auto_increment,
  `staff_id` int(11) default NULL,
  `message_content` varchar(1000) default NULL,
  `message_man` varchar(10) default NULL,
  `message_phone` varchar(15) default NULL,
  `message_time` datetime default NULL,
  `message_state` varchar(10) default NULL,
  PRIMARY KEY  (`message_id1`),
  KEY `FK_Reference_6` (`staff_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`staff_id`) REFERENCES `staff_info` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_info
-- ----------------------------

-- ----------------------------
-- Table structure for `role_anthorty_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_anthorty_info`;
CREATE TABLE `role_anthorty_info` (
  `role_anthorty_id` int(11) NOT NULL auto_increment,
  `role_id` int(11) default NULL,
  `anthorty_id` int(11) default NULL,
  PRIMARY KEY  (`role_anthorty_id`),
  KEY `FK_Reference_3` (`role_id`),
  KEY `FK_Reference_4` (`anthorty_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`role_id`) REFERENCES `role_info` (`role_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`anthorty_id`) REFERENCES `anthorty_info` (`anthorty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_anthorty_info
-- ----------------------------

-- ----------------------------
-- Table structure for `role_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `role_id` int(11) NOT NULL auto_increment,
  `role_name` varchar(100) default NULL,
  `role_desc` varchar(1000) default NULL,
  `role_state` varchar(10) default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES ('1', '讲师', '负责上课的', '1');
INSERT INTO `role_info` VALUES ('2', '招生负责人', '策划活动招生', '1');
INSERT INTO `role_info` VALUES ('3', '班主任', '班主任', '1');
INSERT INTO `role_info` VALUES ('4', '就业老师', '负责学生的老师', '1');

-- ----------------------------
-- Table structure for `staff_info`
-- ----------------------------
DROP TABLE IF EXISTS `staff_info`;
CREATE TABLE `staff_info` (
  `staff_id` int(11) NOT NULL auto_increment,
  `role_id` int(11) default NULL,
  `staff_name` varchar(100) default NULL,
  `staff_sex` varchar(10) default NULL,
  `staff_age` int(10) default NULL,
  `staff_native_place` varchar(100) default NULL,
  `staff_idcard` varchar(100) default NULL,
  `staff_birthday` datetime default NULL,
  `staff_office_phone` varchar(50) default NULL,
  `staff_mobile_phone` varchar(50) default NULL,
  `staff_email` varchar(100) default NULL,
  `staff_addr` varchar(200) default NULL,
  `staff_qq` varchar(30) default NULL,
  `staff_entry_time` datetime default NULL,
  `staff_education_level` varchar(20) default NULL,
  `staff_remark` varchar(2000) default NULL,
  `staff_state` varchar(10) default NULL COMMENT '1��Ч\r\n            0��Ч',
  `staff_number` varchar(100) default NULL,
  `staff_password` varchar(100) default NULL,
  PRIMARY KEY  (`staff_id`),
  KEY `FK_Reference_1` (`role_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`role_id`) REFERENCES `role_info` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_info
-- ----------------------------
INSERT INTO `staff_info` VALUES ('1', '1', '张三', '男', '30', '浙江杭州', '10001', '2017-10-02 00:00:00', '3455451', '15267882922', '', '', '', null, '??', '', '1', '15958001234', '1234');
INSERT INTO `staff_info` VALUES ('2', '2', '李四', '男', '28', '四川成都', '10002', '2018-01-11 00:00:00', '3455454', '15267882921', '34234234@11', 'fgdgtf', '3424343', '2018-01-25 00:00:00', '??', 'cdefefw', '1', '15958001234', '1234');
INSERT INTO `staff_info` VALUES ('3', '3', '王五', '男', '44', '河南开封', '10004', '2017-12-31 12:57:57', '3455453', '15267882924', null, null, null, null, null, null, null, null, null);
INSERT INTO `staff_info` VALUES ('4', '4', '赵六', '男', '35', '山东烟台', '10003', '2017-12-31 12:57:53', '3455452', '15267882923', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `staff_salary`
-- ----------------------------
DROP TABLE IF EXISTS `staff_salary`;
CREATE TABLE `staff_salary` (
  `staff_salary_id` int(11) NOT NULL auto_increment,
  `staff_id` int(11) default NULL,
  `sta_staff_id` int(11) default NULL,
  `staff_salary_total` double default NULL,
  `staff_salary_deduct` double default NULL,
  `staff_salary_real` double default NULL,
  `staff_salary_isused` varchar(10) default NULL,
  `staff_salary_time` datetime default NULL,
  `remark` varchar(2000) default NULL,
  PRIMARY KEY  (`staff_salary_id`),
  KEY `FK_Reference_25` (`staff_id`),
  KEY `FK_Reference_26` (`sta_staff_id`),
  CONSTRAINT `FK_Reference_25` FOREIGN KEY (`staff_id`) REFERENCES `staff_info` (`staff_id`),
  CONSTRAINT `FK_Reference_26` FOREIGN KEY (`sta_staff_id`) REFERENCES `staff_info` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_salary
-- ----------------------------

-- ----------------------------
-- Table structure for `student_info`
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `student_id` int(11) NOT NULL auto_increment,
  `staff_id` int(11) default NULL,
  `class_id` int(11) default NULL,
  `student_name` varchar(100) default NULL,
  `student_sex` varchar(10) default NULL,
  `student_age` int(11) default NULL,
  `student_tellphone` varchar(100) default NULL,
  `student_email` varchar(200) default NULL,
  `student_idcard` varchar(30) default NULL,
  `student_address` varchar(300) default NULL,
  `student_birthday` datetime default NULL,
  `student_school` varchar(100) default NULL,
  `student_qq` varchar(30) default NULL,
  `student_parents_name` varchar(100) default NULL,
  `student_parents_phone` varchar(100) default NULL,
  `student_pro` varchar(100) default NULL,
  `student_pro_city` varchar(100) default NULL,
  `student_type` varchar(100) default NULL,
  `student_ispay` varchar(10) default NULL,
  `student_state` varchar(10) default NULL,
  `student_mark` int(10) default NULL,
  `student_desc` varchar(2000) default NULL,
  `student_number` varchar(100) default NULL,
  `student_password` varchar(100) default NULL,
  PRIMARY KEY  (`student_id`),
  KEY `FK_Reference_16` (`class_id`),
  KEY `FK_Reference_8` (`staff_id`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`class_id`) REFERENCES `class_info` (`class_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`staff_id`) REFERENCES `staff_info` (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES ('1', '1', null, '小蓝', '女', '23', '17826829375', '12542356@1121', '33032619970808522', '浙江温州', '2018-01-07 00:00:00', '杭州电子科技大学', '1566737437', '李四', '17286374848', '浙江', '杭州', '全额自费', 'yes', '意向低', '0', '学习能力强，独立', 'cs', 'cs');
INSERT INTO `student_info` VALUES ('2', '3', null, '小白', '男', '34', '17826829372', '12542356@1121', '33032619970808522', '浙江杭州', '2018-01-10 15:29:34', 'cjlu', '1566737', '刘友', '17186374848', '四川', '成都', '部分自费', 'yes', '意向低', '1', '有点害羞的，但技术杠杠的', 'cs', 'cs');
INSERT INTO `student_info` VALUES ('4', '1', null, '小黑', '男', '28', '17826829376', '12343434@163.c0m', '33032619970808522', '浙江丽水', '2018-01-09 00:00:00', 'cjlu', '1124566', '王五', '18215666869', '四川', '成都', '全额自费', 'yes', '意向中', '0', '技术一般，嘴皮子很6', 'cs', 'cs');
INSERT INTO `student_info` VALUES ('5', '2', null, '小青', '男', '23', '12672367231', '12542356@1121', '23673467134748078', '浙江温州', '2018-01-11 00:00:00', 'cjlu', '235635634', '胡一八', '13562353236', '四川', '成都', '全额自费', 'yes', '意向中', '0', '技术中上，思维很活跃', 'cs', 'cs');
INSERT INTO `student_info` VALUES ('6', '1', null, '小绿', '保密', '34', '13522321313', '12542356@1121', '23673467134748078', '浙江杭州', '2018-01-12 00:00:00', 'cjlu', '无', '李红', '17286374848', '浙江', '杭州', '部分自费', 'yes', '意向低', '0', '技术一般，组织能力强', 'cs', 'cs');
INSERT INTO `student_info` VALUES ('7', '1', null, '小紫', '保密', '25', '15647485484', '35235623667@qq.com', '56233463467343478', '浙江温州', '2018-01-08 00:00:00', '浙江传媒大学', '23562356', '李浩', '13542556678', '浙江', '杭州', '全额自费', 'no', '意向中', '0', '技术一般，协调能力强', 'cs', 'cs');
INSERT INTO `student_info` VALUES ('8', '4', null, '小白白', '男', '23', '17826829374', '无', '33332619970808522', '浙江杭州', '2017-12-25 19:18:59', '浙江理工大学', '156673733', '张三', '17286374848', '浙江', '杭州', '全额自费', 'no', '意向低', '0', '技术中上，组织能力强', 'cs', 'cs');

-- ----------------------------
-- Table structure for `student_payment`
-- ----------------------------
DROP TABLE IF EXISTS `student_payment`;
CREATE TABLE `student_payment` (
  `payment_id` int(11) NOT NULL auto_increment,
  `student_id` int(11) default NULL,
  `staff_id` int(11) default NULL,
  `payment_situtation` varchar(1000) default NULL,
  `payment_menthod` int(11) default NULL,
  `payment_time` datetime default NULL,
  `payment_discount_amount` double default NULL,
  `payment_should_amount` double default NULL,
  `payment_real_amount` double default NULL,
  `payment_debt_amount` double default NULL,
  `payment_remark` varchar(2000) default NULL,
  PRIMARY KEY  (`payment_id`),
  KEY `FK_Reference_23` (`student_id`),
  KEY `FK_Reference_24` (`staff_id`),
  CONSTRAINT `FK_Reference_23` FOREIGN KEY (`student_id`) REFERENCES `student_info` (`student_id`),
  CONSTRAINT `FK_Reference_24` FOREIGN KEY (`staff_id`) REFERENCES `staff_info` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_payment
-- ----------------------------

-- ----------------------------
-- Table structure for `student_write_grade`
-- ----------------------------
DROP TABLE IF EXISTS `student_write_grade`;
CREATE TABLE `student_write_grade` (
  `write_grade_id` int(11) NOT NULL auto_increment,
  `student_id` int(11) default NULL,
  `staff_id` int(11) default NULL,
  `write_grade_subject` varchar(1000) default NULL,
  `write_grade` varchar(50) default NULL,
  `write_grade_time` datetime default NULL,
  `write_grade_note` varchar(2000) default NULL,
  PRIMARY KEY  (`write_grade_id`),
  KEY `FK_Reference_14` (`student_id`),
  KEY `FK_Reference_15` (`staff_id`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`student_id`) REFERENCES `student_info` (`student_id`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`staff_id`) REFERENCES `staff_info` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_write_grade
-- ----------------------------

-- ----------------------------
-- Table structure for `syllabus_info`
-- ----------------------------
DROP TABLE IF EXISTS `syllabus_info`;
CREATE TABLE `syllabus_info` (
  `syllabus_id` int(11) NOT NULL auto_increment,
  `syllabus_yi` varchar(50) default NULL,
  `syllabus_er` varchar(50) default NULL,
  `syllabus_san` varchar(50) default NULL,
  `syllabus_si` varchar(50) default NULL,
  `syllabus_wu` varchar(50) default NULL,
  `syllabus_liu` varchar(50) default NULL,
  `syllabus_qi` varchar(50) default NULL,
  `syllabus_isused` varchar(50) default NULL,
  `syllabus_name` varchar(100) default NULL,
  PRIMARY KEY  (`syllabus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syllabus_info
-- ----------------------------

-- ----------------------------
-- Table structure for `template_info`
-- ----------------------------
DROP TABLE IF EXISTS `template_info`;
CREATE TABLE `template_info` (
  `template_id` int(11) NOT NULL auto_increment,
  `template_title` varchar(200) default NULL,
  `template_content` varchar(2000) default NULL,
  `template_type` varchar(20) default NULL,
  PRIMARY KEY  (`template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of template_info
-- ----------------------------

-- ----------------------------
-- Table structure for `track_record_info`
-- ----------------------------
DROP TABLE IF EXISTS `track_record_info`;
CREATE TABLE `track_record_info` (
  `track_record_id` int(11) NOT NULL auto_increment,
  `student_id` int(11) default NULL,
  `track_record_title` varchar(200) default NULL,
  `track_record_content` varchar(2000) default NULL,
  `track_record_time` datetime default NULL,
  `enrollment` varchar(10) default NULL,
  `next_record_time` datetime default NULL,
  PRIMARY KEY  (`track_record_id`),
  KEY `FK_Reference_9` (`student_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`student_id`) REFERENCES `student_info` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of track_record_info
-- ----------------------------
INSERT INTO `track_record_info` VALUES ('1', '1', '网上宣传', '归谷初始', '2017-12-27 23:11:24', '意向高', '2018-01-10 23:11:49');
INSERT INTO `track_record_info` VALUES ('2', '2', '学院宣讲会', '招生宣传', '2018-01-01 20:51:23', '意向高', '2018-02-02 20:51:32');
INSERT INTO `track_record_info` VALUES ('3', '2', '上课意见反馈', '阶段评价', '2018-01-01 20:52:22', '意向高', '2018-02-02 20:52:42');
INSERT INTO `track_record_info` VALUES ('4', '5', '宣讲会', '什么是java', '2018-01-15 00:00:00', '意向高', '2018-02-09 00:00:00');
