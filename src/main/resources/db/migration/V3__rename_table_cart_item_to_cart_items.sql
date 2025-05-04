alter table cart_item
drop foreign key cart_item_carts_id_fk;

alter table cart_item
drop foreign key cart_item_products_id_fk;

rename table cart_item to cart_items;

alter table cart_items
    add constraint cart_items_carts_id_fk
        foreign key (cart_id) references carts (id)
            on delete cascade;

alter table cart_items
    add constraint cart_items_products_id_fk
        foreign key (product_id) references products (id)
            on delete cascade;

