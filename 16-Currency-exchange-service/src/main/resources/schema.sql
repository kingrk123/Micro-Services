drop table if exists exchange_value ;
create table exchange_value (
		id bigint not null,
        conversion_multiple decimal(19,2), 
        currency_from varchar(255), 
        port integer not null, 
        currency_to varchar(255), 
        primary key (id))