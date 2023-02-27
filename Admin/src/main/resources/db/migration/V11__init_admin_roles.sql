INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('MANAGER');
INSERT INTO roles (name) VALUES ('CUSTOMER');

INSERT INTO users (first_name, last_name, password, username)
VALUES ('admin', 'admin', '$2a$10$hSo..2AuC6jymM.OjHtxFesf.PqKiyZoJnNWNXopp8V2Fl3Ab9t4C', 'admin@mail.ru');
INSERT INTO users (first_name, last_name, password, username)
VALUES ('manager', 'manager', '$2a$10$hSo..2AuC6jymM.OjHtxFesf.PqKiyZoJnNWNXopp8V2Fl3Ab9t4C', 'manager@mail.ru');
INSERT INTO users (first_name, last_name, password, username)
VALUES ('customer', 'customer', '$2a$10$hSo..2AuC6jymM.OjHtxFesf.PqKiyZoJnNWNXopp8V2Fl3Ab9t4C', 'customer@mail.ru');

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id)
VALUES (2, 2);
INSERT INTO users_roles (user_id, role_id)
VALUES (3, 3);
