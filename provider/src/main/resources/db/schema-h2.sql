DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    user_id BIGINT(20) AUTO_INCREMENT NOT NULL COMMENT '主键ID',
    user_name VARCHAR(128) NULL DEFAULT NULL COMMENT '姓名',
    password VARCHAR(64) NULL DEFAULT NULL COMMENT '密码',
    salt VARCHAR(64) NULL DEFAULT NULL COMMENT '盐',
    identity VARCHAR(1) NULL DEFAULT NULL COMMENT '身份 1：学生 2：法人组织  3：社会人士',
    account_status VARCHAR(1) NULL DEFAULT NULL COMMENT '账户状态 1：有效 2：注销  3：后台强制关闭',
    head_portrait_id BIGINT(64) NULL DEFAULT NULL COMMENT '头像id',
    phone_no VARCHAR(11) NULL DEFAULT NULL COMMENT '手机号',
    we_chat_id VARCHAR(64) NULL DEFAULT NULL COMMENT '微信id',
    create_time DATETIME NULL DEFAULT NULL COMMENT '创建时间',
    update_time DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS picture;
CREATE TABLE picture
(
    picture_id BIGINT(20) AUTO_INCREMENT NOT NULL COMMENT '主键ID',
    picture_url_address VARCHAR(128) NULL DEFAULT NULL COMMENT '姓名',
    create_time DATETIME NULL DEFAULT NULL COMMENT '创建时间',
    update_time DATETIME NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (picture_id)
);

DROP TABLE IF EXISTS volunteer_info;
CREATE TABLE volunteer_info
(
    volunteer_info_id BIGINT(20) AUTO_INCREMENT NOT NULL COMMENT '主键ID',
    title VARCHAR(64) NULL DEFAULT NULL COMMENT '标题',
    content VARCHAR(1024) NULL DEFAULT NULL COMMENT '内容',
    picture_id BIGINT(20) NULL DEFAULT NULL COMMENT '图片id',
    promulgator_id BIGINT(20) NULL DEFAULT NULL COMMENT '发布者id',
    number_of_need VARCHAR(8) NULL DEFAULT NULL COMMENT '义工所需人数',
    address VARCHAR(256) NULL DEFAULT NULL COMMENT '地址',
    time DATETIME NULL DEFAULT NULL COMMENT '时间',
    status VARCHAR(1) NULL DEFAULT NULL COMMENT '状态',
    award VARCHAR(64) NULL DEFAULT NULL COMMENT '奖励',
    create_time DATETIME NULL DEFAULT NULL COMMENT '创建时间',
    update_time DATETIME NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (volunteer_info_id)
);

DROP TABLE IF EXISTS volunteer_application;
CREATE TABLE volunteer_application
(
    volunteer_application_id BIGINT(20) AUTO_INCREMENT NOT NULL COMMENT '主键ID',
    volunteer_info_id BIGINT(20) NULL DEFAULT NULL COMMENT '义工信息ID',
    application_status VARCHAR(128) NULL DEFAULT NULL COMMENT '申请状态',
    claimer_id BIGINT(20) NULL DEFAULT NULL COMMENT '申请者id',
    create_time DATETIME NULL DEFAULT NULL COMMENT '创建时间',
    update_time DATETIME NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (volunteer_application_id)
);























