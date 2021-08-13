
-- 初始化数据

INSERT INTO tsa_auth_role(name, memo, created_time, updated_time) VALUES ('系统管理员', '系统管理员', NOW(), NOW());
INSERT INTO tsa_auth_role(name, memo, created_time, updated_time) VALUES ('产品经理', '产品经理', NOW(), NOW());
INSERT INTO tsa_auth_role(name, memo, created_time, updated_time) VALUES ('客户', '客户', NOW(), NOW());

INSERT INTO tsa_auth_person(role_id, name, account, password, encryptsalt, sex, age, onlined, enabled, created_time, updated_time) VALUES (1, '管理员', 'admin', 'fx2eF0eq6bF76aebMd3H4dke0s80Pc2X9ap96We7Hd5H17R8', 'xFqFaMHksPXpWHHRBMwFgEgKqFCUfTDg', 1, 26, 0, 1, NOW(), NOW());

INSERT INTO tsa_sys_dictionary(type_code, type_name, dic_value, dic_name, dic_memo, created_time, updated_time) VALUES ('sex', '性别', '1', '男', '男性', NOW(), NOW());
INSERT INTO tsa_sys_dictionary(type_code, type_name, dic_value, dic_name, dic_memo, created_time, updated_time) VALUES ('sex', '性别', '0', '女', '女性', NOW(), NOW());




