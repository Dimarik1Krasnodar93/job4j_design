CREATE table roles (
	id serial primary key,
	name VARCHAR(255)
);
create table rules (
	id serial primary key,
	name VARCHAR(255)
);
create table roles_rules (
	id serial primary key,
	role_id INT REFERENCES roles(id),
	rule_id int REFERENCES rules(id)
);
create table users (
id serial primary key,
name varchar(255),
role_id int REFERENCES roles(id)
);
create table states (
id serial primary key,
name varchar(255)
);
create table categories(
id serial primary key,
name varchar(255)
);
create table items (
id serial primary key,
name varchar(255),
user_id int references users(id),
state_id int references states(id),
categories_id int references categories(id)
);
create table comments(
	id serial primary key,
	name varchar(255),
	user_id int references users(id)
);
create table attachs (
	id serial primary key,
	name varchar(255),
	user_id int references users(id)
);

