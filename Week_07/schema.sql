create table if not exists Persons
(
	PersonID int null,
	LastName varchar(255) null,
	FirstName varchar(255) null,
	Address varchar(255) null,
	City varchar(255) null
);

create table if not exists customer_attributes
(
	customer_id varchar(10) null,
	customer_name varchar(50) not null,
	customer_email varchar(250) not null,
	customer_phone varchar(20) null
);

create index customer_attributes_customers_customer_id_fk
	on customer_attributes (customer_id);

create table if not exists customer_states
(
	customer_id varchar(10) null,
	is_registered tinyint(1) not null,
	state varchar(10) default 'ACTIVE' not null
);

create index customer_states_customers_customer_id_fk
	on customer_states (customer_id);

create table if not exists customers
(
	customer_id varchar(10) not null
		primary key
);

create table if not exists item_attributes
(
	item_id int not null,
	item_version int null,
	item_attribute_id int not null,
	item_attribute_value varchar(250) null
);

create index item_attributes_items_item_id_fk
	on item_attributes (item_id);

create table if not exists item_states
(
	item_id int not null
		primary key,
	state varchar(10) not null,
	live_version int null
);

create table if not exists items
(
	item_id int not null
		primary key
);

create table if not exists items_in_order
(
	order_id int null,
	item_id int null,
	item_version int null
);

create index items_in_order_items_item_id_fk
	on items_in_order (item_id);

create index items_in_order_orders_order_id_fk
	on items_in_order (order_id);

create table if not exists order_states
(
	order_id int null,
	state varchar(10) null,
	create_timestamp timestamp not null
);

create index order_states_orders_order_id_fk
	on order_states (order_id);

create table if not exists orders
(
	order_id int not null
		primary key,
	customer_id varchar(10) null,
	last_modified timestamp not null,
	created_timestamp timestamp not null
);

create index orders_customers_customer_id_fk
	on orders (customer_id);

