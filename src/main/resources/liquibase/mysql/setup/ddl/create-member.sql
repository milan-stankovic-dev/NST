create table tbl_member(
    id bigint unsigned not null AUTO_INCREMENT,
    first_name varchar(25) not null,
    last_name varchar(25) not null,
    academic_title_id bigint unsigned,
    department_id bigint unsigned,
    education_title bigint unsigned,
    scientific_title bigint unsigned
)