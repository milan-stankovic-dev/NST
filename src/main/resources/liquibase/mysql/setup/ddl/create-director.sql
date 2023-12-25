create table tbl_director(
    id bigint unsigned not null AUTO_INCREMENT,
    start_date datetime,
    first_name varchar(25) not null,
    last_name varchar(25) not null,
    department_id bigint unsigned,
    primary key (id),
    constraint department_fk1 FOREIGN KEY
    (department_id) REFERENCES tbl_department(id)
    on update cascade on delete cascade
)
