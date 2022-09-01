select * from passport join persons on passport.id = persons.passport_id join employeersPersons on persons.id = employeersPersons.person_id;
select pas.number as Номер, pers.name Имя, emp.name Должность
from passport pas JOIN persons pers on pas.id = pers.passport_id join employeersPersons emp on per.id = emp.person_id;
select pas.number as Номер, pers.name Имя, emp.name Должность
from passport pas JOIN persons pers on pas.id = pers.passport_id join employeersPersons emp on pers.id = emp.person_id;
select pas.number as "Номер паспорта", pas.id id, pers.name ФИО, emp.name Должность
from passport pas join persons pers on pas.id = pers.passport_id
join employeersPersons emp on pers.id = emp.person_id;