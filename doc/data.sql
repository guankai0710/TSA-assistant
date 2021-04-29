
-- 初始化数据

INSERT INTO tsa_auth_role(name, memo, created_time, updated_time) VALUES ('系统管理员', '系统管理员', NOW(), NOW());
INSERT INTO tsa_auth_role(name, memo, created_time, updated_time) VALUES ('产品经理', '产品经理', NOW(), NOW());
INSERT INTO tsa_auth_role(name, memo, created_time, updated_time) VALUES ('客户', '客户', NOW(), NOW());

INSERT INTO tsa_auth_person(role_id, name, account, password, encryptsalt, sex, age, onlined, enabled, created_time, updated_time) VALUES (1, '管理员', 'admin', 'fx2eF0eq6bF76aebMd3H4dke0s80Pc2X9ap96We7Hd5H17R8', 'xFqFaMHksPXpWHHRBMwFgEgKqFCUfTDg', 1, 26, 0, 1, NOW(), NOW());

INSERT INTO tsa_sys_dictionary(type_code, type_name, dic_value, dic_name, dic_memo, created_by, created_time, updated_by, updated_time) VALUES ('sex', '性别', '1', '男', '男性', 'admin', NOW(), 'admin', NOW());
INSERT INTO tsa_sys_dictionary(type_code, type_name, dic_value, dic_name, dic_memo, created_by, created_time, updated_by, updated_time) VALUES ('sex', '性别', '0', '女', '女性', 'admin', NOW(), 'admin', NOW());
INSERT INTO tsa_sys_dictionary(type_code, type_name, dic_value, dic_name, dic_memo, created_by, created_time, updated_by, updated_time) VALUES ('star', '星级', '1', '一星', '一星', 'admin', NOW(), 'admin', NOW());
INSERT INTO tsa_sys_dictionary(type_code, type_name, dic_value, dic_name, dic_memo, created_by, created_time, updated_by, updated_time) VALUES ('star', '星级', '2', '二星', '二星', 'admin', NOW(), 'admin', NOW());
INSERT INTO tsa_sys_dictionary(type_code, type_name, dic_value, dic_name, dic_memo, created_by, created_time, updated_by, updated_time) VALUES ('star', '星级', '3', '三星', '三星', 'admin', NOW(), 'admin', NOW());
INSERT INTO tsa_sys_dictionary(type_code, type_name, dic_value, dic_name, dic_memo, created_by, created_time, updated_by, updated_time) VALUES ('star', '星级', '4', '四星', '四星', 'admin', NOW(), 'admin', NOW());
INSERT INTO tsa_sys_dictionary(type_code, type_name, dic_value, dic_name, dic_memo, created_by, created_time, updated_by, updated_time) VALUES ('star', '星级', '5', '五星', '五星', 'admin', NOW(), 'admin', NOW());



