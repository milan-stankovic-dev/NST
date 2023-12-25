package nst.springboot.restexample01.dto;

import java.time.Instant;
import java.time.LocalDate;

public record SecretaryHistoryDTO(
    Long id,
    LocalDate startDate,
    LocalDate endDate,
    SecretaryDTO secretaryDTO,
    Long departmentId
)
{ }
