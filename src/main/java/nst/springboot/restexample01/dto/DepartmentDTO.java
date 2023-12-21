package nst.springboot.restexample01.dto;

import nst.springboot.restexample01.controller.domain.Director;
import nst.springboot.restexample01.controller.domain.DirectorHistory;
import nst.springboot.restexample01.controller.domain.Secretary;
import nst.springboot.restexample01.controller.domain.SecretaryHistory;

import java.util.List;

public record DepartmentDTO(
    Long id,
    String name,
    String shortName,
    Secretary secretary,
    List<SecretaryHistory> secretaryHistories,
    Director director,
    List<DirectorHistory> directorHistories
) { }
