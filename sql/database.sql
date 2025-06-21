CREATE TABLE users (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	username varchar(100) NOT NULL,
	password varchar(255) NOT NULL,
	CONSTRAINT users_unique UNIQUE KEY (username)
);

CREATE TABLE roles (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	role VARCHAR(50) NOT NULL
);

CREATE TABLE user_roles (
	user_id BIGINT NOT NULL,
	role_id BIGINT NOT NULL,
	CONSTRAINT user_roles_pk PRIMARY KEY (user_id,role_id),
	CONSTRAINT user_roles_users_FK FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT user_roles_roles_FK FOREIGN KEY (role_id) REFERENCES roles(id)
);

INSERT INTO roles(role) VALUES ("ROLE_ADMIN"),("ROLE_USER"); 
