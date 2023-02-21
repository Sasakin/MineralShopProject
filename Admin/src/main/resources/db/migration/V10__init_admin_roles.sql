create table admins
(
    id         bigserial not null,
    first_name varchar(255),
    image      BYTEA,
    last_name  varchar(255),
    password   varchar(255),
    username   varchar(255),
    primary key (id)
);

create table admins_roles
(
    admin_id bigint not null,
    role_id  bigint not null
);

create table roles
(
    id   bigserial not null,
    name varchar(200),
    primary key (id)
);

alter table if exists admins_roles
    add constraint FK6ioy9osuscmkmt3b0c32c5w9y
    foreign key (role_id)
    references roles;

alter table if exists admins_roles
    add constraint FK8535wewsp17vgt2scahieovxu
    foreign key (admin_id)
    references admins;