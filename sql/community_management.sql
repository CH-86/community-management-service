/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.104
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : 192.168.1.104:3306
 Source Schema         : community_management

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 29/03/2021 20:44:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for com_man_activity
-- ----------------------------
DROP TABLE IF EXISTS `com_man_activity`;
CREATE TABLE `com_man_activity`  (
  `activity_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '活动编号',
  `activity_community_id` int(0) NOT NULL COMMENT '所属社团编号',
  `activity_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动名称',
  `activity_type` tinyint(0) NOT NULL COMMENT '0：其他 1：招新',
  `activity_start_time` timestamp(0) NOT NULL COMMENT '开始时间',
  `activity_end_time` timestamp(0) NOT NULL COMMENT '结束时间',
  `activity_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动海报',
  `activity_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '举办地址',
  `activity_sponser` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主办方',
  `activity_description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动简介',
  `activity_status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '0：审核中 1：通过审核 2：未通过审核 3：结束',
  PRIMARY KEY (`activity_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of com_man_activity
-- ----------------------------
INSERT INTO `com_man_activity` VALUES (1, 7, '零基础学习街舞', 0, '2021-01-01 17:26:35', '2021-03-18 17:26:40', 'static/images/wudongqingchun.jpg', '飞碟体育馆', '街舞社 ', '舞动青春，释放魅力', 0);
INSERT INTO `com_man_activity` VALUES (3, 6, '古装表演', 0, '2021-10-22 17:33:14', '2021-03-28 17:33:21', 'static/images/hanfu01.jpg', '贝壳广场', ' 汉服社', '锦绣中华，认识汉服的魅力', 0);
INSERT INTO `com_man_activity` VALUES (4, 3, '书法交流大会', 0, '2020-06-27 17:35:40', '2021-07-18 17:35:52', 'static/images/shufa01.jpg', ' 汇3-342', '书法协会', '中国文化博大精深，我们一起交流', 1);
INSERT INTO `com_man_activity` VALUES (5, 9, '春季篮球比赛', 0, '2021-03-10 17:37:49', '2021-03-27 17:37:52', 'static/images/dongman01.jpg', '东区篮球场', '篮球社', '大家积极参加，友谊第一，比赛第二', 1);
INSERT INTO `com_man_activity` VALUES (6, 10, '五子棋比赛', 0, '2021-02-10 17:39:08', '2021-02-12 17:39:14', 'static/images/hanfu01.jpg', '汇1-324', ' 棋艺社', '欢迎大家来切磋，等你哦', 0);
INSERT INTO `com_man_activity` VALUES (7, 11, '美照比赛', 0, '2021-02-21 17:40:23', '2021-03-22 17:40:30', 'static/images/hanfu01.jpg', '槐花走廊', '摄影社', '欢迎大家积极参赛，评选“最美”摄影师', 2);
INSERT INTO `com_man_activity` VALUES (8, 9, '2021年“迎新杯”篮球赛', 0, '2021-03-22 15:33:21', '2021-03-22 15:34:28', 'static/images/lanqiubisai.jpg', '2号运动场', '篮球社 体育学院团总支学生会', '　　为了丰富 12 级同学们的课余生活，让新生能够早日融入大学氛围，同时推动体育活动开展，带动体育活动的风气，增强班级凝聚力，也给同学们展示自我的舞台，为美好的大学生生活留下灿烂的一笔财富。我软件学院定于在 9 月份展开 “迎新杯” 篮球赛，旨在增强各班凝聚力，展示出新时代大学生的蓬勃朝气和竞技热情。狂奔于篮球场上，进行着进攻与防守的拼搏、输与赢的较量，让我们感触到篮球运动的精彩所在，当汗水飞舞的时候，心绪也跟着篮球在翻滚。篮球，告诉我们要用激情和吃苦耐劳谱写大学新篇章。\n　　同学们，我们的大学，你们该如何诠释它的意义所在?\n　　篮球赛将告诉我们如何寻找合作的源头活水，篮球赛将让我们结识新的兄弟姐妹。大学乃至我们的一生都离不开友谊，请用心守护她或他，请不要忘记我们的同窗好友。迎接挑战，永不言败，这样的同学才值得敬仰，这样的大学生活才叫精彩; 积极对抗，全力配合这样的比赛才值得关注，这样的比赛才叫真的有味，篮球的价值，就是去努力拼搏打造一场精彩的球赛。\n　　我们有理由相信，软件学院 “迎新杯” 篮球赛将会举办的非常成功', 0);
INSERT INTO `com_man_activity` VALUES (9, 12, '羽毛球社招新', 1, '2021-03-24 13:36:15', '2021-03-24 14:34:21', 'static/images/yumaoqiushezhaoxin.jpg', '知行楼432', '羽毛球协会', '　  羽毛球社团招新啦！\n      快点行动起来吧！\n     “羽”你相约在这快乐时光。\n      健康“羽”美丽从羽毛球开始。', 1);
INSERT INTO `com_man_activity` VALUES (10, 3, '书法协会招新啦', 1, '2021-03-24 13:46:30', '2021-03-24 13:44:39', 'static/images/shufaxiehuizhaoxin.jpg', '博雅楼阶梯教室404', '书法协会', '你想要的大学生活是什么样子呢？\n轻松散漫？还是充实有趣？\n你一定想要找到志同道合的朋友吧？\n想要练就一手好字吧？\n加入我们\n十佳协会之一的工商书法协会吧！', 1);

-- ----------------------------
-- Table structure for com_man_clazz
-- ----------------------------
DROP TABLE IF EXISTS `com_man_clazz`;
CREATE TABLE `com_man_clazz`  (
  `clazz_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '班级编号',
  `clazz_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级名称',
  `college_id` int(0) NOT NULL COMMENT '所属学院',
  PRIMARY KEY (`clazz_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of com_man_clazz
-- ----------------------------
INSERT INTO `com_man_clazz` VALUES (1, '2016级学前教育8班', 1);
INSERT INTO `com_man_clazz` VALUES (2, '2017级社会体育指导与管理3班', 1);
INSERT INTO `com_man_clazz` VALUES (3, '2016级汉语言文学班', 2);
INSERT INTO `com_man_clazz` VALUES (4, '2016级物联网工程班', 3);
INSERT INTO `com_man_clazz` VALUES (6, '团委管理', 4);
INSERT INTO `com_man_clazz` VALUES (7, '2019级计算机网络2班', 3);

-- ----------------------------
-- Table structure for com_man_college
-- ----------------------------
DROP TABLE IF EXISTS `com_man_college`;
CREATE TABLE `com_man_college`  (
  `college_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '学院编号',
  `college_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学院名称',
  PRIMARY KEY (`college_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of com_man_college
-- ----------------------------
INSERT INTO `com_man_college` VALUES (1, '教育学院');
INSERT INTO `com_man_college` VALUES (2, '文学院');
INSERT INTO `com_man_college` VALUES (3, '软件学院');
INSERT INTO `com_man_college` VALUES (4, '团委');
INSERT INTO `com_man_college` VALUES (5, '大数据学院');
INSERT INTO `com_man_college` VALUES (6, '生物技术与工程学院');

-- ----------------------------
-- Table structure for com_man_community
-- ----------------------------
DROP TABLE IF EXISTS `com_man_community`;
CREATE TABLE `com_man_community`  (
  `community_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '社团编号',
  `community_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '社团名称',
  `community_discription` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '社团简介',
  `community_logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '社团logo图片路径',
  `community_status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '0 : 未审核 1：审核通过 2：未通过审核',
  PRIMARY KEY (`community_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of com_man_community
-- ----------------------------
INSERT INTO `com_man_community` VALUES (0, '无', '无', 'static/images/jisuanjishetuan.jpg', 1);
INSERT INTO `com_man_community` VALUES (1, '计算机学术交流协会', '计算机学术交流协会成立于2021年1月1日。', 'static/images/jisuanjishetuan.jpg', 1);
INSERT INTO `com_man_community` VALUES (2, '动漫社', '动漫社成立于2020年1月1日。', 'static/images/jisuanjishetuan.jpg', 2);
INSERT INTO `com_man_community` VALUES (3, '书法协会', '书法协会是以学生为主体的社团，一切为了同学们的利益，书法协会为同学们提供了展示自我的机会，并在比赛中互相学习、互相帮助，形成了良好的学习氛围。书法协会的宗旨就是为爱好书法的同学们提供一个学习和展示自我、提高自我和相互交流的一个平台，让同学们用简单的纸、笔和墨水渲染出一幅幅古色古香的书卷，从中体会到传统的书法中的古典韵味，陶冶情操', 'static/images/shufalogo.jpg', 1);
INSERT INTO `com_man_community` VALUES (4, '团委管理', '团委管理成立于2021年1月3日。', 'static/images/jisuanjishetuan.jpg', 1);
INSERT INTO `com_man_community` VALUES (7, '街舞社', '街舞社成立于2021年1月3日。', 'static/images/jisuanjishetuan.jpg', 1);
INSERT INTO `com_man_community` VALUES (8, '汉服社', '汉服社成立于2020年1月2日', 'static/images/jisuanjishetuan.jpg', 1);
INSERT INTO `com_man_community` VALUES (9, '篮球社', '篮球社成立于2021年1月1日。', 'static/images/jisuanjishetuan.jpg', 1);
INSERT INTO `com_man_community` VALUES (10, '棋艺社', '通过开展棋类活动，丰富同学们业余文化生活，提高同学们稳重、镇静、细心、恒心、不骄不躁的优秀品质，促进学生的全面发展。棋艺社团，是一个包含象棋、围棋、军旗、五子棋、跳棋等棋类的综合协会。秉承着丰富健康向上的校园文化生活，营造良好的育人环境，进一步活跃学校的课余生活，在一定程度上提高人的逻辑思维能力、发展和发扬我校的棋文化。', 'static/images/qiyishelogo.jpg', 1);
INSERT INTO `com_man_community` VALUES (11, '摄影社', '摄影社成立于2021年1月3日。', 'static/images/jisuanjishetuan.jpg', 1);
INSERT INTO `com_man_community` VALUES (12, '羽毛球社', '  羽毛球社团是京师实验学校众多社团之一，主要在社团活动时间给学生们提供一个锻炼身体和培养羽毛球兴趣爱好的平台。羽毛球社团在第一次招生就有57名学生报名，羽毛球活动倍受同学们的喜爱。\n    羽毛球社团的活动宗旨是“只要有一颗想飞的羽毛球心，我们就能引领你在球场上飞翔”。社团活动时间让学生进行羽毛球比赛也使同学在羽毛球比赛知识，和体育运动方面得到锻炼。\n   羽毛球社团让大家放松、锻炼的目标，在学习压力很大的情况下使大家放松、快乐。同时，我们严格遵守学校的相关规定，按时将社团的相关信息上报学校。我们对社团内部认真管理，器材合理使用。', 'static/images/yumaologo.jpg', 1);

-- ----------------------------
-- Table structure for com_man_message
-- ----------------------------
DROP TABLE IF EXISTS `com_man_message`;
CREATE TABLE `com_man_message`  (
  `message_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '消息ID',
  `message_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '消息内容',
  `message_send` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息发送人ID',
  `message_recv` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息接收人ID',
  `message_status` tinyint(0) NULL DEFAULT 0 COMMENT '消息状态 0：未读状态 1：已读状态',
  `message_time` timestamp(0) NULL DEFAULT NULL COMMENT '消息的时间',
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of com_man_message
-- ----------------------------
INSERT INTO `com_man_message` VALUES (1, '临近傍晚，轻轻按下方向盘左侧功能区带有蓝色背景光的按键，打开蔚来ES6所带有的NOP领航辅助功能，行驶在上海中环高架之中，车内音响传来的则是一直最爱的周杰伦《一路向北》。', '160858424', '1804352458', 0, '2021-03-27 20:22:08');
INSERT INTO `com_man_message` VALUES (2, '就在 2019 年底，碰瓷事件再次发生，这次发生在高速公路上。但和很多碰瓷事件不一样的是，碰瓷人员这次选择了特斯拉 Model 3，所有的碰瓷行为被车身侧面摄像头拍了个一清二楚。使我们能够更清楚的了解碰瓷事件的经过，再结合车主的叙述和相关新闻报道，对我们提高防范意识和处理高速公路碰瓷事件有了很大帮助。', '1904254875984', '1804352458', 1, '2021-03-27 21:50:02');
INSERT INTO `com_man_message` VALUES (3, 'test', '1804352458', '1904254875984', 0, NULL);
INSERT INTO `com_man_message` VALUES (4, 'test', '1804352458', '1605410123', 0, '2021-03-27 16:24:41');

-- ----------------------------
-- Table structure for com_man_news
-- ----------------------------
DROP TABLE IF EXISTS `com_man_news`;
CREATE TABLE `com_man_news`  (
  `news_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '新闻编号',
  `news_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新闻标题',
  `news_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新闻图片',
  `news_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新闻内容',
  `news_type` tinyint(0) NOT NULL COMMENT '0：新闻 1：公告',
  `news_create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `news_community_id` int(0) NOT NULL COMMENT '所属社团',
  `news_status` tinyint(0) NOT NULL COMMENT '0：审核中 1：通过 2：未通过',
  PRIMARY KEY (`news_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of com_man_news
-- ----------------------------
INSERT INTO `com_man_news` VALUES (1, '书法协会-书法比赛', 'static/images/shufabisai.jpg', '体现“中华复兴”、“美丽中国 我的中国梦”的内容，主要体现社会进步及中华复兴。借助图书资料、历史文献、网络搜索等工具，了解 “中国梦” 的历史渊源和现实意义，通过制作书法作品、手抄小报、摄影、绘画等图文并茂的展现 “美丽中国” 的伟大构想。讴歌祖国、讴歌中华民族、讴歌校园师生，集中展现全校师生热爱祖国、朝气蓬勃、昂扬向上的精神风貌。', 0, '2021-03-18 01:37:18', 3, 0);
INSERT INTO `com_man_news` VALUES (2, '动漫社-COS舞台剧', 'static/images/wutaiju.jpg', '共同分享动漫带来的喜悦；激发大学生的想象力和创造力；服务同学，丰富大学生文化生活；为中国的原创动漫打下坚实的基础，为中国的动漫事业做出自己的贡献。', 0, '2021-03-22 01:44:32', 2, 1);
INSERT INTO `com_man_news` VALUES (3, '计算机学术交流协会-Java多线程应用场景', 'static/images/duoxiancheng.jpg', 'Java5以前实现多线程有两种实现方法：一种是继承Thread类；另一种是实现Runnable接口。两种方式都要通过重写run()方法来定义线程的行为，推荐使用后者', 0, '2021-02-01 01:47:26', 1, 2);
INSERT INTO `com_man_news` VALUES (4, '棋艺社招新', 'static/images/qiyishezhaoxin.jpg', '棋艺社，无你不棋，缺你不可,快来加入我们吧！！！', 0, '2021-03-20 13:59:55', 10, 1);
INSERT INTO `com_man_news` VALUES (5, '摄影社招新', 'static/images/sheyingshezhaoxin.jpg', '给热爱摄影、认真生活的人提供了一个平台，我们社对成员的器材认识程度没有要求，到我们社可以教会你相机的使用方法，热衷于用手机记录的都十分欢迎；不论是对风光摄影、人像摄影还是其他领域感兴趣，在摄影社，你一定会找到你热爱的生活。\r\n\r\n你在犹豫什么呢？快来加入我们吧！', 0, '2021-03-20 14:05:15', 11, 1);
INSERT INTO `com_man_news` VALUES (6, '篮球社招新', 'static/images/lanqiushezhaoxin.jpg', '你是否还保持着当年的执着，是否还充斥着当年的热血，是否还记得当年的初衷，来到篮球大家庭让你找回曾经巅峰的自己！', 0, '2021-03-20 14:07:30', 9, 1);
INSERT INTO `com_man_news` VALUES (7, '王校长参与计算机学术交流会', 'static/images/news03.jpg', '首先,XXX校长代表学校党政为新学期典礼致辞，她在讲话中高度赞扬了XX中学全体师生上一学期中表现出的甘于奉献、勇于拼搏的精神，并强调XX中学新的一年要夯实基础、求实发展。接着她用精妙的譬喻诠释了文化立校与科研兴校内涵意义。她说中国文化尤如参天大树，民族传统文化则是它的根。“溯”与“寻”的过程则是科研实践的过程，她希望全体XX教师继续发扬敬业、奉献精神，积极参与、认真投入，明确理解“科研兴校，文化立校”的学校办学思路，寻求教学新突破口，为学生、为自己、为学校的稳定发展贡献自己的力量。之后年级组长代表与学生代表讲话充满了对学期的憧憬。', 0, '2021-03-20 07:43:47', 1, 0);
INSERT INTO `com_man_news` VALUES (8, '团代会召开', 'static/images/gg01.jpg', '请各社团安排人员。准时出席团代会。', 1, '2021-03-20 16:19:06', 4, 1);
INSERT INTO `com_man_news` VALUES (9, 'XXX团委关于召开2020节新生迎新晚会的通知', 'static/images/gg03.jpg', '东流逝水，落叶纷纷，荏苒的时光就这样悄悄地、慢慢地消逝了，我们又迎来了一批莘莘学子。在这个充满着真情、充满着友爱、充满着对一切美好事物的追求的大家庭里，他们将度过人生中一段新意盎然、多姿多彩的美好生活。开始大学生活意味着开启人生的新篇章，借此机会，南通大学杏林学院心理协会举办这次迎新晚会，向新生们表达我们的热烈欢迎，为新老生们提供一个交流合作的舞台，挥洒青春的活力。', 1, '2021-03-20 08:41:02', 4, 2);

-- ----------------------------
-- Table structure for com_man_re_user_activity
-- ----------------------------
DROP TABLE IF EXISTS `com_man_re_user_activity`;
CREATE TABLE `com_man_re_user_activity`  (
  `activity_id` int(0) NOT NULL COMMENT '活动编号',
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户编号',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '0: 正常完成报名，审核中 1：通过审核 2：未通过审核 3:用户参加完活动',
  PRIMARY KEY (`activity_id`, `user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of com_man_re_user_activity
-- ----------------------------
INSERT INTO `com_man_re_user_activity` VALUES (1, '131431431', 0);
INSERT INTO `com_man_re_user_activity` VALUES (1, '1605410123', 3);
INSERT INTO `com_man_re_user_activity` VALUES (2, '1704352958', 1);
INSERT INTO `com_man_re_user_activity` VALUES (3, '1902452542', 2);
INSERT INTO `com_man_re_user_activity` VALUES (4, '1904254875984', 3);
INSERT INTO `com_man_re_user_activity` VALUES (5, '1904254875984', 1);
INSERT INTO `com_man_re_user_activity` VALUES (6, '160858424', 3);
INSERT INTO `com_man_re_user_activity` VALUES (7, '1605410123', 3);
INSERT INTO `com_man_re_user_activity` VALUES (7, '160858424', 0);
INSERT INTO `com_man_re_user_activity` VALUES (8, '1605410123', 3);
INSERT INTO `com_man_re_user_activity` VALUES (9, '1904254875984', 3);
INSERT INTO `com_man_re_user_activity` VALUES (10, '1904254875984', 3);

-- ----------------------------
-- Table structure for com_man_re_user_community
-- ----------------------------
DROP TABLE IF EXISTS `com_man_re_user_community`;
CREATE TABLE `com_man_re_user_community`  (
  `community_id` int(0) NOT NULL COMMENT '所属社团编号',
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户编号',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '状态 0: 用户报名未通过审核状态 1：正常社团成员',
  PRIMARY KEY (`community_id`, `user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of com_man_re_user_community
-- ----------------------------
INSERT INTO `com_man_re_user_community` VALUES (1, '1431536546', 0);
INSERT INTO `com_man_re_user_community` VALUES (1, '1704352958', 1);
INSERT INTO `com_man_re_user_community` VALUES (1, '1804352458', 1);
INSERT INTO `com_man_re_user_community` VALUES (1, '1904254875984', 1);
INSERT INTO `com_man_re_user_community` VALUES (1, '1906532164', 1);
INSERT INTO `com_man_re_user_community` VALUES (3, '1605410123', 0);
INSERT INTO `com_man_re_user_community` VALUES (12, '1605410123', 0);

-- ----------------------------
-- Table structure for com_man_user
-- ----------------------------
DROP TABLE IF EXISTS `com_man_user`;
CREATE TABLE `com_man_user`  (
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工号或者学号',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `user_password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `user_clazz_id` int(0) NULL DEFAULT NULL COMMENT '所属班级',
  `user_department` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '学生' COMMENT '所属部门',
  `user_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'static/images/admin.jpg' COMMENT '用户头像路径',
  `user_qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'qq',
  `user_telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '；联系号码',
  `user_gender` tinyint(0) NOT NULL DEFAULT 0 COMMENT '0：男 1：女',
  `user_type` tinyint(0) NOT NULL DEFAULT 0 COMMENT '0：普通用户 1：社团管理员 2：系统管理员',
  `user_community_id` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of com_man_user
-- ----------------------------
INSERT INTO `com_man_user` VALUES ('1111111111', '丁玉', '123456', 3, '学生', 'static/images/admin.jpg', '33143153', '18788595994', 0, 0, 0);
INSERT INTO `com_man_user` VALUES ('131431431', '陈国华', '123456', 1, '学生', 'static/images/admin.jpg', '43254254235', '13759458693', 0, 1, 2);
INSERT INTO `com_man_user` VALUES ('1431536546', '李闵', '123456', 2, '学生', 'static/images/admin.jpg', '33143153', '18788595994', 1, 0, 0);
INSERT INTO `com_man_user` VALUES ('1605410123', '李白', '123456', 1, '学生', 'static/images/admin.jpg', '4646454465', '18315465924', 1, 1, 12);
INSERT INTO `com_man_user` VALUES ('160858424', '李敏', '123456', 1, '学生', 'static/images/admin.jpg', '143143124', '18748257425', 1, 1, 9);
INSERT INTO `com_man_user` VALUES ('1704352958', '陈兴健', '123456', 3, '学生', 'static/images/admin.jpg', '4525326543', '18484752544', 0, 0, 0);
INSERT INTO `com_man_user` VALUES ('1803412434', '叶平', '123456', 2, '学生', 'static/images/admin.jpg', '321431433', '18314588574', 0, 1, 11);
INSERT INTO `com_man_user` VALUES ('1804352455', '王丽', '123456', 4, '学生', 'static/images/admin.jpg', '4525326543', '18484752544', 1, 1, 7);
INSERT INTO `com_man_user` VALUES ('1804352458', '陈永晴', '123456', 2, '学生', 'static/images/admin.jpg', '4525326543', '18484752544', 1, 0, 0);
INSERT INTO `com_man_user` VALUES ('1804352958', '赏林荣', '123456', 3, '学生', 'static/images/wechat-tx.jpg', '4525326543', '18484752544', 1, 1, 1);
INSERT INTO `com_man_user` VALUES ('1902452542', '刘晓  ', '123456', 1, '学生', 'static/images/admin.jpg', '325425425', '13899358984', 0, 0, 0);
INSERT INTO `com_man_user` VALUES ('190425487595', '欧阳雪', '123456', 3, '学生', 'static/images/admin.jpg', '43254254', '18788594846', 1, 1, 8);
INSERT INTO `com_man_user` VALUES ('1904254875984', '王明月', '123456', 3, '学生', 'static/images/admin.jpg', '43254254', '18788594844', 1, 0, 0);
INSERT INTO `com_man_user` VALUES ('1906532164', '李志基', '123456', 7, '学生', 'static/images/admin.jpg', '45646464', '13888632654', 0, 0, 0);
INSERT INTO `com_man_user` VALUES ('1906532165', '张玉洁', '123456', 2, '学生', 'static/images/admin.jpg', '45264514111', '13888632656', 1, 0, 0);
INSERT INTO `com_man_user` VALUES ('1906532170', '王鑫', '123456', 3, '学生', 'static/images/admin.jpg', '45264514111', '13888632656', 0, 0, 0);
INSERT INTO `com_man_user` VALUES ('1906532172', '李雨涵', '123456', 4, '学生', 'static/images/admin.jpg', '45264514111', '13888632656', 1, 0, 0);
INSERT INTO `com_man_user` VALUES ('254253525', '李金洋', '123456', 4, '学生', 'static/images/admin.jpg', '4325425425', '18798989884', 1, 1, 10);
INSERT INTO `com_man_user` VALUES ('421433143', '陈云', '123456', 2, '学生', 'static/images/admin.jpg', '43254254235', '13759458693', 0, 1, 3);
INSERT INTO `com_man_user` VALUES ('88888888', 'admin', '123456', 6, '管理员', 'static/images/wechat-tx.jpg', '1981723769', '1831456807', 0, 2, 4);

SET FOREIGN_KEY_CHECKS = 1;
