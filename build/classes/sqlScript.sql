

-- -------------------------------------------------------------------------------------------------
-- 过程名称：Web_GetBusPlanDetail
-- 过程说明：获得调度运营内容
--			 需要传入表名，班次，日期
--					 user 1 2017-12-23
--					 log  1 2017-12-23
--					 reply 1 2017-12-23
--					 message 1 2017-12-23
-- 					 files 1 2017-12-23
--					 friend 1 2017-12-23
-- 过程作者：张路平
-- 过程创建日期：2017-12-23
-- 过程修改日期：2017-12-23
-- 过程修改内容：六个表的创建
-- -------------------------------------------------------------------------------------------------
-- 用户表
create database blogs;
use blogs;
create table user(
uid int primary key auto_increment,-- 用户主键 
username varchar(16) unique key,-- 用户名 唯一
password varchar(32) not null,-- 用户密码
netname varchar(50) not null,-- 用户网名 可重名
relname varchar(100),-- 用户真实姓名 可为空
gender enum('男','女') default'男',-- 用户性别 默认男
about text-- 用户的自我介绍 可为空
);
-- 日志表
create table log(
lid int primary key auto_increment,-- 日志主键
ltitle varchar(100) not null,-- 日志标题
lcontent text not null,-- 日志内容
ltime datetime not null,-- 发表时间
uid int not null,-- 所发日志的用户id
readnum int default 0-- 阅读数
);
-- 评论表
create table reply(
lid int not null,-- 所回复的帖子id
uid int not null,-- 评论人的id
rcontent text not null,-- 评论内容
rdatetime datetime not null-- 发送时间
);
-- 好友申请表
create table message(
mid int primary key auto_increment,-- 申请消息主键
sendid int not null,-- 发送人id
receiveid int not null-- 接收人的id
);
-- 文件表
create table files(
fid int primary key auto_increment,-- 文件id 
fpath varchar(255) not null,-- 文件存放路径
ftype enum('音乐','图片') not null,-- 文件类型
uid int not null-- 上传用户id
);
-- 好友表
create table friend(
first int not null,-- 主人id
second int not null-- 朋友id
);