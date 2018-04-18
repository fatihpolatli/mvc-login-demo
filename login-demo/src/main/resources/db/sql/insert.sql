INSERT INTO user(username,password,enabled) VALUES ('mkyong','$2a$11$TX0Ye0B4kYcXU0jOuxcRv.SaOXdNGx27G91F10ZOkNhhdvnzsOJsy', true);
INSERT INTO user(username,password,enabled) VALUES ('alex','$2a$11$TX0Ye0B4kYcXU0jOuxcRv.SaOXdNGx27G91F10ZOkNhhdvnzsOJsy', true);
INSERT INTO user(username,password,enabled) VALUES ('admin','$2a$11$TX0Ye0B4kYcXU0jOuxcRv.SaOXdNGx27G91F10ZOkNhhdvnzsOJsy', true);

INSERT INTO user_roles (username, role) VALUES ('mkyong', 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES ('mkyong', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role) VALUES ('alex', 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES ('admin', 'ROLE_ADMIN');