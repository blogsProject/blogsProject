create table user(
uid int primary key auto_increment,
username varchar(16) unique key,
password varchar(32) not null,
netname varchar(50) not null,
relname varchar(100),
gender enum('男','女') default'男',
about text
);
create table log(
lid int primary key auto_increment,
ltitle varchar(100) not null,
lcontent text not null,
ltime datetime not null,
uid int not null,
readnum int default 0
);
-- 评论表
create table reply(
lid int not null,-- 所回复的帖子id
uid int not null,-- 评论人的id
rcontent text not null,-- 评论内容
rdatetime datetime not null-- 发送时间
);
create table message(
mid int primary key auto_increment,
sendid int not null,
receiveid int not null
);
create table files(
fid int primary key auto_increment,
fpath varchar(255) not null,
ftype enum('音乐','图片') not null,
uid int not null
);
create table friend(
first int not null,
second int not null
);