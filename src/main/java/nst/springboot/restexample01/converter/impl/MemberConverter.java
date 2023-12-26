package nst.springboot.restexample01.converter.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.impl.Member;
import nst.springboot.restexample01.dto.MemberDTO;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberConverter implements DTOEntityConverter<MemberDTO, Member> {

    private final AcademicTitleConverter academicTitleConverter;
    private final EducationTitleConverter educationTitleConverter;
    private final ScientificFieldConverter scientificFieldConverter;
    private final AcademicTitleHistoryConverter academicTitleHistoryConverter;
    private final DepartmentConverter departmentConverter;
    @Override
    public MemberDTO toDto(Member e) {
        return (e == null ? null : new MemberDTO(
                e.getId(),
                e.getFirstName(),
                e.getLastName(),
                e.getStartDate(),
                e.getRole(),
                departmentConverter.toDto(e.getDepartment()),
                academicTitleConverter.toDto(e.getAcademicTitle()),
                educationTitleConverter.toDto(e.getEducationTitle()),
                scientificFieldConverter.toDto(e.getScientificField()),
                academicTitleHistoryConverter.listToDto(e.getHistories())
        ));
    }

    @Override
    public Member toEntity(MemberDTO t) {
        return (t == null ? null : new Member(
                t.id(),
                t.firstName(),
                t.lastName(),
                t.role(),
                t.startDate(),
                departmentConverter.toEntity(t.departmentDTO()),
                academicTitleConverter.toEntity(t.academicTitleDTO()),
                educationTitleConverter.toEntity(t.educationTitleDTO()),
                scientificFieldConverter.toEntity(t.scientificFieldDTO()),
                academicTitleHistoryConverter.listToEntity(t.histories())
        ));
    }
}
