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
  type VARCHAR(100) COMMENT '资源类型，有菜单(menu)，按钮(button)',
  url VARCHAR(300) COMMENT '资源路径',
  permission VARCHAR(500) COMMENT '权限字符串,如,user,role:*,按钮,button:create..',
  parent_id VARCHAR(200) COMMENT '父级菜单Id',
  parent_ids VARCHAR(500) COMMENT '父级编号列表',
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

#create file manager table
CREATE TABLE file (
  id INT NOT NULL AUTO_INCREMENT COMMENT '文件资源唯一表示ID',
  company_id INT NOT NULL COMMENT '文件所属者ID',
  origin_name VARCHAR(300) NOT NULL COMMENT '上传文件原始名称',
  new_name VARCHAR(300) NOT NULL COMMENT '新文件名，用于存放在服务端用',
  extension VARCHAR(100) COMMENT '文件后缀',
  type VARCHAR(200) COMMENT '文件类型',
  size BIGINT DEFAULT 0 COMMENT '文件大小',
  save_path VARCHAR(500) NOT NULL COMMENT '上传文件存放路径',
  upload_date DATETIME NOT NULL DEFAULT now() COMMENT '文件上传日期',
  modify_date DATETIME NOT NULL DEFAULT now() ON UPDATE now() COMMENT '文件修改日期',
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET =utf8 COMMENT '文件信息表';



#initial user data
INSERT INTO user(id,user_name,nick_name,password,salt,state)
values('2103957718490618842','admin','dh','UgWz3MsTsiEFYyGwtaCjWWQDdfg=','cdee2778fa3a4b7387a382d2fc276eb2',1),
  ('6919368953122145077','summer','dh','pBT7CZ+B9wcerzsCXw3ZU491kao=','9b35433bd55f4abea372a202bc9c058d',1),
  ('3764605894323214085','solstice','dh','Z4gpr3dTn9TzjC3d4YU3iatpRko=','d8c9b1b1a33a49f090611eed064dee5c',1),
  ('6841401513155601891','logger','logger','spDJpOeY36kWluls0lgbEeDfNNg=','f00d24e6ae184d6499b096e5472af075',1),
  ('7288466796840386695','guest','匿名','7IZU2B2zksnwwUO/riJ+KPXBX3k=','d46925c33a814379b521d6170577e1e5',1);

#initial role data
INSERT INTO role(id,name,description,available)
VALUES ('139057968221540044','admin','管理员',1),
  ('8961023538837238077','developer','开发人员',1),
  ('5944035280026638826','test','测试人员',1),
  ('3795179407599750294','logger','日志运维人员',1),
  ('1254905593251642104','user','一般客户',1);

#initial permission data
INSERT INTO permission(id,name,type,url,permission,parent_id,parent_ids,available)
VALUES ('4354892092560042057','权限管理','menu','','admin:*','','',1),
  ('2404987392158945143','用户管理','menu','/authority/user/list','admin:*','4354892092560042057','4354892092560042057',1),
  ('4015732699209802203','角色管理','menu','/authority/role/list','admin:*','4354892092560042057','4354892092560042057',1),
  ('5443059828415402761','权限设置','menu','/authority/authority/list','admin:*','4354892092560042057','4354892092560042057',1),
  ('2413452668500920069','代码管理','menu','','admin:*,developer:*','','',1),
  ('8417713137108145128','代码生成','menu','/code/generate','admin:*,developer:*','2413452668500920069','2413452668500920069',1),
  ('3416232956739587099','系统测试','menu','','admin:*,test:*','','',1),
  ('6806169867007708720','测试报告','menu','/test/report','admin:*,test:*','3416232956739587099','3416232956739587099',1),
  ('7690077850232020760','日志管理','menu','','admin:*,logger:*','','',1),
  ('3005305379139319283','日志查看','menu','/test/report','admin:*,test:*','7690077850232020760','7690077850232020760',1),
  ('4046221699861098411','设置','menu','','','','',1),
  ('2945601868592201393','用户信息','menu','/user/info','','4046221699861098411','4046221699861098411',1),
  ('6918511036352731138','密码修改','menu','/user/changePassword','','4046221699861098411','4046221699861098411',1);

#intial user_role table
INSERT INTO user_role(user_id, role_id, description)
VALUES ('2103957718490618842','139057968221540044','admin是超级管理员'),
  ('6919368953122145077','8961023538837238077','summer是开发人员'),
  ('3764605894323214085','5944035280026638826','solstice是测试人员'),
  ('6841401513155601891','3795179407599750294','logger是日志运维人员'),
  ('7288466796840386695','1254905593251642104','guest是一般用户');

#initial role_persmission table
INSERT INTO role_permission(role_id,permission_id,description)
VALUES ('139057968221540044','4354892092560042057','admin权限管理'),
  ('139057968221540044','2404987392158945143','admin用户管理'),
  ('139057968221540044','4015732699209802203','admin角色管理'),
  ('139057968221540044','5443059828415402761','admin权限设置'),
  ('139057968221540044','2413452668500920069','admin代码管理'),
  ('139057968221540044','8417713137108145128','admin代码生成'),
  ('139057968221540044','3416232956739587099','admin系统测试'),
  ('139057968221540044','6806169867007708720','admin测试报告查看'),
  ('139057968221540044','7690077850232020760','admin日志管理'),
  ('139057968221540044','3005305379139319283','admin日志查看'),
  ('6919368953122145077','2413452668500920069','summer开发人员'),
  ('6919368953122145077','8417713137108145128','summer代码生成'),
  ('5944035280026638826','3416232956739587099','test系统测试'),
  ('5944035280026638826','6806169867007708720','test系统测试报告'),
  ('3795179407599750294','7690077850232020760','logger日志管理'),
  ('3795179407599750294','3005305379139319283','logger日志查看');

#insert file table datas
INSERT INTO
  file(id,company_id,origin_name,new_name,extension,type,size,save_path)
VALUES
  (null,1,'Java入门到精通.pdf','20180111223155001','pdf','',20000,'/Users/summer/Downloads'),
  (null,1,'Hadoop入门到精通.pdf','20180111223155002','pdf','',50000,'/Users/summer/Downloads'),
  (null,1,'Spark入门到精通.pdf','20180111223155003','pdf','',30000,'/Users/summer/Downloads'),
  (null,1,'Flume入门到精通.pdf','20180111223155004','pdf','',30000,'/Users/summer/Downloads'),
  (null,1,'Elasticsearch入门到精通.pdf','20180111223155005','pdf','',10000,'/Users/summer/Downloads');
