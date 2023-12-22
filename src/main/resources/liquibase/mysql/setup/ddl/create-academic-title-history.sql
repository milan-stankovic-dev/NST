create table tbl_academic_title_history (
    id bigint unsigned not null AUTO_INCREMENT,
    start_date datetime,
    end_date datetime,
    academic_title_id bigint unsigned,
    scientific_field_id bigint unsigned,
    primary key (id),
    constraint academic_title_fk FOREIGN KEY
    (academic_title_id) REFERENCES tbl_academic_title(id),
    constraint scientific_field_fk FOREIGN KEY
    (scientific_field_id) REFERENCES tbl_scientific_field(id)
);
