create table itemTypes(
id serial primary key,
name varchar(255)
);
create table items(
id serial primary key,
name varchar(255),
itemType_id int references itemTypes(id)
);
insert into itemTypes(name) values ('products');
insert into itemTypes(name) values ('services');
insert into items(name, itemType_id) values ('computer', 1);
insert into items(name, itemType_id) values ('processor', 1);
insert into items(name, itemType_id) values ('washing', 2);
select * from items;
select * from itemTypes where id in (select itemType_id from items);
create table stores (
	id serial primary key,
	name VARCHAR(255)
);
create TABLE items_stores(
	id serial primary key,
	item_id int references items(id),
	store_id int references stores(id)
);
insert into stores(name) VALUES ('main store');
insert into stores(name) VALUES ('central store');
insert into items_stores(item_id, store_id) values (1, 1);
insert into items_stores(item_id, store_id) values (1, 2);
insert into items_stores(item_id, store_id) values (2, 1);
insert into items_stores(item_id, store_id) values (2, 2);
create table qrcodes(
	id serial primary key,
	name VARCHAR(255)
);
create table items_qrcodes (
	id serial primary key,
	item_id int references items(id) unique,
	qrcode_id int references qrcodes(id) unique
);
insert into qrcodes(name) VALUES ('123456');
insert into qrcodes(name) VALUES ('123457');
insert INTO items_qrcodes(item_id, qrcode_id) values(1, 1);
insert into items_qrcodes(item_id, qrcode_id) values (2, 2);