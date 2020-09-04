create table customer (id bigint not null auto_increment, customer_id bigint, name varchar(255), primary key (id)) engine=InnoDB
create table my_order (id bigint not null auto_increment, order_id bigint, customer_id bigint, primary key (id)) engine=InnoDB
create table order_product (id bigint not null auto_increment, purchase_amount bigint, my_order_id bigint, product_id bigint, primary key (id)) engine=InnoDB
create table product (id bigint not null auto_increment, name varchar(255), price bigint, product_id bigint, primary key (id)) engine=InnoDB
alter table my_order add constraint FKfl2uk880wx9xddhjl29ns9yh8 foreign key (customer_id) references customer (id)
alter table order_product add constraint FKks2bj1fjs4wury4t0sg5188i7 foreign key (my_order_id) references my_order (id)
alter table order_product add constraint FKhnfgqyjx3i80qoymrssls3kno foreign key (product_id) references product (id)
