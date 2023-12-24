package nst.springboot.restexample01.converter.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.Member;
import nst.springboot.restexample01.dto.MemberDTO;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberConverter implements DTOEntityConverter<MemberDTO, Member> {

    private final AcademicTitleConverter academicTitleConverter;
    private final EducationTitleConverter educationTitleConverter;
    private final ScientificFieldConverter scientificFieldConverter;
    private final AcademicTitleHistoryConverter academicTitleHistoryConverter;
    @Override
    public MemberDTO toDto(Member e) {
        return new MemberDTO(
                e.getId(),
                e.getFirstName(),
                e.getLastName(),
                academicTitleConverter.toDto(e.getAcademicTitle()),
                educationTitleConverter.toDto(e.getEducationTitle()),
                scientificFieldConverter.toDto(e.getScientificField()),
                academicTitleHistoryConverter.listToDto(e.getHistories())
        );
    }

    @Override
    public Member toEntity(MemberDTO t) {
        return new Member(
                t.id(),
                t.firstName(),
                t.lastName(),
                academicTitleConverter.toEntity(t.academicTitleDTO()),
                educationTitleConverter.toEntity(t.educationTitleDTO()),
                scientificFieldConverter.toEntity(t.scientificFieldDTO()),
                academicTitleHistoryConverter.listToEntity(t.histories())
        );
    }
}
