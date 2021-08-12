
-- ============权限================= --
-- 角色
CREATE TABLE tsa_auth_role(
    role_id INT(11) NOT NULL AUTO_INCREMENT  COMMENT '角色id' ,
    name VARCHAR(20)    COMMENT '角色名称' ,
    memo VARCHAR(200)    COMMENT '备注' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (role_id)
)  COMMENT = '角色信息'

-- 用户
CREATE TABLE tsa_auth_person(
    person_id INT(11) NOT NULL AUTO_INCREMENT  COMMENT '用户id' ,
    role_id INT(11) NOT NULL   COMMENT '角色id' ,
    name VARCHAR(20)    COMMENT '用户名称' ,
    account VARCHAR(20) NOT NULL   COMMENT '账号' ,
    password VARCHAR(128) NOT NULL   COMMENT '密码' ,
    encryptsalt VARCHAR(128) NOT NULL   COMMENT '加密盐' ,
    avatar VARCHAR(128)    COMMENT '头像' ,
    sex TINYINT(1)    COMMENT '性别(1:男；2:女)' ,
    age INT    COMMENT '年龄' ,
    pthone VARCHAR(20)    COMMENT '电话' ,
    email VARCHAR(30)    COMMENT '邮箱' ,
    addr VARCHAR(128)    COMMENT '地址' ,
    onlined TINYINT(1) NOT NULL   DEFAULT  0 COMMENT '是否在线(1:是；0:否)' ,
    enabled TINYINT(1) NOT NULL   DEFAULT  0 COMMENT '是否启用(1:是；0:否)' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (person_id)
)  COMMENT = '用户信息'



-- ============公共信息================= --
-- 系统参数
CREATE TABLE tsa_sys_parameter(
    sya_param_id INT(11) NOT NULL AUTO_INCREMENT  COMMENT '系统参数id' ,
    param_code VARCHAR(20)    COMMENT '系统参数编码' ,
    param_name VARCHAR(20)    COMMENT '系统参数名称' ,
    param_value VARCHAR(20)    COMMENT '系统参数值' ,
    memo VARCHAR(128)    COMMENT '系统参数备注' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (sya_param_id)
)  COMMENT = '系统参数'

-- 字典值
CREATE TABLE tsa_sys_dictionary(
    sys_dic_id INT(11) NOT NULL AUTO_INCREMENT  COMMENT '系统字典id' ,
    type_code VARCHAR(20)    COMMENT '字典类型编码' ,
    type_name VARCHAR(20)    COMMENT '字典类型名称' ,
    dic_value VARCHAR(20)    COMMENT '字典值' ,
    dic_name VARCHAR(20)    COMMENT '字典名称' ,
    dic_memo VARCHAR(128)    COMMENT '字典备注' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (sys_dic_id)
)  COMMENT = '系统字典'



-- ============web端================= --
-- 客户信息
CREATE TABLE tsa_customer(
    customer_id INT(11) NOT NULL AUTO_INCREMENT  COMMENT '客户id' ,
    customer_name VARCHAR(20)    COMMENT '客户名称' ,
    customer_account VARCHAR(20)    COMMENT '客户账号' ,
    customer_password VARCHAR(20)    COMMENT '客户密码' ,
    recharge_money DECIMAL(32,8)    COMMENT '充值资金' ,
    last_money DECIMAL(32,8)    COMMENT '剩余资金' ,
    tel VARCHAR(20)    COMMENT '电话' ,
    addr VARCHAR(128)    COMMENT '地址' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (customer_id)
)  COMMENT = '客户信息'

-- 交易记录
CREATE TABLE tsa_business_record(
    business_id INT(11) NOT NULL AUTO_INCREMENT  COMMENT '交易id' ,
    person_id INT(11)    COMMENT '用户id' ,
    customer_id INT(11)    COMMENT '客户id' ,
    stock_name VARCHAR(20)    COMMENT '股票名称' ,
    stock_code VARCHAR(20)    COMMENT '股票代码' ,
    buy_number INT    COMMENT '买入数量' ,
    buy_price DECIMAL(32,8)    COMMENT '成本价' ,
    buy_time DATETIME    COMMENT '买入时间' ,
    status TINYINT(1)    COMMENT '交易状态' ,
    sell_price DECIMAL(32,8)    COMMENT '卖出价' ,
    sell_time DATETIME    COMMENT '卖出时间' ,
    income_rate DECIMAL(32,8)    COMMENT '收益率' ,
    remark VARCHAR(128)    COMMENT '备注' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (business_id)
)  COMMENT = '交易记录'

