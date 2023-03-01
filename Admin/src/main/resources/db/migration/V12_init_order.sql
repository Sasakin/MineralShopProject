create table cart_item
(
    id               bigserial not null,
    quantity         integer   not null,
    total_price      float(53) not null,
    shopping_cart_id bigint,
    product_id       bigint,
    primary key (id)
);

create table categories
(
    category_id  bigserial not null,
    is_activated boolean,
    is_deleted   boolean,
    name         varchar(255),
    primary key (category_id)
);

create table customers
(
    customer_id  bigserial not null,
    address      varchar(255),
    city         varchar(255),
    country      varchar(255),
    first_name   varchar(255),
    image        BYTEA,
    last_name    varchar(255),
    password     varchar(255),
    phone_number varchar(255),
    username     varchar(255),
    primary key (customer_id)
);

create table customers_roles
(
    customer_id bigint not null,
    role_id     bigint not null
);

create table order_detail
(
    order_detail_id bigserial not null,
    quantity        integer   not null,
    total_price     float(53) not null,
    unit_price      float(53) not null,
    order_id        bigint,
    product_id      bigint,
    primary key (order_detail_id)
);

create table orders
(
    order_id      bigserial not null,
    delivery_date timestamp(6),
    notes         varchar(255),
    order_date    timestamp(6),
    order_status  varchar(255),
    shipping_fee  float(53) not null,
    total_price   float(53) not null,
    customer_id   bigint,
    primary key (order_id)
);

create table products
(
    product_id       bigserial not null,
    cost_price       float(53) not null,
    current_quantity integer   not null,
    description      varchar(255),
    image            BYTEA,
    is_activated     boolean   not null,
    is_deleted       boolean   not null,
    name             varchar(255),
    sale_price       float(53) not null,
    category_id      bigint,
    primary key (product_id)
);

create table shopping_cart
(
    shopping_cart_id bigserial not null,
    total_items      integer   not null,
    total_prices     float(53) not null,
    customer_id      bigint,
    primary key (shopping_cart_id)
);

alter table if exists categories
drop
constraint if exists UKt8o6pivur7nn124jehx7cygw5;


alter table if exists categories
    add constraint UKt8o6pivur7nn124jehx7cygw5 unique (name);


alter table if exists customers
drop
constraint if exists UKjwbsy21ejuv3pnakcs3kaiwei;

alter table if exists customers
    add constraint UKjwbsy21ejuv3pnakcs3kaiwei unique (username, image, phone_number);

alter table if exists products
drop
constraint if exists UKedwf748ofxio2rnbmywgif454;

alter table if exists products
    add constraint UKedwf748ofxio2rnbmywgif454 unique (name, image);

alter table if exists cart_item
    add constraint FKe89gjdx91fxnmkkssyoim8xfu
    foreign key (shopping_cart_id)
    references shopping_cart;

alter table if exists cart_item
    add constraint FKqkqmvkmbtiaqn2nfqf25ymfs2
    foreign key (product_id)
    references products;

alter table if exists customers_roles
    add constraint FKc43ultbfo55uyy6ljpi8x87mf
    foreign key (role_id)
    references roles;

alter table if exists customers_roles
    add constraint FKmn5q3x2wakfnrby09kb5n2bxs
    foreign key (customer_id)
    references customers;

alter table if exists order_detail
    add constraint FKrws2q0si6oyd6il8gqe2aennc
    foreign key (order_id)
    references orders;

alter table if exists order_detail
    add constraint FKc7q42e9tu0hslx6w4wxgomhvn
    foreign key (product_id)
    references products;

alter table if exists orders
    add constraint FKpxtb8awmi0dk6smoh2vp1litg
    foreign key (customer_id)
    references customers;

alter table if exists products
    add constraint FKog2rp4qthbtt2lfyhfo32lsw9
    foreign key (category_id)
    references categories;

alter table if exists shopping_cart
    add constraint FK64hllmf43h6bixdqdyjfyl66c
    foreign key (customer_id)
    references customers;