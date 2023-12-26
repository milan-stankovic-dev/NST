insert into tbl_member(first_name, last_name, start_date, academic_title_id,
                    department_id, education_title_id, scientific_field_id)
values ("Pera", "Peric", "2020-03-04",
                        (select (id)
                        from tbl_academic_title
                        where name = "Lecturer"),
                        (select (id)
                        from tbl_department
                        WHERE short_name="IS"),
                        (select (id)
                        from tbl_education_title
                        where title_name = "Professor"),
                        (select (id)
                        from tbl_scientific_field
                        where field_name = "HCI"));
insert into tbl_member(first_name, last_name, start_date,  academic_title_id,
                    department_id, education_title_id, scientific_field_id)
values ("Mara", "Maric", "2023-04-06",
                        (select (id)
                        from tbl_academic_title
                        where name = "Emeritus"),
                        (select (id)
                        from tbl_department
                        WHERE short_name="SILAB"),
                        (select (id)
                        from tbl_education_title
                        where title_name = "Assistant dean"),
                        (select (id)
                        from tbl_scientific_field
                        where field_name = "Digital marketing"));
insert into tbl_member(first_name, last_name, start_date, academic_title_id,
                    department_id, education_title_id, scientific_field_id)
values ("Zoran", "Zoric", "2009-10-23",
                        (select (id)
                        from tbl_academic_title
                        where name = "Instructor"),
                        (select (id)
                        from tbl_department
                        WHERE short_name="ELAB"),
                        (select (id)
                        from tbl_education_title
                        where title_name = "Professor"),
                        (select (id)
                        from tbl_scientific_field
                        where field_name = "Theory of computation"));
insert into tbl_member(first_name, last_name, start_date, academic_title_id,
                    department_id, education_title_id, scientific_field_id)
values ("Svetlana", "Savic", "2015-01-10",
                        (select (id)
                        from tbl_academic_title
                        where name = "Distinguished professor"),
                        (select (id)
                        from tbl_department
                        WHERE short_name="SILAB"),
                        (select (id)
                        from tbl_education_title
                        where title_name = "Professor"),
                        (select (id)
                        from tbl_scientific_field
                        where field_name = "Programming languages"));
insert into tbl_member(first_name, last_name, start_date, academic_title_id,
                    department_id, education_title_id, scientific_field_id)
values ("Milan", "Milanovic", "2012-02-29",
                        (select (id)
                        from tbl_academic_title
                        where name = "Senior lecturer"),
                        (select (id)
                        from tbl_department
                        WHERE short_name="ELAB"),
                        (select (id)
                        from tbl_education_title
                        where title_name = "Professor"),
                        (select (id)
                        from tbl_scientific_field
                        where field_name = "Digital marketing"));
insert into tbl_member(first_name, last_name, start_date, academic_title_id,
                    department_id, education_title_id, scientific_field_id)
values ("Sima", "Simic", "2021-10-04",
                        (select (id)
                        from tbl_academic_title
                        where name = "Lecturer"),
                        (select (id)
                        from tbl_department
                        WHERE short_name="IS"),
                        (select (id)
                        from tbl_education_title
                        where title_name = "Professor"),
                        (select (id)
                        from tbl_scientific_field
                        where field_name = "Security in tech"));

