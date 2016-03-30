/* Table KIDS */
CREATE TABLE kids (
	id INTEGER PRIMARY KEY,
	parent_id INTEGER NOT NULL,
	CONSTRAINT 'fk_kids_parents' FOREIGN KEY ('parent_id') REFERENCES parents('id')
);