package nst.springboot.restexample01.dto;

public record SubjectDTO(
    Long id,
    String name,
    int espb,
    DepartmentDTO departmentDTO
) { }
