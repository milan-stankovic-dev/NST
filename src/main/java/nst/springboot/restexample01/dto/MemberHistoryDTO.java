package nst.springboot.restexample01.dto;

import nst.springboot.restexample01.role.MemberRole;

import java.time.LocalDate;

public record MemberHistoryDTO(
        Long id,
        LocalDate startDate,
        LocalDate endDate,
        MemberRole role,
        DepartmentDTO departmentDTO,
        MemberDTO memberDTO
) { }
