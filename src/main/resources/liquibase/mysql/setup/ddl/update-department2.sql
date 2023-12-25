alter table tbl_department
add constraint secretary_fk_1
foreign key (secretary_id)
references tbl_secretary(id)
on update cascade
on delete set null;