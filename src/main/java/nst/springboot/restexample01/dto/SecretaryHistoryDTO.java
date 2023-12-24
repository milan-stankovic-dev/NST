package nst.springboot.restexample01.dto;

import java.time.Instant;

public record SecretaryHistoryDTO(
    Long id,
    Instant startDate,
    Instant endDate,
    SecretaryDTO secretaryDTO,
    Long departmentId
)
{ }
