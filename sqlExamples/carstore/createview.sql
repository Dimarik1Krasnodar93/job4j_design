create view createwiew as
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

select * from createwiew;
alter view createwiew rename to createview21;
drop view createview21;
