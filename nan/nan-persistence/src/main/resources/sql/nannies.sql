/* Table NANNIES */
CREATE TABLE nannies (
	id INTEGER PRIMARY KEY,
	approved CHAR(1) DEFAULT 'N' NOT NULL,
	approval_date TIMESTAMP DEFAULT NULL,
	approval_end_date TIMESTAMP DEFAULT NULL,
	CONSTRAINT 'fk_nannies_users' FOREIGN KEY ('id') REFERENCES users('id'),
	CONSTRAINT 'chk_nannies_approved_list' CHECK (approved IN ('Y', 'N'))
);