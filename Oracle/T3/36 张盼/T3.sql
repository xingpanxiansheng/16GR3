create table emp2 sa select e1,e2,e3 from emp;
--ֻ�б�ṹû����
create table emp2 sa select e1,e2,e3 from emp where 1=2;
--�����ֶ�
alter table emp add master integer;
--�޸��ֶ�����
alter table emp modify sex varchar(2);
--��Ӽ��Լ��
alter table emp add constranint sexvalue check(sex in ('��','Ů'));
--ɾ��Լ��
alter table emp drop constraint sexvalue;
--����
--��
select e.* from emp e left join dept d on d.did=e.did;
--ȫ
select e.eid,e.ename,d.dname from emp e full join dept d on e.did=d.did
--����
select e.eid, e.ename,d.name from emp e cross join dept
--�Լ������Լ�
select d.dname as dname,m.dname as mname from dept d,dept m where d.master = m.did;
--ȥ��
select distinct(eid) from emp;
--having
select d.dname,max(e.sar),min(e.sar),avg(e.sar)
from dept d,emp e
where d.did=e.did
group by d.dname
having avg(e.sar)<5000;