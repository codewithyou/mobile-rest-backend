CREATE TABLE `xy_user` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id，类型mediumint级别千万级16777215三个字节',
  `groupId` smallint(6) unsigned NOT NULL DEFAULT '0' COMMENT '1-普通用户',
  `username` varchar(50) NOT NULL DEFAULT '0' COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `salt` char(10) NOT NULL COMMENT '加密值',
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) DEFAULT '' COMMENT '头像地址',
  `sex` tinyint(1) unsigned DEFAULT '0' COMMENT '性别',
  `email` varchar(60) DEFAULT '' COMMENT '邮箱，默认为空',
  `phone` varchar(15) DEFAULT '' COMMENT '手机号码',
  `regIp` varchar(20) DEFAULT NULL COMMENT '注册ip',
  `endIp` varchar(20) DEFAULT NULL COMMENT '最后登录ip',
  `createTime` int(20) NOT NULL COMMENT '创建时间',
  `loginTime` int(20) DEFAULT NULL COMMENT '最近一次登录时间',
  `updateTime` int(20) DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态（-1：删除，0：禁用，1：正常，2：未审核，3：过期（下线））',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='会员表';