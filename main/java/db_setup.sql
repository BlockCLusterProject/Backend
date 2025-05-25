CREATE DATABASE blockcluster;
USE blockcluster;

CREATE TABLE movies (
	id INT AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(100) NOT NULL,
	runtime INT NOT NULL CHECK (runtime >= 0),
	vote_average DECIMAL(10, 2) CHECK (vote_average >= 0),
	genres JSON  NULL,
	genre_ids JSON  NULL,
	price DOUBLE NOT NULL CHECK (price >= 0),
	overview VARCHAR(1000) NOT NULL,
	backdrop_path VARCHAR(100) NOT NULL,
	is_active BOOLEAN NOT NULL DEFAULT FALSE,
	quantity INT NOT NULL CHECK (quantity >= 0)
);


CREATE TABLE rol (
	id INT AUTO_INCREMENT PRIMARY KEY,
	rol VARCHAR(30) NOT NULL
);
INSERT INTO rol(rol) VALUES ('CLIENTE');
INSERT INTO rol(rol) VALUES ('ADMIN');

CREATE TABLE users (
	id INT AUTO_INCREMENT PRIMARY KEY,
	id_rol INT NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	cedula VARCHAR(20) NOT NULL,
	age INT NOT NULL CHECK(age > 0 && age < 200),
	email VARCHAR(255) NOT NULL UNIQUE,
	phone VARCHAR(100) NOT NULL,
	preferences JSON NULL,
	usuario VARCHAR(100) NOT NULL UNIQUE,
	contrasena VARCHAR(255) NOT NULL,
	CONSTRAINT fk_rol FOREIGN KEY (id_rol) REFERENCES rol(id)
);


INSERT INTO users (
	id_rol, nombre, cedula, age, email, phone, preferences, usuario, contrasena
) VALUES (
	1, 'Juan Pérez', '1234567890', 30,
	'juan.perez@example.com', '+57-3001234567', '{}',
	'juanperez', 'holi'
);

INSERT INTO users (
	id_rol, nombre, cedula, age, email, phone, preferences, usuario, contrasena
) VALUES (
	2, 'Juan', '1234', 25, 
	'notiene@notiene.com', '32323322', '{}', 
	'blockcluster1', '123'
);

INSERT INTO users (
	id_rol, nombre, cedula, age, email, phone, preferences, usuario, contrasena
) VALUES (
	2, 'Andrea', '3456', 25, 
	'notiene2@notiene.com', '33523922', 
	'{}', 'blockcluster2', '123'
);

INSERT INTO users (
	id_rol, nombre, cedula, age, email, phone, preferences, usuario, contrasena
) VALUES (
	1, 'Andrea', '111', 20,
	'notiene3@notiene.com', '3207080333', '{}',
	'cliente1', 'cliente1'
);

INSERT INTO users (
	id_rol, nombre, cedula, age, email, phone, preferences, usuario, contrasena
) VALUES (
	1, 'Ramon', '222', 20,
	'notiene4@notiene.com', '3012502835', '{}',
	'cliente2', 'cliente2'
);

INSERT INTO users (
	id_rol, nombre, cedula, age, email, phone, preferences, usuario, contrasena
) VALUES (
	1, 'Pablo', '333', 20,
	'notiene5@notiene.com', '3182506735', '{}',
	'cliente3', 'cliente3'
);


CREATE TABLE purchases_history (
	id INT AUTO_INCREMENT PRIMARY KEY,
	client_id INT NOT NULL CHECK (client_id > 0),
	movie_id INT NOT NULL CHECK (movie_id > 0),
	quantity INT NOT NULL CHECK (quantity > 0),
	price DOUBLE NOT NULL CHECK (price >= 0),
	CONSTRAINT fk_client_id FOREIGN KEY (client_id) REFERENCES users(id),
	CONSTRAINT fk_movie_id FOREIGN KEY (movie_id) REFERENCES movies(id)
);