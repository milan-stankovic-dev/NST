create table tbl_academic_title_history(
    id bigint unsigned not null AUTO_INCREMENT,
    start_date datetime,
    end_date datetime,
    academic_title_id bigint unsigned,
    scientific_title_id bigint unsigned
)