-- insert roles to roles
INSERT INTO roles(name) values('ROLE_USER');
INSERT INTO roles(name) values('ROLE_ADMIN');

-- insert admin with login = admin and password = admin
INSERT INTO users(login,  password) values('admin', 'admin');
INSERT INTO users(login,  password) values('userAdmin', 'userAdmin');

-- insert role admin for user admin
INSERT INTO user_role(user_id, role_id) values(1, 2);

-- insert role user and admin for user userAdmin
INSERT INTO user_role(user_id, role_id) values(2, 1);
INSERT INTO user_role(user_id, role_id) values(2, 2);

-- delete from table
DELETE FROM users;
DELETE FROM roles;

-- select all from table
SELECT * FROM users;
SELECT * FROM roles;
SELECT * FROM user_role;

-- drop all table
DROP TABLE users CASCADE;
DROP TABLE roles CASCADE;
DROP TABLE user_role CASCADE;