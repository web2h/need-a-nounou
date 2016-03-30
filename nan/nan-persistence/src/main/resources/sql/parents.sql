/* Table PARENTS */
CREATE TABLE parents (
	id INTEGER PRIMARY KEY,
	CONSTRAINT 'fk_parents_users' FOREIGN KEY ('id') REFERENCES users('id') 
);