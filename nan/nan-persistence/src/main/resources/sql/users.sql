/* Table USERS */
CREATE TABLE users (
	id serial PRIMARY KEY,
	first_name VARCHAR(100) DEFAULT NULL,
	last_name VARCHAR(100) DEFAULT NULL,
	email VARCHAR(150) NOT NULL	
);