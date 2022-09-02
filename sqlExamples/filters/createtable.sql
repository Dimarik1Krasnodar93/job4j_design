create table product (
id serial primary key,
type_id int,
expired_date date,
price float
);
create table type (
id serial primary key,
price float
);