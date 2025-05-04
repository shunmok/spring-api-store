create table carts
(
    id           BINARY(16) default (uuid_to_bin(uuid())) not null
        primary key,
    date_created date default (curdate())      not null
);

create table cart_item
(
    id         bigint auto_increment
        primary key,
    cart_id    BINARY(16) not null,
    product_id bigint        not null,
    quantity   int default 1      not null,
    constraint cart_item_cart_product_unique
        unique (cart_id, product_id),
    constraint cart_item_carts_id_fk
        foreign key (cart_id) references carts (id) on delete cascade,
    constraint cart_item_products_id_fk
        foreign key (product_id) references products (id) on delete cascade
);
