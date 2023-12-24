package nst.springboot.restexample01.dto;

import java.time.Instant;

public record DirectorHistoryDTO(
        Long id,
        Instant startDate,
        Instant endDate,
        DirectorDTO directorDTO,
        Long departmentId
)
{ }
