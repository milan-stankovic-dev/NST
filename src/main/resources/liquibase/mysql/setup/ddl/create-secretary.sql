create table tbl_secretary(
    id bigint unsigned not null AUTO_INCREMENT,
    first_name varchar(25) not null,
    last_name varchar(25) not null,
    start_date datetime,
    end_date datetime,
    secretary_history_id bigint unsigned
)