create table tbl_secretary(
    id bigint unsigned not null AUTO_INCREMENT,
    start_date datetime,
    first_name varchar(25) not null,
    last_name varchar(25) not null,
    department_id bigint unsigned,
    primary key (id),
    constraint department_fk2 FOREIGN KEY
    (department_id) REFERENCES tbl_department(id)
)