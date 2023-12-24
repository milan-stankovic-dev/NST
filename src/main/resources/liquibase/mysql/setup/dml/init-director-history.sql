insert into tbl_director_history(start_date, end_date,
                                director_id, department_id)
values("2020-01-07", "2021-01-07", (select(id)
                                    from tbl_director
                                    where first_name = "Jovan"
                                    and last_name = "Jovanovic"),
                                    (select(id)
                                    from tbl_department
                                    where short_name = "IS"));
insert into tbl_director_history(start_date, end_date,
                                director_id, department_id)
values("2022-07-20", "2023-07-20", (select(id)
                                    from tbl_director
                                    where first_name = "Sima"
                                    and last_name = "Simic"),
                                    (select(id)
                                    from tbl_department
                                    where short_name = "ELAB"));