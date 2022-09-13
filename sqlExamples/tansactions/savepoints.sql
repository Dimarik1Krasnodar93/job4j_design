begin transaction;
declare crusorscrollback  scroll crusor for select * from products order by id desc;
fetch from crusor;
close crusorscrollback;
dellocate crusorscrollback;
commit;
