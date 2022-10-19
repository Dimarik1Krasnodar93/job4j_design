create or replace procedure deletevalues(price_int integer)
 LANGUAGE 'plpgsql'
 as $$
 BEGIN
 	delete from products
	where price = price_int;
 end;
 $$;

create or replace FUNCTION getID_and_delete_values1(price_int integer)
returns integer
   LANGUAGE 'plpgsql'
 as $$
 declare result integer;
 BEGIN
	select into result id from products where price = price_int;
 	delete from products
	where price = price_int;
	return result;
 end;
 $$;


 call deletevalues(2074);

 select * from products;

 select * from getID_and_delete_values1(2878);

