USE boomsystem;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS permission;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS role_permission;

#create user table
CREATE TABLE user (
  id VARCHAR(200) NOT NULL PRIMARY KEY COMMENT '唯一标识ID',
  user_name VARCHAR(300) NOT NULL COMMENT '用户名',
  nick_name VARCHAR(300) NOT NULL COMMENT '昵称或姓名',
  password VARCHAR(300) NOT NULL COMMENT '密码',
  salt VARCHAR(300) NOT NULL COMMENT '密码盐,用于对密码进行加密',
  state SMALLINT DEFAULT 0 COMMENT '状态,-1:表示注册了，但是没验证,0:表示禁用,1:表示正常',
  UNIQUE INDEX (user_name)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#create role table
CREATE TABLE role (
  id VARCHAR(200) NOT NULL PRIMARY KEY COMMENT '角色唯一标识ID',
  name VARCHAR(200) NOT NULL COMMENT '角色名称',
  description VARCHAR(300) COMMENT '角色描述',
  available SMALLINT DEFAULT 0 COMMENT '是否可用，0:表示不可用，1:表示可用'
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#create permission table
CREATE TABLE permission (
  id VARCHAR(200) NOT NULL PRIMARY KEY COMMENT '资源唯一标识ID',
  name VARCHAR(200) NOT NULL COMMENT '资源名称',
  resource_type VARCHAR(100) COMMENT '资源类型，有菜单(menu)，按钮(button)',
  url VARCHAR(300) COMMENT '资源路径',
  permission VARCHAR(500) COMMENT '权限字符串,如,user,role:*,按钮,button:create..',
  parent_id VARCHAR(200) COMMENT '父级菜单Id',
  parents_id VARCHAR(500) COMMENT '父级编号列表',
  available SMALLINT DEFAULT 1 COMMENT '是否可用,默认为1,0:禁用，1:表示可用'
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#create user_role table
CREATE TABLE user_role (
  user_id VARCHAR(200) NOT NULL COMMENT '用户唯一标识ID',
  role_id VARCHAR(200) NOT NULL COMMENT '角色唯一标识ID',
  description VARCHAR(500) COMMENT '描述',
  PRIMARY KEY (user_id,role_id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#create role_permission table
CREATE TABLE role_permission (
  role_id VARCHAR(200) NOT NULL COMMENT '角色唯一标识ID',
  permission_id VARCHAR(200) NOT NULL COMMENT '权限唯一标识ID',
  description VARCHAR(500) COMMENT '描述',
  PRIMARY KEY (role_id,permission_id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#initial user data
INSERT INTO user(id,user_name,nick_name,password,salt,state)
        values ('6919368953122145077','summer','dh','pBT7CZ+B9wcerzsCXw3ZU491kao=','9b35433bd55f4abea372a202bc9c058d',1),
          ('3764605894323214085','solstice','dh','Z4gpr3dTn9TzjC3d4YU3iatpRko=','d8c9b1b1a33a49f090611eed064dee5c',1),
          ('2103957718490618842','admin','dh','UgWz3MsTsiEFYyGwtaCjWWQDdfg=','cdee2778fa3a4b7387a382d2fc276eb2',1);

#initial role data
INSERT INTO role(id,name,description,available)
        VALUES ('139057968221540044','admin','管理员',1),
          ('8961023538837238077','developer','开发人员',1),
          ('5944035280026638826','test','测试人员',1),
          ('1254905593251642104','user','一般客户',1),
          ('3795179407599750294','logger','日志运维人员',1);

#initial permission data
INSERT INTO permission(id,name,resource_type,url,permission,parent_id,parents_id,available)
        VALUES ('4354892092560042057','权限管理','menu','','admin:*','','',1),
          ('2404987392158945143','用户管理','menu','/authority/user/list','admin:*',1),
          ('4015732699209802203','角色管理','menu','/authority/role/list','admin:*',1),
          ('5443059828415402761','权限管理','menu','/authority/authority/list','admin:*',1);
