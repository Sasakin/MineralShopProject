create table users
(
    id         bigserial not null,
    first_name varchar(255),
    image      BYTEA,
    last_name  varchar(255),
    password   varchar(255),
    username   varchar(255),
    primary key (id)
);

create table users_roles
(
    user_id bigint not null,
    role_id  bigint not null
);

create table roles
(
    id   bigserial not null,
    name varchar(200),
    primary key (id)
);

alter table if exists users_roles
    add constraint FKj6m8fwv7oqv74fcehir1a9ffy
    foreign key (role_id)
    references roles;

alter table if exists users_roles
    add constraint FK2o0jvgh89lemvvo17cbqvdxaa
    foreign key (user_id)
    references users;