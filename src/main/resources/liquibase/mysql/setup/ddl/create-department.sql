create table tbl_department(
	id bigint unsigned not null AUTO_INCREMENT,
	name varchar(100) not null,
	director_id bigint unsigned,
	secretary_id bigint unsigned,
	primary key (id),
	constraint director_fk1 FOREIGN KEY
	(director_id) REFERENCES tbl_director(id),
	constraint secretary_fk1 FOREIGN KEY
	(secretary_id) REFERENCES tbl_secretary(id)
)
