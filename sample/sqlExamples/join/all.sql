create table departments (
id serial primary key,
name text
);

create table employeers (
id serial primary key,
name text,
department_id int references departments(id)
);

create table teens (
id serial primary key,
name text,
male boolean
);

insert into  departments (name) values ('IT');
insert into  departments (name) values ('HR');
insert into  departments (name) values ('Administration');
insert into  departments (name) values ('Security');
insert into employeers (name, department_id) values ('Ivan', 1);
insert into employeers (name, department_id) values ('Petr', 1);
insert into employeers (name, department_id) values ('Dmitry', 1);
insert into employeers (name, department_id) values ('Ilya', 1);
insert into employeers (name, department_id) values ('Lena', 2);
insert into employeers (name, department_id) values ('Darya', 2);
insert into employeers (name, department_id) values ('Olga', 2);
insert into employeers (name, department_id) values ('Evgeny Petrovich', 3);
insert into employeers (name, department_id) values ('Ilya Ivanovich', 3);
insert into employeers (name, department_id) values ('Ilya Igodevich', null);
insert into teens(name, male) values ('Igor', true);
insert into teens(name, male) values ('Evdokim', true);
insert into teens(name, male) values ('Adnrey', true);
insert into teens(name, male) values ('Ilya', false);
insert into teens(name, male) values ('Olga', true);
insert into teens(name, male) values ('Nadya', true);
insert into teens(name, male) values ('Nadya', true);

select * from employeers;

select dep.name Департамент, emp.name Сотрудник
from departments dep
left join employeers emp on dep.id = emp.department_id;

select dep.name Департамент, emp.name Сотрудник
from employeers emp
right join departments dep on dep.id = emp.department_id;

select * from departments
right join employeers
on departments.id = employeers.department_id;


select * from  departments
cross join employeers;

select * from  departments dep
full join employeers emp
on dep.id = emp.department_id;

select * from departments dep
left join employeers emp
on dep.id = emp.department_id
where employeers.id is null;

select * from teens t1
cross join teens t2
where t1.male != t2.male

