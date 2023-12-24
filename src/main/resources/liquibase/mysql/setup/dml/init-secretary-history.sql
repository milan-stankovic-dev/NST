insert into tbl_secretary_history(start_date, end_date,
                                secretary_id, department_id)
values("2022-10-07", "2023-10-07", (select(id)
                                    from tbl_secretary
                                    where first_name = "Persida"
                                    and last_name = "Perovic"),
                                    (select(id)
                                    from tbl_department
                                    where short_name = "SILAB"));
insert into tbl_secretary_history(start_date, end_date,
                                secretary_id, department_id)
values("2022-01-30", "2023-07-20", (select(id)
                                    from tbl_secretary
                                    where first_name = "Jana"
                                    and last_name = "Janic"),
                                    (select(id)
                                    from tbl_department
                                    where short_name = "ELAB"));