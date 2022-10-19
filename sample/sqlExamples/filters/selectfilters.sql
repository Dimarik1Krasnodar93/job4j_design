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

