create table tbl_director_history (
    id bigint unsigned not null AUTO_INCREMENT,
    start_date datetime,
    end_date datetime,
    director_id bigint unsigned,
    department_id bigint unsigned,
    primary key (id),
    constraint director_fk FOREIGN KEY (director_id)
    REFERENCES tbl_director(id) on update cascade
    on delete cascade,
    constraint department_fk4 FOREIGN KEY (department_id)
    REFERENCES tbl_department(id) on update cascade
    on delete cascade
)

