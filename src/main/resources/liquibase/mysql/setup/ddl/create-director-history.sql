create table tbl_director_history (
    id bigint unsigned not null AUTO_INCREMENT,
    director_id bigint unsigned,
    primary key (id),
    constraint director_fk FOREIGN KEY (director_id)
    REFERENCES tbl_director(id)
)

