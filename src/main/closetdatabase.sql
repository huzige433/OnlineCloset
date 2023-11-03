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

 Date: 03/11/2023 11:09:59
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
  `season` int(11) NULL DEFAULT NULL COMMENT '夏0东1春秋2',
  `type` int(11) NOT NULL COMMENT '元属性type,0衣服1裤子2内衣3鞋子',
  `userid` int(11) NULL DEFAULT NULL COMMENT '归属',
  `isactive` int(11) NULL DEFAULT NULL COMMENT '-1丢弃',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 170 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clothing
-- ----------------------------
INSERT INTO `clothing` VALUES (80, '衣服', '\"总结：1.正肩款短袖肩宽42.5-45，胸围49-51（98-102）。优衣库170M\n2.宽松款短袖最大胸围54，肩宽53\n3.买优衣库衣服考虑170M或175L，裤子考虑165/72A\n4.感觉衣长68是极限（中长款羽绒服除外）\"\n', 'https://s2.loli.net/2023/10/18/hRu5mpyZdXE2i61.jpg', '[\"https://s2.loli.net/2023/10/18/hRu5mpyZdXE2i61.jpg\"]', '170/92A(M)', 65.14, '2023-11-01 11:05:07', 0, 0, 1, 1);
INSERT INTO `clothing` VALUES (81, '灰色短袖', '', 'https://s2.loli.net/2023/10/18/L73pHFTAIEN21bw.jpg', '[\"https://s2.loli.net/2023/10/18/L73pHFTAIEN21bw.jpg\"]', '170/92A（M）', 28.86, '2023-11-01 11:05:07', 0, 0, 1, 1);
INSERT INTO `clothing` VALUES (82, '防晒衫', '', 'https://s2.loli.net/2023/10/18/iY4NxP7BgGVOAuq.png', '[\"https://s2.loli.net/2023/10/18/iY4NxP7BgGVOAuq.png\"]', '170/92A（M', 106.00, '2023-11-01 11:05:08', 0, 0, 1, 1);
INSERT INTO `clothing` VALUES (83, '格子衬衫', '', 'https://s2.loli.net/2023/10/18/dQUlr24KFy8PSJo.jpg', '[\"https://s2.loli.net/2023/10/18/dQUlr24KFy8PSJo.jpg\"]', '170/92A（M）', 149.00, '2023-11-01 11:05:09', 0, 0, 1, 1);
INSERT INTO `clothing` VALUES (85, '裤子', '', 'https://s2.loli.net/2023/10/23/IYrmbFifS1svKWp.jpg', '[\"https://s2.loli.net/2023/10/23/IYrmbFifS1svKWp.jpg\"]', '165/72A', 79.99, '2023-11-01 00:00:00', 0, 1, 1, 1);
INSERT INTO `clothing` VALUES (89, '内衣', '', 'https://s2.loli.net/2023/10/24/RbQMtgN8J2H3c57.jpg', '[\"https://s2.loli.net/2023/10/24/RbQMtgN8J2H3c57.jpg\"]', 'L（170/95）', 86.83, '2023-11-01 00:00:00', 1, 2, 1, 1);
INSERT INTO `clothing` VALUES (90, '鞋子', '合适', 'https://s2.loli.net/2023/10/24/yS6L8sGfOeJbFcW.png', '[\"https://s2.loli.net/2023/10/24/yS6L8sGfOeJbFcW.png\"]', '41（比运动鞋大一码）', 159.49, '2023-11-01 11:05:11', 0, 3, 1, 1);
INSERT INTO `clothing` VALUES (131, '测试裤子', '', '/upload/55459234-3df0-41f0-aba8-365669b5b924.png', '[\"/upload/55459234-3df0-41f0-aba8-365669b5b924.png\"]', '', 0.00, '2023-11-01 06:09:03', 0, 1, 1, -1);
INSERT INTO `clothing` VALUES (132, '上线测试', '11', '/upload/55459234-3df0-41f0-aba8-365669b5b924.png', '[\"/upload/55459234-3df0-41f0-aba8-365669b5b924.png\"]', '11', 11.00, '2023-10-31 00:00:00', 2, 1, 1, -1);
INSERT INTO `clothing` VALUES (133, '小米', '小米', '/upload/1e5ed091-5463-4ef2-a876-139187eac2d4.jpeg', '[\"/upload/1e5ed091-5463-4ef2-a876-139187eac2d4.jpeg\"]', '', 0.00, '2023-10-31 00:00:00', 0, 0, 2, 1);
INSERT INTO `clothing` VALUES (134, '优衣库条纹', '', '/upload/c28f6c01-a2e3-434c-bfbb-bd4c100c77ac.jpeg', '[\"/upload/c28f6c01-a2e3-434c-bfbb-bd4c100c77ac.jpeg\"]', '165/84A（S）', 106.00, '2023-10-31 00:00:00', 2, 0, 1, 1);
INSERT INTO `clothing` VALUES (135, '黑色牛仔外衣', '', '/upload/7ae9a4d8-673e-4208-85e7-ef884eeafc7a.png', '[\"/upload/7ae9a4d8-673e-4208-85e7-ef884eeafc7a.png\"]', '170/92A（M）', 198.05, '2023-10-31 00:00:00', 2, 0, 1, 1);
INSERT INTO `clothing` VALUES (136, '白色仿优衣库', '买小了', '/upload/3c52ee39-5955-4b75-b2d9-5e4353842bc0.jpeg', '[\"/upload/3c52ee39-5955-4b75-b2d9-5e4353842bc0.jpeg\"]', '165/84A（S）', 90.95, '2023-10-31 00:00:00', 2, 0, 1, -1);
INSERT INTO `clothing` VALUES (137, '白色绒绒外衣', '买大了，胸围大，衣长长。\n', '/upload/678ba2f8-1d5c-4414-9e6b-b5cd462e386a.png', '[\"/upload/678ba2f8-1d5c-4414-9e6b-b5cd462e386a.png\"]', '180/108B（XL）', 43.04, '2023-10-31 00:00:00', 2, 0, 1, 1);
INSERT INTO `clothing` VALUES (138, '优衣库黑夹克', 'M号肩宽45，身宽57.5，穿着合身\n', '/upload/e609c0a9-c451-40eb-bd10-53d8e38c11a6.jpeg', '[\"/upload/e609c0a9-c451-40eb-bd10-53d8e38c11a6.jpeg\"]', '175/100A（L）', 244.00, '2023-10-31 00:00:00', 1, 0, 1, 1);
INSERT INTO `clothing` VALUES (139, '沐云短袖', '质量不太好', '/upload/4be4f613-f25b-45fb-8a4c-0661db6d9267.png', '[\"/upload/4be4f613-f25b-45fb-8a4c-0661db6d9267.png\"]', 'L', 21.42, '2023-10-31 00:00:00', 0, 0, 1, 1);
INSERT INTO `clothing` VALUES (140, '沐云短袖白色', '质量不太好\n', '/upload/c8227c6f-6d1f-4401-8dcc-32271403970d.png', '[\"/upload/c8227c6f-6d1f-4401-8dcc-32271403970d.png\"]', 'L', 21.80, '2023-10-31 00:00:00', 0, 0, 1, 1);
INSERT INTO `clothing` VALUES (141, '短袖', '宽松，略长', '/upload/c062b235-3b54-4470-b7e7-6937fc66da69.png', '[\"/upload/c062b235-3b54-4470-b7e7-6937fc66da69.png\"]', 'L', 34.17, '2023-10-31 00:00:00', 0, 0, 1, 1);
INSERT INTO `clothing` VALUES (142, '短袖', '本来穿着效果很好，洗后有点缩水修身，小了。', '/upload/ad0a1101-ecc4-4f4c-a674-33c61ad73395.png', '[\"/upload/ad0a1101-ecc4-4f4c-a674-33c61ad73395.png\"]', 'M', 37.44, '2023-10-31 00:00:00', 0, 0, 1, 1);
INSERT INTO `clothing` VALUES (143, '短袖', '效果很好，oversize，但我觉得有点热', '/upload/4f688bad-f1bd-407b-88a5-73e41d0d16e5.png', '[\"/upload/4f688bad-f1bd-407b-88a5-73e41d0d16e5.png\"]', 'L', 17.19, '2023-10-31 00:00:00', 0, 0, 1, 1);
INSERT INTO `clothing` VALUES (144, '熊本熊卫衣', '', '/upload/e5dcde58-0673-464c-935a-c37a3dc86224.jpeg', '[\"/upload/e5dcde58-0673-464c-935a-c37a3dc86224.jpeg\"]', 'XL', 84.99, '2023-10-31 00:00:00', 2, 0, 1, 1);
INSERT INTO `clothing` VALUES (145, '灰色卫衣', '', '/upload/b09633da-9e3a-40ee-a135-e02788111f87.jpeg', '[\"/upload/b09633da-9e3a-40ee-a135-e02788111f87.jpeg\"]', 's', 70.67, '2023-10-31 00:00:00', 2, 0, 1, 1);
INSERT INTO `clothing` VALUES (146, '卫衣', '', '/upload/cd3a8b31-751a-4abd-8bd8-0c6d254f39f3.jpeg', '[\"/upload/cd3a8b31-751a-4abd-8bd8-0c6d254f39f3.jpeg\"]', 's', 70.67, '2023-10-31 00:00:00', 2, 0, 1, 1);
INSERT INTO `clothing` VALUES (147, '毛衣', '胸围有点大，衣长略长。S估计也能穿。', '/upload/a2fc7bcd-86d6-4968-8523-2b0922ed094b.png', '[\"/upload/a2fc7bcd-86d6-4968-8523-2b0922ed094b.png\"]', 'm', 103.60, '2023-10-31 00:00:00', 1, 0, 1, 1);
INSERT INTO `clothing` VALUES (148, '毛衣', '', '/upload/e92ae2f0-a34f-4476-90b4-6759aa3cbb2d.png', '[\"/upload/e92ae2f0-a34f-4476-90b4-6759aa3cbb2d.png\"]', 'm', 0.00, '2023-10-31 00:00:00', 1, 0, 1, 1);
INSERT INTO `clothing` VALUES (149, '羽绒服', '', '/upload/88372f12-1c41-4d69-b7b0-b8f544d25d59.jpeg', '[\"/upload/88372f12-1c41-4d69-b7b0-b8f544d25d59.jpeg\"]', '95', 435.89, '2023-10-31 00:00:00', 1, 0, 1, 1);
INSERT INTO `clothing` VALUES (150, '长裤', '', '/upload/8ec28250-cefb-45ef-81ba-ff58e3f7a503.jpeg', '[\"/upload/8ec28250-cefb-45ef-81ba-ff58e3f7a503.jpeg\"]', '165/72A', 122.86, '2023-11-01 00:00:00', 2, 1, 1, 1);
INSERT INTO `clothing` VALUES (151, '长裤', '', '/upload/f036d6cb-d287-436b-92b1-c79a9cb5d358.jpeg', '[\"/upload/f036d6cb-d287-436b-92b1-c79a9cb5d358.jpeg\"]', 'M', 99.00, '2023-11-01 00:00:00', 0, 1, 1, 1);
INSERT INTO `clothing` VALUES (152, '长裤', '', '/upload/09d69710-45be-403c-8af5-703ebf392344.png', '[\"/upload/09d69710-45be-403c-8af5-703ebf392344.png\"]', 'L（165/70A）', 39.52, '2023-11-01 00:00:00', 0, 1, 1, 1);
INSERT INTO `clothing` VALUES (153, '长裤', '', '/upload/ab533ffd-53f6-4bf4-9d09-37020d1cc17f.png', '[\"/upload/ab533ffd-53f6-4bf4-9d09-37020d1cc17f.png\"]', '', 15.58, '2023-11-01 00:00:00', 0, 1, 1, 1);
INSERT INTO `clothing` VALUES (154, '长裤', '腰围合适，不用系皮带', '/upload/64b2e0db-b070-4c81-9fda-f42840914d5e.png', '[\"/upload/64b2e0db-b070-4c81-9fda-f42840914d5e.png\"]', '29', 51.60, '2023-11-01 00:00:00', 0, 1, 1, 1);
INSERT INTO `clothing` VALUES (155, '牛仔短裤', '', '/upload/9912d006-26ac-4d8c-badf-a99ea93bf536.png', '[\"/upload/9912d006-26ac-4d8c-badf-a99ea93bf536.png\"]', 'L', 35.00, '2023-11-01 00:00:00', 0, 1, 1, 1);
INSERT INTO `clothing` VALUES (156, '加绒牛仔裤', '', '/upload/d3006dc4-13d4-49bd-9131-b1f7c43bc1f2.png', '[\"/upload/d3006dc4-13d4-49bd-9131-b1f7c43bc1f2.png\"]', '30', 65.74, NULL, 1, 1, 1, 1);
INSERT INTO `clothing` VALUES (157, '牛仔裤', '', '/upload/83017638-102a-4226-b1fb-ee65c8f16e79.png', '[\"/upload/83017638-102a-4226-b1fb-ee65c8f16e79.png\"]', '30', 55.93, '2023-11-01 00:00:00', 0, 1, 1, 1);
INSERT INTO `clothing` VALUES (158, '工装裤', '合适', '/upload/20d1a51b-99e4-46f1-ad49-5a19b9c14451.png', '[\"/upload/20d1a51b-99e4-46f1-ad49-5a19b9c14451.png\"]', 'M（170/76A）', 44.91, '2023-11-01 00:00:00', 2, 1, 1, 1);
INSERT INTO `clothing` VALUES (159, '短袖', '', '/upload/a05d0923-7aa6-4bb6-b7db-08d8c6b955ad.jpeg', '[\"/upload/a05d0923-7aa6-4bb6-b7db-08d8c6b955ad.jpeg\"]', 'M', 0.00, '2023-11-01 00:00:00', 0, 0, 1, -1);
INSERT INTO `clothing` VALUES (160, '短袖', '', '/upload/6908c85d-e970-4c98-958b-5aa4913d160a.jpeg', '[\"/upload/6908c85d-e970-4c98-958b-5aa4913d160a.jpeg\"]', 'M', 0.00, '2023-11-01 00:00:00', 0, 0, 1, -1);
INSERT INTO `clothing` VALUES (161, '秋裤', '适合115到135斤', '/upload/25052f2c-ecff-42fe-9653-02a3070d3b4c.png', '[\"/upload/25052f2c-ecff-42fe-9653-02a3070d3b4c.png\"]', 'XL', 23.90, '2023-11-01 00:00:00', 1, 2, 1, 1);
INSERT INTO `clothing` VALUES (162, '内衣', '120到140斤', '/upload/ba1f3083-09d6-43e0-b311-5055fec2dbd2.png', '[\"/upload/ba1f3083-09d6-43e0-b311-5055fec2dbd2.png\"]', 'L/170', 73.00, '2023-11-01 00:00:00', 1, 2, 1, 1);
INSERT INTO `clothing` VALUES (163, '内衣', '', '/upload/846f507b-5032-4a7e-837d-b2beaed06a4b.png', '[\"/upload/846f507b-5032-4a7e-837d-b2beaed06a4b.png\"]', 'L/170', 44.10, '2023-11-01 00:00:00', 2, 2, 1, 1);
INSERT INTO `clothing` VALUES (164, '斯凯奇', '（鞋型偏大）', '/upload/13257d3f-5727-4832-806a-dacd5edf6697.png', '[\"/upload/13257d3f-5727-4832-806a-dacd5edf6697.png\"]', '41', 0.00, NULL, NULL, 3, 1, 1);
INSERT INTO `clothing` VALUES (165, '鸿星尔克', '合适', '/upload/026213ad-30a6-47db-b8cf-ef476fc64a4d.png', '[\"/upload/026213ad-30a6-47db-b8cf-ef476fc64a4d.png\"]', '41', 0.00, NULL, 2, 3, 1, 1);
INSERT INTO `clothing` VALUES (166, '飞跃', '底硬，两边挤脚', '/upload/60b7b7eb-d43d-4df3-a545-e2591ccd4997.png', '[\"/upload/60b7b7eb-d43d-4df3-a545-e2591ccd4997.png\"]', '42', 50.62, '2023-11-01 00:00:00', 0, 3, 1, 1);
INSERT INTO `clothing` VALUES (167, '回力', '', '/upload/a4a8cb13-0538-4f26-91c2-6e65851d610a.png', '[\"/upload/a4a8cb13-0538-4f26-91c2-6e65851d610a.png\"]', '41', 47.70, '2023-11-01 00:00:00', 0, 3, 1, 1);
INSERT INTO `clothing` VALUES (168, '特步', '', '/upload/0fc11b24-7e7f-4ee8-99a4-e254214d326c.png', '[\"/upload/0fc11b24-7e7f-4ee8-99a4-e254214d326c.png\"]', '42', 145.41, '2023-11-01 00:00:00', 1, 3, 1, 1);
INSERT INTO `clothing` VALUES (169, '优衣库防风摇粒绒长绒外套', '', '/upload/b30f5e92-f4a7-42b2-80f8-d168e2715b9d.png', '[\"/upload/b30f5e92-f4a7-42b2-80f8-d168e2715b9d.png\"]', '175/100A（L）', 106.00, NULL, 1, 0, 1, 1);

-- ----------------------------
-- Table structure for clothing_sort
-- ----------------------------
DROP TABLE IF EXISTS `clothing_sort`;
CREATE TABLE `clothing_sort`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sortArry` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clothing_sort
-- ----------------------------
INSERT INTO `clothing_sort` VALUES (1, '0', '[139,82,80,83,134,135,81,137,138,140,141,142,169,143,144,145,146,147,148,149]', 1);
INSERT INTO `clothing_sort` VALUES (6, '1', '[150,151,158,152,153,85,154,155,156,157]', 1);
INSERT INTO `clothing_sort` VALUES (14, '2', '[161,162,89,163]', 1);
INSERT INTO `clothing_sort` VALUES (15, '3', '[168,164,165,166,90,167]', 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 86 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coat
-- ----------------------------
INSERT INTO `coat` VALUES (36, 80, '67', '42.5', '49.5(99)', '21');
INSERT INTO `coat` VALUES (37, 81, '69', '44', '51（102）', '19.5');
INSERT INTO `coat` VALUES (38, 82, '69', '', '54（108）', '83.5(连肩)');
INSERT INTO `coat` VALUES (39, 83, '74（后肩）', '46.5', '56', '83（连肩）');
INSERT INTO `coat` VALUES (66, 133, '', '', '', '');
INSERT INTO `coat` VALUES (67, 134, '72', '52', '59', '81.5（连肩）');
INSERT INTO `coat` VALUES (68, 135, '62（后肩）', '51.5', '61.5', '83.5（连肩）');
INSERT INTO `coat` VALUES (69, 136, '70', '47', '54', '82');
INSERT INTO `coat` VALUES (70, 137, '72.5', '', '63', '87(连肩）');
INSERT INTO `coat` VALUES (71, 138, '67', '46.5', '60.5', '66');
INSERT INTO `coat` VALUES (72, 139, '68', '45', '51（102）', '20');
INSERT INTO `coat` VALUES (73, 140, '68', '45', '51（102）', '20');
INSERT INTO `coat` VALUES (74, 141, '71', '51', '53（106）', '24');
INSERT INTO `coat` VALUES (75, 142, '70', '53', '54（108）', '22.5');
INSERT INTO `coat` VALUES (76, 143, '70', '54', '54（108）', '19');
INSERT INTO `coat` VALUES (77, 144, '73', '52', '58', '62');
INSERT INTO `coat` VALUES (78, 145, '69', '58.5', '59', '56');
INSERT INTO `coat` VALUES (79, 146, '69', '58.5', '59', '56');
INSERT INTO `coat` VALUES (80, 147, '68', '51', '56', '59');
INSERT INTO `coat` VALUES (81, 148, '65', '落肩', '58', '50');
INSERT INTO `coat` VALUES (82, 149, '77.5', '49.3', '60.5', '64');
INSERT INTO `coat` VALUES (83, 159, '67', '43.5', '49(98)', '21');
INSERT INTO `coat` VALUES (84, 160, '67', '43.5', '49', '21');
INSERT INTO `coat` VALUES (85, 169, '74', '48', '59', '86');

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
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pants
-- ----------------------------
INSERT INTO `pants` VALUES (1, 85, '68-76', '97', '92', '', '32', '73', '');
INSERT INTO `pants` VALUES (7, 131, '', '', '', '', '', '', '');
INSERT INTO `pants` VALUES (8, 132, '11', '11', '11', '11', '11', '11', '11');
INSERT INTO `pants` VALUES (9, 150, '77', '96', '', '31', '24', '85', '');
INSERT INTO `pants` VALUES (10, 151, '70-76', '108', '90', '33.4', '29.2', '', '15.5（1/2）');
INSERT INTO `pants` VALUES (11, 152, '76', '110', '95', '', '', '', '');
INSERT INTO `pants` VALUES (12, 153, '', '', '', '', '', '', '');
INSERT INTO `pants` VALUES (13, 154, '74', '99', '101', '', '27.5', '', '18.2');
INSERT INTO `pants` VALUES (14, 155, '71', '114', '59', '', '', '', '');
INSERT INTO `pants` VALUES (15, 156, '', '', '', '', '', '', '');
INSERT INTO `pants` VALUES (16, 157, '', '', '', '', '', '', '');
INSERT INTO `pants` VALUES (17, 158, '77-87', '108', '102', '', '', '', '38');

-- ----------------------------
-- Table structure for shoe
-- ----------------------------
DROP TABLE IF EXISTS `shoe`;
CREATE TABLE `shoe`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clothing_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shoe
-- ----------------------------
INSERT INTO `shoe` VALUES (1, 90);
INSERT INTO `shoe` VALUES (3, 164);
INSERT INTO `shoe` VALUES (4, 165);
INSERT INTO `shoe` VALUES (5, 166);
INSERT INTO `shoe` VALUES (6, 167);
INSERT INTO `shoe` VALUES (7, 168);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '标签名',
  `clothingtype` int(11) NULL DEFAULT NULL COMMENT '所属衣服类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 114 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1, '衬衫', 0);
INSERT INTO `tag` VALUES (2, '长裤', 1);
INSERT INTO `tag` VALUES (4, '短袖', 0);
INSERT INTO `tag` VALUES (107, '内衣', 2);
INSERT INTO `tag` VALUES (109, '长袖', 0);
INSERT INTO `tag` VALUES (114, '运动鞋', 3);

-- ----------------------------
-- Table structure for tag_clothing
-- ----------------------------
DROP TABLE IF EXISTS `tag_clothing`;
CREATE TABLE `tag_clothing`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clothingid` int(11) NOT NULL COMMENT '衣服id',
  `tagid` int(11) NULL DEFAULT NULL COMMENT '标签id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag_clothing
-- ----------------------------
INSERT INTO `tag_clothing` VALUES (2, 85, 2);
INSERT INTO `tag_clothing` VALUES (3, 80, 4);
INSERT INTO `tag_clothing` VALUES (44, 83, 1);
INSERT INTO `tag_clothing` VALUES (46, 120, 104);
INSERT INTO `tag_clothing` VALUES (50, 89, 107);
INSERT INTO `tag_clothing` VALUES (51, 90, 108);
INSERT INTO `tag_clothing` VALUES (52, 82, 109);
INSERT INTO `tag_clothing` VALUES (53, 90, 111);
INSERT INTO `tag_clothing` VALUES (57, 139, 4);
INSERT INTO `tag_clothing` VALUES (58, 143, 4);
INSERT INTO `tag_clothing` VALUES (59, 81, 4);
INSERT INTO `tag_clothing` VALUES (60, 142, 4);
INSERT INTO `tag_clothing` VALUES (61, 165, 114);
INSERT INTO `tag_clothing` VALUES (62, 164, 114);
INSERT INTO `tag_clothing` VALUES (63, 168, 114);

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of underwear
-- ----------------------------
INSERT INTO `underwear` VALUES (1, 89, '63', '39', '46', '55', '66', '96', '22', '94');
INSERT INTO `underwear` VALUES (3, 161, '', '', '', '', '71-92', '87-112', '', '100');
INSERT INTO `underwear` VALUES (4, 162, '67', '41', '44', '57', '', '', '', '95');
INSERT INTO `underwear` VALUES (5, 163, '68', '43', '47.5', '55', '64-96', '93', '', '100');

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
