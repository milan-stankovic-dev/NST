package nst.springboot.restexample01.dto;

import java.time.Instant;

public record AcademicTitleHistoryDTO(
    Long id,
    Instant startDate,
    Instant endDate,
    Long memberId,
    AcademicTitleDTO academicTitleDTO,
    ScientificFieldDTO scientificFieldDTO
) { }
