/*
Navicat MySQL Data Transfer

Source Server         : 测试环境
Source Database       : dbtest

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-12-25 10:37:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_city_code`
-- ----------------------------
DROP TABLE IF EXISTS `t_city_code`;
CREATE TABLE `t_city_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '城市名称',
  `code` varchar(50) NOT NULL COMMENT '城市编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_city_code
-- ----------------------------
INSERT INTO `t_city_code` VALUES ('3', '北京市', '110000');
INSERT INTO `t_city_code` VALUES ('5', '天津市', '120000');
INSERT INTO `t_city_code` VALUES ('7', '重庆市', '500000');
INSERT INTO `t_city_code` VALUES ('9', '上海市', '310000');
INSERT INTO `t_city_code` VALUES ('11', '呼和浩特市', '150100');
INSERT INTO `t_city_code` VALUES ('13', '南宁市', '450100');
INSERT INTO `t_city_code` VALUES ('15', '银川市', '640100');
INSERT INTO `t_city_code` VALUES ('17', '拉萨市', '540100');
INSERT INTO `t_city_code` VALUES ('19', '乌鲁木齐市', '650100');
INSERT INTO `t_city_code` VALUES ('21', '海口市', '460100');
INSERT INTO `t_city_code` VALUES ('23', '石家庄市', '130100');
INSERT INTO `t_city_code` VALUES ('25', '哈尔滨市', '230100');
INSERT INTO `t_city_code` VALUES ('27', '长春市', '220100');
INSERT INTO `t_city_code` VALUES ('29', '沈阳市', '210100');
INSERT INTO `t_city_code` VALUES ('31', '太原市', '140100');
INSERT INTO `t_city_code` VALUES ('33', '济南市', '370100');
INSERT INTO `t_city_code` VALUES ('35', '郑州市', '410100');
INSERT INTO `t_city_code` VALUES ('37', '西安市', '610100');
INSERT INTO `t_city_code` VALUES ('39', '兰州市', '620100');
INSERT INTO `t_city_code` VALUES ('41', '西宁市', '630100');
INSERT INTO `t_city_code` VALUES ('43', '成都市', '510100');
INSERT INTO `t_city_code` VALUES ('45', '武汉市', '420100');
INSERT INTO `t_city_code` VALUES ('47', '合肥市', '340100');
INSERT INTO `t_city_code` VALUES ('49', '南京市', '320100');
INSERT INTO `t_city_code` VALUES ('51', '杭州市', '330100');
INSERT INTO `t_city_code` VALUES ('53', '南昌市', '360100');
INSERT INTO `t_city_code` VALUES ('55', '长沙市', '430100');
INSERT INTO `t_city_code` VALUES ('57', '贵阳市', '520100');
INSERT INTO `t_city_code` VALUES ('59', '昆明市', '530100');
INSERT INTO `t_city_code` VALUES ('61', '广州市', '440100');
INSERT INTO `t_city_code` VALUES ('63', '福州市', '350100');
INSERT INTO `t_city_code` VALUES ('65', '香港', '810000');
INSERT INTO `t_city_code` VALUES ('67', '澳门', '820000');

-- ----------------------------
-- Table structure for `t_forecast`
-- ----------------------------
DROP TABLE IF EXISTS `t_forecast`;
CREATE TABLE `t_forecast` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `city` varchar(50) DEFAULT NULL COMMENT '城市名称',
  `adcode` varchar(50) NOT NULL COMMENT '城市编码',
  `province` varchar(50) DEFAULT NULL COMMENT '省份名称',
  `report_time` datetime DEFAULT NULL COMMENT '预报发布时间',
  `valid_flag` varchar(1) NOT NULL COMMENT '有效性标识:Y有效;N无效',
  `created_by` varchar(30) NOT NULL COMMENT '创建人',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `updated_by` varchar(30) NOT NULL COMMENT '修改人',
  `updated_date` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='城市信息表';

-- ----------------------------
-- Records of t_forecast
-- ----------------------------
INSERT INTO `t_forecast` VALUES ('3', '东城区', '110101', '北京', '2019-12-24 09:57:06', 'Y', 'admin', '2019-12-24 09:58:03', 'admin', '2019-12-24 09:58:03');
INSERT INTO `t_forecast` VALUES ('5', '福州市', '350100', '福建', '2019-12-25 10:28:42', 'Y', 'admin', '2019-12-25 10:32:05', 'admin', '2019-12-25 10:32:05');

-- ----------------------------
-- Table structure for `t_forecast_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_forecast_detail`;
CREATE TABLE `t_forecast_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '注释',
  `forecast_id` int(11) NOT NULL COMMENT '外键',
  `date` date DEFAULT NULL COMMENT '日期',
  `week` varchar(50) NOT NULL COMMENT '星期几',
  `day_weather` varchar(50) DEFAULT NULL COMMENT '白天天气现象',
  `night_weather` varchar(50) DEFAULT NULL COMMENT '晚上天气现象',
  `day_temp` int(11) DEFAULT NULL COMMENT '白天温度',
  `night_temp` int(11) DEFAULT NULL COMMENT '晚上温度',
  `day_wind` varchar(50) DEFAULT NULL COMMENT '白天风向',
  `night_wind` varchar(50) DEFAULT NULL COMMENT '晚上风向',
  `day_power` varchar(50) DEFAULT NULL COMMENT '白天风力',
  `night_power` varchar(50) DEFAULT NULL COMMENT '晚上风力',
  `valid_flag` varchar(1) NOT NULL COMMENT '有效性标识:Y有效;N无效',
  `created_by` varchar(30) NOT NULL COMMENT '创建人',
  `created_date` datetime NOT NULL COMMENT '创建时间',
  `updated_by` varchar(30) NOT NULL COMMENT '修改人',
  `updated_date` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='预报天气信息表';

-- ----------------------------
-- Records of t_forecast_detail
-- ----------------------------
INSERT INTO `t_forecast_detail` VALUES ('1', '1', '2019-10-11', '1', '1', '1', '1', '1', '1', '1', '1', '1', 'Y', 'admin', '2019-12-24 10:48:57', 'admin', '2019-12-24 10:48:57');
INSERT INTO `t_forecast_detail` VALUES ('3', '3', '2019-12-24', '2', '小雪', '多云', '2', '-5', '南', '南', '≤3', '≤3', 'Y', 'admin', '2019-12-24 10:49:16', 'admin', '2019-12-24 10:49:16');
INSERT INTO `t_forecast_detail` VALUES ('5', '3', '2019-12-25', '3', '多云', '多云', '5', '-5', '东北', '东北', '≤3', '≤3', 'Y', 'admin', '2019-12-24 10:49:16', 'admin', '2019-12-24 10:49:16');
INSERT INTO `t_forecast_detail` VALUES ('7', '3', '2019-12-26', '4', '多云', '晴', '5', '-6', '西北', '西北', '≤3', '≤3', 'Y', 'admin', '2019-12-24 10:49:16', 'admin', '2019-12-24 10:49:16');
INSERT INTO `t_forecast_detail` VALUES ('9', '3', '2019-12-27', '5', '晴', '晴', '5', '-5', '西南', '西南', '≤3', '≤3', 'Y', 'admin', '2019-12-24 10:49:16', 'admin', '2019-12-24 10:49:16');
INSERT INTO `t_forecast_detail` VALUES ('11', '5', '2019-12-25', '3', '小雨', '晴', '22', '13', '无风向', '无风向', '≤3', '≤3', 'Y', 'admin', '2019-12-25 10:32:05', 'admin', '2019-12-25 10:32:05');
INSERT INTO `t_forecast_detail` VALUES ('13', '5', '2019-12-26', '4', '阴', '小雨', '22', '11', '无风向', '无风向', '≤3', '≤3', 'Y', 'admin', '2019-12-25 10:32:05', 'admin', '2019-12-25 10:32:05');
INSERT INTO `t_forecast_detail` VALUES ('15', '5', '2019-12-27', '5', '多云', '多云', '16', '9', '东', '东', '4', '4', 'Y', 'admin', '2019-12-25 10:32:05', 'admin', '2019-12-25 10:32:05');
INSERT INTO `t_forecast_detail` VALUES ('17', '5', '2019-12-28', '6', '多云', '阴', '19', '11', '东', '东', '4', '4', 'Y', 'admin', '2019-12-25 10:32:05', 'admin', '2019-12-25 10:32:05');
