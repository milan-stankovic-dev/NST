package nst.springboot.restexample01.dto;

import java.time.LocalDate;
import java.util.List;

public record MemberDTO(
        Long id,
        String firstName,
        String lastName,
        LocalDate startDate,
        DepartmentDTO departmentDTO,
        AcademicTitleDTO academicTitleDTO,
        EducationTitleDTO educationTitleDTO,
        ScientificFieldDTO scientificFieldDTO,
        List<AcademicTitleHistoryDTO> histories

) { }
