package nst.springboot.restexample01.converter.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.impl.Member;
import nst.springboot.restexample01.dto.AcademicTitleMemberDTO;
import nst.springboot.restexample01.role.MemberRole;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class AcademicTitleMemberDTOConverter implements
        DTOEntityConverter<AcademicTitleMemberDTO, Member> {
    private final AcademicTitleConverter academicTitleConverter;
    private final ScientificFieldConverter scientificFieldConverter;

    @Override
    public AcademicTitleMemberDTO toDto(Member e) {
        return (e == null ? null : new AcademicTitleMemberDTO(
                e.getId(),
                e.getStartDate(),
                academicTitleConverter.toDto(e.getAcademicTitle()),
                scientificFieldConverter.toDto(e.getScientificField())
        ));
    }

    @Override
    public Member toEntity(AcademicTitleMemberDTO t) {
        return (t == null ? null : new Member(
                t.id(),
                "DUMMY", "DUMMY", MemberRole.REGULAR,
                t.startDate(),
                null,
                academicTitleConverter.toEntity(t.academicTitleDTO()),
                null,
                scientificFieldConverter.toEntity(t.scientificFieldDTO())
                , new ArrayList<>()
        ));
    }
}
