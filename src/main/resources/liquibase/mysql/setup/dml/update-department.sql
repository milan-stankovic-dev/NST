update tbl_department dep set dep.director_id = (select (dir.id)
                                       from tbl_director dir
                                       where dir.id = dep.id);
update tbl_department dep set dep.secretary_id = (select (sec.id)
                                       from tbl_secretary sec
                                       where sec.id = dep.id);