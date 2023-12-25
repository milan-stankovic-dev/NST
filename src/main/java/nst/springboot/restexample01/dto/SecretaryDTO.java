package nst.springboot.restexample01.dto;

import java.time.Instant;
import java.time.LocalDate;

public record SecretaryDTO(
    Long id,
    LocalDate startDate,
    String firstName,
    String lastName,
    Long departmentId
) { }
