create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace function taxAfter()
	returns trigger as
	$$
		BEGIN
			update products
			set price = price * 1.2;
			return NEW;
		END;
	$$
LANGUAGE 'plpgsql';

create or replace function taxBefore()
returns trigger as
$$
	BEGIN
		UPDATE products
		set price  = price * 1.1;
		return NEW;
	END;
$$
LANGUAGE 'plpgsql';

create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create or replace function copy_prices()
returns trigger as
$$
	BEGIN
		insert into history_of_price (name, price, date)
		values (new.name, new.price, current_timestamp);
		return NEW;
	END;
$$
LANGUAGE 'plpgsql';

create trigger tax_statement_trigger
	after insert on products
    referencing new table as inserted
    for each statement
	execute procedure taxAfter();

create trigger tax_row_before
	before INSERT
	on products
	for each row
	execute procedure taxBefore();

create trigger copy_prices_after
	after insert
	on products
	for each row
	execute procedure copy_prices();