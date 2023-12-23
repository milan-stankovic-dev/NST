insert into tbl_secretary(start_date, first_name, last_name,
                        department_id)
values ("2023-04-04","Persida", "Perovic", (select(id)
                                            from tbl_department
                                            where short_name= "SILAB"));
insert into tbl_secretary(start_date, first_name, last_name,
                        department_id)
values ("2023-04-04","Jovana", "Jovicic", (select(id)
                                            from tbl_department
                                            where short_name= "MMKLAB"));
insert into tbl_secretary(start_date, first_name, last_name,
                        department_id)
values ("2022-12-12","Jana", "Janic", (select(id)
                                            from tbl_department
                                            where short_name= "IS"));
insert into tbl_secretary(start_date, first_name, last_name,
                        department_id)
values ("2022-10-30","Marko", "Markovic", (select(id)
                                            from tbl_department
                                            where short_name= "ELAB"));
insert into tbl_secretary(start_date, first_name, last_name,
                        department_id)
values ("2023-10-09","Stefan", "Stefanovic", (select(id)
                                            from tbl_department
                                            where short_name= "AI"));