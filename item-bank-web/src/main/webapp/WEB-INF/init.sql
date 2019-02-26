/*初始化用户数据*/
insert into `user`(username,password,email,phoneNum,status)
values('xiaom','123456','xiaom@qq.com','020-8888888',1);

/*初始化角色数据*/
insert into role(role_name,role_desc) values('ROLE_USER','普通用户角色');
insert into role(role_name,role_desc) values('ROLE_ADMIN','管理员角色');

/*初始化用户角色数据*/
insert into user_role(userId,roleId) values(1,2);

/*初始化权限数据*/
insert into permission(permission_name,url) values('添加商品','/product/add');
insert into permission(permission_name,url) values('保存商品','/product/save');
insert into permission(permission_name,url) values('删除商品','/product/del');
insert into permission(permission_name,url) values('修改保存商品','/product/update');
insert into permission(permission_name,url) values('编辑商品','/product/edit');
insert into permission(permission_name,url) values('查询商品','/product/list');
insert into permission(permission_name,url) values('查询商品详情','/product/show');

/*初始化角色权限数据*/
insert into role_permission(roleId,permissionId) values(2,1);
insert into role_permission(roleId,permissionId) values(2,2);
insert into role_permission(roleId,permissionId) values(2,3);
insert into role_permission(roleId,permissionId) values(2,4);
insert into role_permission(roleId,permissionId) values(2,5);
insert into role_permission(roleId,permissionId) values(2,6);
insert into role_permission(roleId,permissionId) values(2,7);
