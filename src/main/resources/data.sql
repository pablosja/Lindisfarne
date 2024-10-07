INSERT INTO roles (id_role, name) VALUES (DEFAULT, 'ROLE_USER');

INSERT INTO users (id_user, username, password) VALUES (DEFAULT, 'pepa', '123456');

INSERT INTO roles_users (role_id, user_id) VALUES (1, 1)