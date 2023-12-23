create table tbl_secretary(
    id bigint unsigned not null AUTO_INCREMENT,
    first_name varchar(25) not null,
    last_name varchar(25) not null,
    start_date datetime,
    end_date datetime,
    department_id bigint unsigned,
    primary key (id),
    constraint department_fk2 FOREIGN KEY
    (department_id) REFERENCES tbl_department(id)
)