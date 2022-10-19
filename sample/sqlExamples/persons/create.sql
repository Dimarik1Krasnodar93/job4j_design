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