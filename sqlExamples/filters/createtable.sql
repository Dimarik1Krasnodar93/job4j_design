create table type (
id serial primary key,
name text
);
create table product (
id serial primary key,
name text,
type_id int,
expired_date date,
price float
);
