create table tbl_department(
	id bigint unsigned not null AUTO_INCREMENT,
	name varchar(100) not null,
	short_name varchar(10) not null,
	director_id bigint unsigned,
	secretary_id bigint unsigned,
	primary key (id)
)
