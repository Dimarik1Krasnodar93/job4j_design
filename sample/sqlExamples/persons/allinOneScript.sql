create table passport (
	id serial primary key,
	number int
);
create table persons (
id serial primary key,
passport_id int references passport(id)  unique,
name text
);
create table employeersPersons(
	id serial primary key,
	name text,
	person_id int references persons(id)
);
insert into passport (number) values (123456);
insert into passport (number) values (123457);
insert into persons (passport_id, name) values (1, 'Ivanov');
insert into persons (passport_id, name) values (2, 'Petrov');
insert into employeersPersons (name, person_id)  values ('грузчик', 1);
insert into employeersPersons (name, person_id)  values ('водитель', 1);
select * from passport join persons on passport.id = persons.passport_id
join employeersPersons on persons.id = employeersPersons.person_id;
select pas.number as Номер, pers.name Имя, emp.name Должность
from passport pas JOIN persons pers on pas.id = pers.passport_id
join employeersPersons emp on pers.id = emp.person_id;
select pas.number as Номер, pers.name Имя, emp.name Должность
from passport pas JOIN persons pers on pas.id = pers.passport_id
join employeersPersons emp on pers.id = emp.person_id;
select pas.number as "Номер паспорта", pas.id id, pers.name ФИО, emp.name Должность
from passport pas join persons pers on pas.id = pers.passport_id
join employeersPersons emp on pers.id = emp.person_id;