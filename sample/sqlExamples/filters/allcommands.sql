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

insert into type (name) values ('СЫР');
insert into type (name) values ('МОЛОКО');
insert into type (name) values ('МЯСО');
insert into type (name) values ('КОФЕ');
insert into product (name, type_id, expired_date, price) values ('мороженое в стаканчике', 2, date '2022-09-01', 55.5);
insert into product (name, type_id, expired_date, price) values ('мороженое Лакомка', 2, date '2022-09-15', 60.5);
insert into product (name, type_id, expired_date, price) values ('Сыр Российский', 1, date '2022-10-15', 560.5);
insert into product (name, type_id, expired_date, price) values ('Курица',3, date '2022-11-15', 360.2);
insert into product (name, type_id, expired_date, price) values ('Курица',3, date '2022-11-16', 360.2);
insert into product (name, type_id, expired_date, price) values ('Кофе с пенкой', 4, date '2022-12-15', 400);

select * from "type" where name = 'СЫР';

select * from product where name like '%мороженое%';

select * from product where expired_date <= current_date;

select * from product where product.price
in (select product.price from product order by product.price desc limit 1) ;

select type.name, count(product."id") Количество
from type
join product on type.id = product.type_id
group by type.name;

select product.name Продукт,
type.name as "Тип  продукта"
from type join product on type.id = product.type_id
where type.name = 'СЫР' OR type.name = 'МОЛОКО';

select count(product.name) Продукт,
type.name Тип
from type
join product on type.id = product.type_id
group by type.name
having count(product.id) < 10;

select * from product
join type on type.id = product.type_id;

