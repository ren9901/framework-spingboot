-- ----------------------------
-- 1、部门表
-- ----------------------------
drop table if exists sys_dept;
create table sys_dept
(
    dept_id     bigint(20) not null auto_increment comment '部门id',
    parent_id   bigint(20) default 0 comment '父部门id',
    ancestors   varchar(50) default '' comment '祖级列表',
    dept_name   varchar(30) default '' comment '部门名称',
    order_num   int(4) default 0 comment '显示顺序',
    leader      varchar(20) default null comment '负责人',
    phone       varchar(11) default null comment '联系电话',
    email       varchar(50) default null comment '邮箱',
    status      char(1)     default '0' comment '部门状态（0正常 1停用）',
    del_flag    char(1)     default '0' comment '删除标志（0代表存在 2代表删除）',
    create_by   varchar(64) default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64) default '' comment '更新者',
    update_time datetime comment '更新时间',
    primary key (dept_id)
) engine=innodb auto_increment=200 comment = '部门表';

-- ----------------------------
-- 2、用户信息表
-- ----------------------------
drop table if exists sys_user;
create table sys_user
(
    user_id     bigint(20) not null auto_increment comment '用户ID',
    dept_id     bigint(20) default null comment '部门ID',
    user_name   varchar(30) not null comment '用户账号',
    nick_name   varchar(30) not null comment '用户昵称',
    user_type   varchar(2)   default '00' comment '用户类型（00系统用户）',
    email       varchar(50)  default '' comment '用户邮箱',
    phonenumber varchar(11)  default '' comment '手机号码',
    sex         char(1)      default '0' comment '用户性别（0男 1女 2未知）',
    avatar      varchar(100) default '' comment '头像地址',
    password    varchar(100) default '' comment '密码',
    status      char(1)      default '0' comment '帐号状态（0正常 1停用）',
    del_flag    char(1)      default '0' comment '删除标志（0代表存在 2代表删除）',
    login_ip    varchar(128) default '' comment '最后登录IP',
    login_date  datetime comment '最后登录时间',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default null comment '备注',
    primary key (user_id)
) engine=innodb auto_increment=100 comment = '用户信息表';

-- ----------------------------
-- 3、岗位信息表
-- ----------------------------
drop table if exists sys_post;
create table sys_post
(
    post_id     bigint(20) not null auto_increment comment '岗位ID',
    post_code   varchar(64) not null comment '岗位编码',
    post_name   varchar(50) not null comment '岗位名称',
    post_sort   int(4) not null comment '显示顺序',
    status      char(1)     not null comment '状态（0正常 1停用）',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default null comment '备注',
    primary key (post_id)
) engine=innodb comment = '岗位信息表';

-- ----------------------------
-- 4、角色信息表
-- ----------------------------
drop table if exists sys_role;
create table sys_role
(
    role_id             bigint(20) not null auto_increment comment '角色ID',
    role_name           varchar(30)  not null comment '角色名称',
    role_key            varchar(100) not null comment '角色权限字符串',
    role_sort           int(4) not null comment '显示顺序',
    data_scope          char(1)      default '1' comment '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
    menu_check_strictly tinyint(1) default 1 comment '菜单树选择项是否关联显示',
    dept_check_strictly tinyint(1) default 1 comment '部门树选择项是否关联显示',
    status              char(1)      not null comment '角色状态（0正常 1停用）',
    del_flag            char(1)      default '0' comment '删除标志（0代表存在 2代表删除）',
    create_by           varchar(64)  default '' comment '创建者',
    create_time         datetime comment '创建时间',
    update_by           varchar(64)  default '' comment '更新者',
    update_time         datetime comment '更新时间',
    remark              varchar(500) default null comment '备注',
    primary key (role_id)
) engine=innodb auto_increment=100 comment = '角色信息表';

-- ----------------------------
-- 5、菜单权限表
-- ----------------------------
drop table if exists sys_menu;
create table sys_menu
(
    menu_id     bigint(20) not null auto_increment comment '菜单ID',
    menu_name   varchar(50) not null comment '菜单名称',
    parent_id   bigint(20) default 0 comment '父菜单ID',
    order_num   int(4) default 0 comment '显示顺序',
    path        varchar(200) default '' comment '路由地址',
    component   varchar(255) default null comment '组件路径',
    query       varchar(255) default null comment '路由参数',
    is_frame    int(1) default 1 comment '是否为外链（0是 1否）',
    is_cache    int(1) default 0 comment '是否缓存（0缓存 1不缓存）',
    menu_type   char(1)      default '' comment '菜单类型（M目录 C菜单 F按钮）',
    visible     char(1)      default 0 comment '菜单状态（0显示 1隐藏）',
    status      char(1)      default 0 comment '菜单状态（0正常 1停用）',
    perms       varchar(100) default null comment '权限标识',
    icon        varchar(100) default '#' comment '菜单图标',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default '' comment '备注',
    primary key (menu_id)
) engine=innodb auto_increment=2000 comment = '菜单权限表';

-- ----------------------------
-- 6、用户和角色关联表  用户N-1角色
-- ----------------------------
drop table if exists sys_user_role;
create table sys_user_role
(
    user_id bigint(20) not null comment '用户ID',
    role_id bigint(20) not null comment '角色ID',
    primary key (user_id, role_id)
) engine=innodb comment = '用户和角色关联表';

-- ----------------------------
-- 7、角色和菜单关联表  角色1-N菜单
-- ----------------------------
drop table if exists sys_role_menu;
create table sys_role_menu
(
    role_id bigint(20) not null comment '角色ID',
    menu_id bigint(20) not null comment '菜单ID',
    primary key (role_id, menu_id)
) engine=innodb comment = '角色和菜单关联表';

-- ----------------------------
-- 8、角色和部门关联表  角色1-N部门
-- ----------------------------
drop table if exists sys_role_dept;
create table sys_role_dept
(
    role_id bigint(20) not null comment '角色ID',
    dept_id bigint(20) not null comment '部门ID',
    primary key (role_id, dept_id)
) engine=innodb comment = '角色和部门关联表';

-- ----------------------------
-- 9、用户与岗位关联表  用户1-N岗位
-- ----------------------------
drop table if exists sys_user_post;
create table sys_user_post
(
    user_id bigint(20) not null comment '用户ID',
    post_id bigint(20) not null comment '岗位ID',
    primary key (user_id, post_id)
) engine=innodb comment = '用户与岗位关联表';

-- ----------------------------
-- 10、操作日志记录
-- ----------------------------
drop table if exists sys_oper_log;
create table sys_oper_log
(
    oper_id        bigint(20) not null auto_increment comment '日志主键',
    title          varchar(50)   default '' comment '模块标题',
    business_type  int(2) default 0 comment '业务类型（0其它 1新增 2修改 3删除）',
    method         varchar(100)  default '' comment '方法名称',
    request_method varchar(10)   default '' comment '请求方式',
    operator_type  int(1) default 0 comment '操作类别（0其它 1后台用户 2手机端用户）',
    oper_name      varchar(50)   default '' comment '操作人员',
    dept_name      varchar(50)   default '' comment '部门名称',
    oper_url       varchar(255)  default '' comment '请求URL',
    oper_ip        varchar(128)  default '' comment '主机地址',
    oper_location  varchar(255)  default '' comment '操作地点',
    oper_param     varchar(2000) default '' comment '请求参数',
    json_result    varchar(2000) default '' comment '返回参数',
    status         int(1) default 0 comment '操作状态（0正常 1异常）',
    error_msg      varchar(2000) default '' comment '错误消息',
    oper_time      datetime comment '操作时间',
    cost_time      bigint(20) default 0 comment '消耗时间',
    primary key (oper_id),
    key            idx_sys_oper_log_bt (business_type),
    key            idx_sys_oper_log_s (status),
    key            idx_sys_oper_log_ot (oper_time)
) engine=innodb auto_increment=100 comment = '操作日志记录';

-- ----------------------------
-- 11、字典类型表
-- ----------------------------
drop table if exists sys_dict_type;
create table sys_dict_type
(
    dict_id          bigint(20)      not null auto_increment    comment '字典主键',
    dict_name        varchar(100)    default ''                 comment '字典名称',
    dict_type        varchar(100)    default ''                 comment '字典类型',
    status           char(1)         default '0'                comment '状态（0正常 1停用）',
    create_by        varchar(64)     default ''                 comment '创建者',
    create_time      datetime                                   comment '创建时间',
    update_by        varchar(64)     default ''                 comment '更新者',
    update_time      datetime                                   comment '更新时间',
    remark           varchar(500)    default null               comment '备注',
    primary key (dict_id),
    unique (dict_type)
) engine=innodb auto_increment=100 comment = '字典类型表';

-- ----------------------------
-- 12、字典数据表
-- ----------------------------
drop table if exists sys_dict_data;
create table sys_dict_data
(
    dict_code        bigint(20)      not null auto_increment    comment '字典编码',
    dict_sort        int(4)          default 0                  comment '字典排序',
    dict_label       varchar(100)    default ''                 comment '字典标签',
    dict_value       varchar(100)    default ''                 comment '字典键值',
    dict_type        varchar(100)    default ''                 comment '字典类型',
    css_class        varchar(100)    default null               comment '样式属性（其他样式扩展）',
    list_class       varchar(100)    default null               comment '表格回显样式',
    is_default       char(1)         default 'N'                comment '是否默认（Y是 N否）',
    status           char(1)         default '0'                comment '状态（0正常 1停用）',
    create_by        varchar(64)     default ''                 comment '创建者',
    create_time      datetime                                   comment '创建时间',
    update_by        varchar(64)     default ''                 comment '更新者',
    update_time      datetime                                   comment '更新时间',
    remark           varchar(500)    default null               comment '备注',
    primary key (dict_code)
) engine=innodb auto_increment=100 comment = '字典数据表';
