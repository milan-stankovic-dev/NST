create table tbl_scientific_field(
    id bigint unsigned not null AUTO_INCREMENT,
    field_name varchar(30),
    academic_title_history_id bigint unsigned,
    primary key (id)
)