create table car_bodies (
	id serial primary key,
	name text
);

create table car_engines (
	id serial primary key,
	name text
);

create table car_transmissions (
id serial primary key,
	name text
);

create table cars (
	id serial primary key,
	name text,
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int
);

insert into car_bodies (name) values ('Sedan'),
 ('pickup'),
  ('liftback');

insert into car_engines (name) values ('tuj5'), ('tfsi'), ('tdi');

insert into car_transmissions (name) values ('AKPP'), ('RKPP'), ('MKPP');

insert into car_bodies (name) values ('Sedan'),
('pickup'),
('liftback');

insert into car_engines (name) values ('tuj5'),
('tfsi'),
('tdi'),
('ep6');

insert into car_transmissions (name) values ('AKPP'),
('RKPP'),
('MKPP');

insert into cars (name, body_id, engine_id, transmission_id) values
('Sedan tuj5 AKPP', 1, 1, 1),
('pickup tuj5 AKPP', 2, 1, 1),
('liftback tuj5 AKPP', 3, 1, 1),
('Sedan tfsi AKPP', 1, 2, 1),
('pickup tfsi AKPP', 2, 2, 1),
('liftback tfsi AKPP', 3, 2, 1),
('Sedan tfsi MKPP', 1, 2, 1),
('pickup tfsi MKPP', 2, 2, 1),
('liftback tfsi MKPP', 3, 2, 1),
('Sedan tdi MKPP', 1, 2, 1),
('pickup tdi MKPP', 2, 2, 1),
('liftback tdi MKPP', 3, 2, 1);

select
car.name,
eng.name
from cars car
left join car_engines eng
on car.engine_id = eng.id;

select
car.name Car,
eng.name Engine,
body.name Body,
trans.name Transmission
from cars car
left join car_engines eng
on car.engine_id = eng.id
left join car_bodies body ON body.id = car.body_id
left join car_transmissions trans on trans.id = car.transmission_id;

select eng.name name from car_engines eng
left join cars on eng.id = cars.engine_id
where cars.id is null;

select body.name from car_bodies body
left join cars on body.id = cars.body_id
where cars.id is null;

select trans.name from car_transmissions trans
left join cars on trans.id = cars.transmission_id
where cars.id is null;

