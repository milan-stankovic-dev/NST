package nst.springboot.restexample01.dto;

import java.time.Instant;
import java.time.LocalDate;

public record AcademicTitleHistoryDTO(
    Long id,
    LocalDate startDate,
    LocalDate endDate,
    Long memberId,
    AcademicTitleDTO academicTitleDTO,
    ScientificFieldDTO scientificFieldDTO
) { }
