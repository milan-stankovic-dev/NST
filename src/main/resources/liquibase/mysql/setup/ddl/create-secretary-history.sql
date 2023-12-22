create table tbl_secretary_history(
    id bigint unsigned not null AUTO_INCREMENT,
    secretary_id bigint unsigned,
    primary key (id),
    constraint secretary_fk FOREIGN KEY (secretary_id)
    REFERENCES tbl_secretary(id)
)

