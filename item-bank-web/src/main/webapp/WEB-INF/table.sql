/*题目表*/
CREATE TABLE `question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `category_id` bigint(20) NOT NULL COMMENT '类型',
  `content` text CHARACTER SET utf8mb4 NOT NULL COMMENT '内容',
  `stage` int(11) NOT NULL DEFAULT '0' COMMENT '阶段',
  `last_review_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上次复习时间',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1是，0不是',
  PRIMARY KEY (`id`),
  KEY `目录id` (`category_id`),
  CONSTRAINT `目录id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*目录*/
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `parent_id` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1是，0不是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*创建用户表*/
DROP TABLE if EXISTS `user`;
CREATE TABLE `user`(
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL ,
  password VARCHAR(50) NOT NULL ,
  email VARCHAR(50) NOT NULL ,
  phone_num VARCHAR(20) NOT NULL COMMENT '联系电话',
  status INT NOT NULL DEFAULT 0 COMMENT '0:禁用，1：正常'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*创建角色表*/
DROP TABLE if EXISTS `role`;
CREATE TABLE role(
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  role_name VARCHAR(50) NOT NULL ,
  role_desc VARCHAR(50) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*创建用户角色表*/
DROP TABLE if EXISTS `user_role`;
CREATE TABLE user_role(
  user_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL,
  PRIMARY KEY(user_id,role_id),
  FOREIGN KEY (user_id) REFERENCES `user`(id),
  FOREIGN KEY (role_id) REFERENCES role(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*创建权限表*/
DROP TABLE if EXISTS `permission`;
CREATE TABLE permission(
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  permission_name VARCHAR(50) NOT NULL COMMENT '权限名称',
  url VARCHAR(50) NOT NULL COMMENT '资源路径'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*角色权限表*/
DROP TABLE if EXISTS `role_permission`;
CREATE TABLE role_permission(
  role_id BIGINT NOT NULL,
  permission_id BIGINT NOT NULL,
  PRIMARY KEY(permission_id,role_id),
  FOREIGN KEY (permission_id) REFERENCES permission(id),
  FOREIGN KEY (role_id) REFERENCES role(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
