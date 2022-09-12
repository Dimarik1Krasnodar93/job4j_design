begin transaction;
insert into products (name) values ('2022-09-12-1');
rollback;
select * from products;

begin transaction;
insert into products (name) values ('2022-09-12-1');
commit;
select * from products;

begin transaction;
insert into products (name) values ('2022-09-12-2');
savepoint pointname;
insert into products (name) values ('2022-09-12-3');
rollback to pointname;
commit;
select * from products order by id desc;

begin transaction;
insert into products (name) values ('2022-09-12-2_');
savepoint pointname;
insert into products (name) values ('2022-09-12-3');
savepoint pointname2;
insert into products (name) values ('2022-09-12-4');
rollback to pointname2;
commit;
select * from products order by id desc;


