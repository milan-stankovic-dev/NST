package nst.springboot.restexample01.dto;

import java.time.LocalDate;

public record MinimalMemberDTO(
    Long id,
    LocalDate startDate,
    AcademicTitleDTO academicTitleDTO,
    ScientificFieldDTO scientificFieldDTO
) { }
