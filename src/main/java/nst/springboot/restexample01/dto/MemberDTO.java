package nst.springboot.restexample01.dto;

import nst.springboot.restexample01.role.MemberRole;

import java.time.LocalDate;
import java.util.List;

public record MemberDTO(
        Long id,
        String firstName,
        String lastName,
        LocalDate startDate,
        MemberRole role,
        DepartmentDTO departmentDTO,
        AcademicTitleDTO academicTitleDTO,
        EducationTitleDTO educationTitleDTO,
        ScientificFieldDTO scientificFieldDTO,
        List<AcademicTitleHistoryDTO> histories

) { }
