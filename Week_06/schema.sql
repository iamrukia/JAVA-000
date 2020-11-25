
create table customers
(
    customer_id varchar(10) not null
        primary key
);

create table customer_attributes
(
    customer_id    varchar(10)  null,
    customer_name  varchar(50)  not null,
    customer_email varchar(250) not null,
    customer_phone varchar(20)  null,
    constraint customer_attributes_customers_customer_id_fk
        foreign key (customer_id) references customers (customer_id)
);

create table customer_states
(
    customer_id   varchar(10)                  null,
    is_registered tinyint(1)                   not null,
    state         varchar(10) default 'ACTIVE' not null,
    constraint customer_states_customers_customer_id_fk
        foreign key (customer_id) references customers (customer_id)
);

create table items
(
    item_id int not null
        primary key
);

create table item_attributes
(
    item_id              int          not null,
    item_version         int          null,
    item_attribute_id    int          not null,
    item_attribute_value varchar(250) null,
    constraint item_attributes_items_item_id_fk
        foreign key (item_id) references items (item_id)
);

create table item_states
(
    item_id      int         not null
        primary key,
    state        varchar(10) not null,
    live_version int         null,
    constraint item_states_items_item_id_fk
        foreign key (item_id) references items (item_id)
);

create table orders
(
    order_id          int         not null
        primary key,
    customer_id       varchar(10) null,
    last_modified     timestamp   not null,
    created_timestamp timestamp   not null,
    constraint orders_customers_customer_id_fk
        foreign key (customer_id) references customers (customer_id)
);

create table items_in_order
(
    order_id     int null,
    item_id      int null,
    item_version int null,
    constraint items_in_order_items_item_id_fk
        foreign key (item_id) references items (item_id),
    constraint items_in_order_orders_order_id_fk
        foreign key (order_id) references orders (order_id)
);

create table order_states
(
    order_id         int         null,
    state            varchar(10) null,
    create_timestamp timestamp   not null,
    constraint order_states_orders_order_id_fk
        foreign key (order_id) references orders (order_id)
);