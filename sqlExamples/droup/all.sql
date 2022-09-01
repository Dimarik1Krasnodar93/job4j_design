insert into devices (name, price) values ('iphone 13', 90000);
insert into devices (name, price) values ('iphone 11', 70000);
insert into devices (name, price) values ('samsung a 51', 30000);
insert into devices (name, price) values ('keyboard', 700.50);
insert into people (name) values ('Ivanov');
insert into people (name) values ('Pertov');
insert into people (name) values ('Sidorov');
insert into devices_people (device_id, people_id) values (1, 1);
insert into devices_people (device_id, people_id) values (2, 1);
insert into devices_people (device_id, people_id) values (4, 1);
insert into devices_people (device_id, people_id) values (2, 2);
select avg(price) from devices;
select  p.name name, avg(d.price)
from devices_people dp
join people p on dp.people_id = p.id
join devices d on dp.device_id = d.id
group by p.name;
select  p.name name, avg(d.price)
from devices_people dp
join people p on dp.people_id = p.id
join devices d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;