--�������ݿ�
create database db_Supermarket;
--ʹ�����ݿ�
use db_Supermarket;

--�������ݱ�
--�˻���

create table tb_user(
	userId int primary key identity(1001,1),	--�û�ID
	userName varchar(20) not null,	--�û�����
	userPassword varchar(20) not null,	--�û�����
	userSex varchar(1) not null,	--�û��Ա�
	userAge int check(userAge>0 and userAge <120),	--�û�����
	telephone varchar(15) not null,	--�û��绰
	address varchar(50) not null,	--�û���ַ
	pic varchar(100) not null,	--�û�ͷ��
	type int not null	--�û�����|0����������Ա��1����ͨ�û�
)



--��Ӧ�̱�

create table tb_provider(
	providerId int primary key identity(1,1),	--��Ӧ��ID
	providerName nvarchar(20) not null,		--��Ӧ������
	providerDetail nvarchar(20),	--��Ӧ������
	contact nvarchar(20) not null,	--��ϵ��
	telephone nvarchar(15) not null,	--��Ӧ�̵绰
	facsimile nvarchar(15) not null,	--��Ӧ�̴���
	address nvarchar(50) not null	--��Ӧ�̵�ַ
)

--��Ʒ��

create table tb_goods(
	goodsId int primary key identity(1,1),	--��ƷID
	goodsName nvarchar(30) not null,	--��Ʒ����
	goodsNum int check(goodsNum>0) not null,	--��Ʒ���
	goodsPrice float check(goodsPrice>0) not null, --��Ʒ�۸�
	goodsUnit nvarchar(4),	--��Ʒ��λ
	goodsIntro nvarchar(50) not null	--��Ʒ����
)

--�˵���

create table tb_account(
	accountId int primary key identity(1,1),	--�˵�ID
	providerId int not null,	--��Ӧ��ID
	totalPrice float not null,	--�����ܶ�
	isPayed int check(isPayed in(0,1)),	--�Ƿ񸶿�
	accountDate date not null,	--�˵�ʱ��
	goodsId int not null,	--��ƷID
	businessNum int not null	--��������
)
go
--��������
insert into tb_user values
('admin','123456','m',20,'18236238825','���','/photo/lwf.jpg',0)

insert into tb_provider values
('��ӿƼ��ܾ���','ȫ��������','����','15139003274','0695666888','���������')

insert into tb_goods values
('111',100,998.00,'��','�ھ�����')
insert into tb_goods values
('222',100,998.00,'��','�ھ��ӻ���')
insert into tb_goods values
('333',100,998.00,'��','�ھ���Ҷ��')
insert into tb_goods values
('444',100,998.00,'��','�ھ�����')

insert into tb_account values
(1001,99800,1,GETDATE(),1,100)

--���ݲ�ѯ
select * from tb_user
select * from tb_provider
select * from tb_goods
select * from tb_account
go

