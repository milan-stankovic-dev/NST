package nst.springboot.restexample01.dto;

import java.util.List;

public record DepartmentDTO(
    Long id,
    String name,
    String shortName
){ }
