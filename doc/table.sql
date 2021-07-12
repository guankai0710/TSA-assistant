
-- ============权限================= --
-- 角色
CREATE TABLE `tsa_auth_role` (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `memo` varchar(128) DEFAULT NULL COMMENT '备注',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除(1:是；0:否)',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色信息';

-- 用户
CREATE TABLE `tsa_auth_person` (
  `person_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `role_id` int NOT NULL COMMENT '角色id',
  `name` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `account` varchar(32) NOT NULL COMMENT '账号',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `encryptsalt` varchar(128) NOT NULL COMMENT '加密盐',
  `avatar` varchar(128) DEFAULT NULL COMMENT '头像',
  `sex` tinyint DEFAULT NULL COMMENT '性别(1:男；2:女)',
  `age` int DEFAULT NULL COMMENT '年龄',
  `pthone` varchar(32) DEFAULT NULL COMMENT '电话',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `addr` varchar(128) DEFAULT NULL COMMENT '地址',
  `onlined` tinyint NOT NULL DEFAULT '0' COMMENT '是否在线(1:是；0:否)',
  `enabled` tinyint NOT NULL DEFAULT '0' COMMENT '是否启用(1:是；0:否)',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除(1:是；0:否)',
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息 ';



-- ============公共信息================= --
-- 系统参数
CREATE TABLE `tsa_sys_parameter` (
  `sya_param_id` int NOT NULL AUTO_INCREMENT COMMENT '系统参数id',
  `param_code` varchar(32) DEFAULT NULL COMMENT '系统参数编码',
  `param_name` varchar(32) DEFAULT NULL COMMENT '系统参数名称',
  `param_value` varchar(32) DEFAULT NULL COMMENT '系统参数值',
  `memo` varchar(128) DEFAULT NULL COMMENT '系统参数备注',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` NOT NULL tinyint DEFAULT '0' COMMENT '是否删除(1:是；0:否)',
  PRIMARY KEY (`sya_param_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数 ';

-- 字典值
CREATE TABLE `tsa_sys_dictionary` (
  `sys_dic_id` int NOT NULL AUTO_INCREMENT COMMENT '系统字典id',
  `type_code` varchar(32) DEFAULT NULL COMMENT '字典类型编码',
  `type_name` varchar(32) DEFAULT NULL COMMENT '字典类型名称',
  `dic_value` varchar(32) DEFAULT NULL COMMENT '字典值',
  `dic_name` varchar(32) DEFAULT NULL COMMENT '字典名称',
  `dic_memo` varchar(128) DEFAULT NULL COMMENT '字典备注',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` NOT NULL tinyint DEFAULT '0' COMMENT '是否删除(1:是；0:否)',
  PRIMARY KEY (`sys_dic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典 ';



-- ============web端================= --
-- 客户信息
CREATE TABLE `tsa_customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT COMMENT '客户id',
  `customer_name` varchar(32) DEFAULT NULL COMMENT '客户名称',
  `customer_account` varchar(32) DEFAULT NULL COMMENT '客户账号',
  `customer_password` varchar(128) DEFAULT NULL COMMENT '客户密码',
  `recharge_money` decimal(32,8) DEFAULT NULL COMMENT '充值资金',
  `last_money` decimal(32,8) DEFAULT NULL COMMENT '剩余资金',
  `tel` varchar(32) DEFAULT NULL COMMENT '电话',
  `addr` varchar(128) DEFAULT NULL COMMENT '地址',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除(1:是；0:否)',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户信息 ';

-- 交易记录
CREATE TABLE `tsa_business_record` (
  `business_id` int NOT NULL AUTO_INCREMENT COMMENT '交易id',
  `person_id` int DEFAULT NULL COMMENT '用户id',
  `customer_id` int DEFAULT NULL COMMENT '客户id',
  `stock_name` varchar(32) DEFAULT NULL COMMENT '股票名称',
  `stock_code` varchar(32) DEFAULT NULL COMMENT '股票代码',
  `buy_number` int DEFAULT NULL COMMENT '买入数量',
  `buy_price` decimal(32,8) DEFAULT NULL COMMENT '成本价',
  `buy_time` datetime DEFAULT NULL COMMENT '买入时间',
  `status` tinyint DEFAULT NULL COMMENT '交易状态',
  `sell_price` decimal(32,8) DEFAULT NULL COMMENT '卖出价',
  `sell_time` datetime DEFAULT NULL COMMENT '卖出时间',
  `income_rate` decimal(32,10) DEFAULT NULL COMMENT '收益率',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除(1:是；0:否)',
  PRIMARY KEY (`business_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易记录 ';

