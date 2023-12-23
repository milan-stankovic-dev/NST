alter table tbl_department
add constraint director_fk_1
foreign key (director_id)
references tbl_director(id);