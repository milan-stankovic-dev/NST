insert into tbl_director(start_date, first_name, last_name,
                        department_id)
values ("2023-04-04","Jovan", "Jovanovic", (select(id)
                                            from tbl_department
                                            where short_name= "SILAB"));
insert into tbl_director(start_date, first_name, last_name,
                        department_id)
values ("2023-03-04","Pera", "Stojic", (select(id)
                                            from tbl_department
                                            where short_name= "MMKLAB"));
insert into tbl_director(start_date, first_name, last_name,
                        department_id)
values ("2022-12-02","Sima", "Simic", (select(id)
                                            from tbl_department
                                            where short_name= "IS"));
insert into tbl_director(start_date, first_name, last_name,
                        department_id)
values ("2022-11-30","Ana", "Antonovic", (select(id)
                                            from tbl_department
                                            where short_name= "ELAB"));
insert into tbl_director(start_date, first_name, last_name,
                        department_id)
values ("2023-09-09","Sara", "Saric", (select(id)
                                            from tbl_department
                                            where short_name= "AI"));