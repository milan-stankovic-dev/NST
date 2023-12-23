create table tbl_secretary_history(
    id bigint unsigned not null AUTO_INCREMENT,
    start_date datetime,
    end_date datetime,
    secretary_id bigint unsigned,
    department_id bigint unsigned,
    primary key (id),
    constraint secretary_fk2 FOREIGN KEY (secretary_id)
    REFERENCES tbl_secretary(id),
    constraint department_fk3 FOREIGN KEY (department_id)
    REFERENCES tbl_department(id)
)
