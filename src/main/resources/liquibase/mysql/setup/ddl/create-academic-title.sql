create table tbl_academic_title(
    id bigint unsigned not null AUTO_INCREMENT,
    name varchar(30) not null,
    academic_title_history_id bigint unsigned,
    primary key (id)
)