package nst.springboot.restexample01.dto;

import java.time.Instant;
import java.time.LocalDate;

public record DirectorHistoryDTO(
        Long id,
        LocalDate startDate,
        LocalDate endDate,
        DirectorDTO directorDTO,
        Long departmentId
)
{ }
