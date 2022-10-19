create table dogs(id serial primary key,
				  name varchar(255),
				   year int,
				   male BOOLEAN,
				  area text);
insert into dogs(name, year, male, area) values ('Berta', 2016, FALSE, 'Home');
select * from dogs;
update dogs set area = 'Best place';
select * from dogs;
delete from dogs;
select * from dogs;