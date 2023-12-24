package nst.springboot.restexample01.dto;

import java.time.Instant;

public record DirectorDTO(
    Long id,
    Instant startDate,
    String firstName,
    String lastName,
    Long departmentId
) { }
