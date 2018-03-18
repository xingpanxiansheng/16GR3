create table emp2 sa select e1,e2,e3 from emp;
--只有表结构没数据
create table emp2 sa select e1,e2,e3 from emp where 1=2;
--增加字段
alter table emp add master integer;
--修改字段类型
alter table emp modify sex varchar(2);
--添加检查约束
alter table emp add constranint sexvalue check(sex in ('男','女'));
--删除约束
alter table emp drop constraint sexvalue;
--链接
--左
select e.* from emp e left join dept d on d.did=e.did;
--全
select e.eid,e.ename,d.dname from emp e full join dept d on e.did=d.did
--交叉
select e.eid, e.ename,d.name from emp e cross join dept
--自己链接自己
select d.dname as dname,m.dname as mname from dept d,dept m where d.master = m.did;
--去重
select distinct(eid) from emp;
--having
select d.dname,max(e.sar),min(e.sar),avg(e.sar)
from dept d,emp e
where d.did=e.did
group by d.dname
having avg(e.sar)<5000;