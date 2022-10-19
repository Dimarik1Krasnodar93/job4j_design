begin transaction;
DECLARE
    cursor_products cursor for
                        select * from products;
move forward 21 cursor_products;
fetch BACKWARD from cursor_products;
fetch BACKWARD 10 from cursor_products;
fetch BACKWARD 4 from cursor_products;
fetch BACKWARD 5 from cursor_products;
close cursor_products;
commit;