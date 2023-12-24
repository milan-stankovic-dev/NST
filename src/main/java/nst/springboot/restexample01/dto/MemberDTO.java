package nst.springboot.restexample01.dto;

import java.util.List;

public record MemberDTO(
        Long id,
        String firstName,
        String lastName,
        AcademicTitleDTO academicTitleDTO,
        EducationTitleDTO educationTitleDTO,
        ScientificFieldDTO scientificFieldDTO,
        List<AcademicTitleHistoryDTO> histories
) { }
