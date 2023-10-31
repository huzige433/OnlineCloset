/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : closetdatabase

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 31/10/2023 15:32:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for clothing
-- ----------------------------
DROP TABLE IF EXISTS `clothing`;
CREATE TABLE `clothing`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '名字',
  `descript` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '其他描述',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '图片链接',
  `src_list` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '更多图片',
  `size` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '尺寸',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `buytime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '购买时间',
  `season` int(1) NULL DEFAULT NULL COMMENT '夏0东1春秋2',
  `type` int(1) NOT NULL COMMENT '元属性type,0衣服1裤子2内衣3鞋子-1丢弃',
  `userid` int(11) NULL DEFAULT NULL COMMENT '归属',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 122 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clothing
-- ----------------------------
INSERT INTO `clothing` VALUES (80, '衣服', '\"总结：1.正肩款短袖肩宽42.5-45，胸围49-51（98-102）。优衣库170M\n2.宽松款短袖最大胸围54，肩宽53\n3.买优衣库衣服考虑170M或175L，裤子考虑165/72A\n4.感觉衣长68是极限（中长款羽绒服除外）\"\n', 'https://s2.loli.net/2023/10/18/hRu5mpyZdXE2i61.jpg', '[\"https://s2.loli.net/2023/10/18/hRu5mpyZdXE2i61.jpg\"]', '170/92A(M)', 65.14, '2023-10-26 14:32:58', 0, 0, 1);
INSERT INTO `clothing` VALUES (81, '灰色短袖', '', 'https://s2.loli.net/2023/10/18/L73pHFTAIEN21bw.jpg', '[\"https://s2.loli.net/2023/10/18/L73pHFTAIEN21bw.jpg\"]', '170/92A（M）', 28.86, '2023-10-26 13:44:07', 0, 0, 1);
INSERT INTO `clothing` VALUES (82, '防晒衫', '', 'https://s2.loli.net/2023/10/18/iY4NxP7BgGVOAuq.png', '[\"https://s2.loli.net/2023/10/18/iY4NxP7BgGVOAuq.png\"]', '170/92A（M', 106.00, '2023-10-26 13:44:08', 0, 0, 1);
INSERT INTO `clothing` VALUES (83, '格子衬衫', '', 'https://s2.loli.net/2023/10/18/dQUlr24KFy8PSJo.jpg', '[\"https://s2.loli.net/2023/10/18/dQUlr24KFy8PSJo.jpg\"]', '170/92A（M）', 149.00, '2023-10-26 13:44:09', 0, 0, 1);
INSERT INTO `clothing` VALUES (85, '裤子', '', 'https://s2.loli.net/2023/10/23/IYrmbFifS1svKWp.jpg', '[\"https://s2.loli.net/2023/10/23/IYrmbFifS1svKWp.jpg\"]', '165/72A', 79.99, '2023-10-26 13:44:09', 0, 1, 1);
INSERT INTO `clothing` VALUES (89, '内衣1', '', 'https://s2.loli.net/2023/10/24/RbQMtgN8J2H3c57.jpg', '[\"https://s2.loli.net/2023/10/24/RbQMtgN8J2H3c57.jpg\"]', 'L（170/95）', 86.83, '2023-10-26 00:00:00', 1, 2, 1);
INSERT INTO `clothing` VALUES (90, '鞋子', '合适', 'https://s2.loli.net/2023/10/24/yS6L8sGfOeJbFcW.png', '[\"https://s2.loli.net/2023/10/24/yS6L8sGfOeJbFcW.png\"]', '41（比运动鞋大一码）', 159.49, '2023-10-26 13:44:10', 0, 3, 1);

-- ----------------------------
-- Table structure for coat
-- ----------------------------
DROP TABLE IF EXISTS `coat`;
CREATE TABLE `coat`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clothing_id` int(11) NOT NULL,
  `clothing_length` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '衣长',
  `shoulder_width` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '肩宽',
  `body_width` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '身宽',
  `sleeve_length` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '袖长',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coat
-- ----------------------------
INSERT INTO `coat` VALUES (36, 80, '67', '42.5', '49.5(99)', '21');
INSERT INTO `coat` VALUES (37, 81, '69', '44', '51（102）', '19.5');
INSERT INTO `coat` VALUES (38, 82, '69', '', '54（108）', '83.5（连肩）');
INSERT INTO `coat` VALUES (39, 83, '74（后肩）', '46.5', '56', '83（连肩）');

-- ----------------------------
-- Table structure for pants
-- ----------------------------
DROP TABLE IF EXISTS `pants`;
CREATE TABLE `pants`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clothing_id` int(11) NOT NULL,
  `waits_width` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '腰围',
  `hips` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '臀围',
  `pants_length` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '裤长',
  `half_thign_width` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '底裆宽(1/2大腿围)',
  `crotchup` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '上裆',
  `inseam_length` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '裤内裆长',
  `pants_opening_width` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '裤口宽',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pants
-- ----------------------------
INSERT INTO `pants` VALUES (1, 85, '1', '97', '92', '', '32', '73', '');

-- ----------------------------
-- Table structure for shoe
-- ----------------------------
DROP TABLE IF EXISTS `shoe`;
CREATE TABLE `shoe`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clothing_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shoe
-- ----------------------------
INSERT INTO `shoe` VALUES (1, 90);
INSERT INTO `shoe` VALUES (2, 101);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '标签名',
  `clothingtype` int(255) NULL DEFAULT NULL COMMENT '所属衣服类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 109 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1, '衬衫', 0);
INSERT INTO `tag` VALUES (2, '长裤', 1);
INSERT INTO `tag` VALUES (4, '短袖', 0);
INSERT INTO `tag` VALUES (107, '内衣', 2);
INSERT INTO `tag` VALUES (108, '长筒靴', 3);
INSERT INTO `tag` VALUES (109, '长袖', 0);

-- ----------------------------
-- Table structure for tag_clothing
-- ----------------------------
DROP TABLE IF EXISTS `tag_clothing`;
CREATE TABLE `tag_clothing`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clothingid` int(11) NOT NULL COMMENT '衣服id',
  `tagid` int(11) NULL DEFAULT NULL COMMENT '标签id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag_clothing
-- ----------------------------
INSERT INTO `tag_clothing` VALUES (2, 85, 2);
INSERT INTO `tag_clothing` VALUES (3, 80, 4);
INSERT INTO `tag_clothing` VALUES (4, 81, 1);
INSERT INTO `tag_clothing` VALUES (44, 83, 1);
INSERT INTO `tag_clothing` VALUES (46, 120, 104);
INSERT INTO `tag_clothing` VALUES (50, 89, 107);
INSERT INTO `tag_clothing` VALUES (51, 90, 108);
INSERT INTO `tag_clothing` VALUES (52, 82, 109);

-- ----------------------------
-- Table structure for underwear
-- ----------------------------
DROP TABLE IF EXISTS `underwear`;
CREATE TABLE `underwear`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clothing_id` int(11) NOT NULL,
  `clothing_length` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '衣长',
  `shoulder_width` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '肩宽',
  `body_width` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '身宽',
  `sleeve_length` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '袖长',
  `waits_width` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '腰围',
  `hips` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '臀围',
  `pants_opening_width` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '裤口宽',
  `pants_length` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '裤长',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of underwear
-- ----------------------------
INSERT INTO `underwear` VALUES (1, 89, '63', '39', '46', '55', '66', '96', '22', '94');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '嘎', 'ga', '123456');
INSERT INTO `user` VALUES (2, '宝', 'bao', '123456');

SET FOREIGN_KEY_CHECKS = 1;
