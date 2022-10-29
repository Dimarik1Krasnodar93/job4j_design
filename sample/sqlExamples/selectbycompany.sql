CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);
CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);
insert into company (id, name) values (1, 'Company1');
insert into company (id, name) values (2 , 'Company2');
insert into company (id, name) values (3, 'Company3');
insert into company (id, name) values (4, 'Company4');
insert into company (id, name) values (5, 'Company5');
insert into person (id, name, company_id) values (1, 'Petr', 1);
insert into person (id, name, company_id) values (2, 'Iven', 1);
insert into person (id, name, company_id) values (3, 'Margarita', 5);
insert into person (id, name, company_id) values (4, 'Olga', 5);
insert into person (id, name, company_id) values (5, 'Ladisa', 5);

select person.name name,
company.name company
from person
join company on person.company_id = company.id
where company.id != 5;


select company.name,
count(person.id) persons
from company
left join person on company.id = person.company_id
GROUP by company.name
having count(person.id) in  (select count(person.id) persons
from company
left join person on company.id = person.company_id
GROUP by company.name
order by persons desc limit 1)