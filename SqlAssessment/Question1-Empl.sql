create database GuviAssessment;

use GuviAssessment;

create table Empl (empno int, ename varchar(25), job varchar(15), mgr int, hiredate date, sal double, comm double, deptno int);
desc Empl;

insert into Empl values (8369,'Smith','Clerk',8902,'1990-12-18',800.00,null,20);
select * from Empl;
insert into Empl values (8499,'Anya','Salesman',8698,'1991-02-20',1600.00,300.00,30);
insert into Empl values (8521,'Seth','Salesman',8698,'1991-02-22',1250.00,500.00,30);
insert into Empl values (8566,'Mahadevan','Manager',8839,'1991-04-22',2985.00,null,20);
insert into Empl values (8654,'Momin','Salesman',8698,'1991-09-28',1250.00,1400.00,30);
insert into Empl values (8698,'Bina','Manager',8839,'1991-05-01',2850.00,null,30);
insert into Empl values (8882,'Shivansh','Manager',8839,'1991-06-09',2450.00,null,10);
insert into Empl values (8888,'Scoot','Analyst',8566,'1991-12-09',3000.00,null,20);
insert into Empl values (8839,'Amir','President',null,'1991-11-18',5000.00,null,10);
insert into Empl values (8844,'Kuldeep','Salesman',8698,'1991-09-08',1500.00,0.00,30);

select ename, sal from Empl where sal >=2200;
select * from Empl where comm is null;
select ename, sal from Empl where sal not between 2500 and 4000;
select ename, job, sal from Empl where mgr is null;
select ename from Empl where ename like '__a%';
select ename from Empl where ename like '%t';
