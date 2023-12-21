package nst.springboot.restexample01.dto;

import nst.springboot.restexample01.controller.domain.Department;

public record SubjectDTO(
    Long id,
    String name,
    int espb,
    DepartmentDTO departmentDTO
) { }
