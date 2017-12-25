

-- -------------------------------------------------------------------------------------------------
-- �������ƣ�Web_GetBusPlanDetail
-- ����˵������õ�����Ӫ����
--			 ��Ҫ�����������Σ�����
--					 user 1 2017-12-23
--					 log  1 2017-12-23
--					 reply 1 2017-12-23
--					 message 1 2017-12-23
-- 					 files 1 2017-12-23
--					 friend 1 2017-12-23
-- �������ߣ���·ƽ
-- ���̴������ڣ�2017-12-23
-- �����޸����ڣ�2017-12-23
-- �����޸����ݣ�������Ĵ���
-- -------------------------------------------------------------------------------------------------
-- �û���
create database blogs;
use blogs;
create table user(
uid int primary key auto_increment,-- �û����� 
username varchar(16) unique key,-- �û��� Ψһ
password varchar(32) not null,-- �û�����
netname varchar(50) not null,-- �û����� ������
relname varchar(100),-- �û���ʵ���� ��Ϊ��
gender enum('��','Ů') default'��',-- �û��Ա� Ĭ����
about text-- �û������ҽ��� ��Ϊ��
);
-- ��־��
create table log(
lid int primary key auto_increment,-- ��־����
ltitle varchar(100) not null,-- ��־����
lcontent text not null,-- ��־����
ltime datetime not null,-- ����ʱ��
uid int not null,-- ������־���û�id
readnum int default 0-- �Ķ���
);
-- ���۱�
create table reply(
lid int not null,-- ���ظ�������id
uid int not null,-- �����˵�id
rcontent text not null,-- ��������
rdatetime datetime not null-- ����ʱ��
);
-- ���������
create table message(
mid int primary key auto_increment,-- ������Ϣ����
sendid int not null,-- ������id
receiveid int not null-- �����˵�id
);
-- �ļ���
create table files(
fid int primary key auto_increment,-- �ļ�id 
fpath varchar(255) not null,-- �ļ����·��
ftype enum('����','ͼƬ') not null,-- �ļ�����
uid int not null-- �ϴ��û�id
);
-- ���ѱ�
create table friend(
first int not null,-- ����id
second int not null-- ����id
);