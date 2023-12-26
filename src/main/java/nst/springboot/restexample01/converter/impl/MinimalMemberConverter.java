package nst.springboot.restexample01.converter.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.impl.Member;
import nst.springboot.restexample01.dto.MemberDTO;
import nst.springboot.restexample01.dto.MinimalMemberDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class MinimalMemberConverter implements
        DTOEntityConverter<MinimalMemberDTO, Member> {
    private final AcademicTitleConverter academicTitleConverter;
    private final ScientificFieldConverter scientificFieldConverter;

    @Override
    public MinimalMemberDTO toDto(Member e) {
        return (e == null ? null : new MinimalMemberDTO(
                e.getId(),
                e.getStartDate(),
                academicTitleConverter.toDto(e.getAcademicTitle()),
                scientificFieldConverter.toDto(e.getScientificField())
        ));
    }

    @Override
    public Member toEntity(MinimalMemberDTO t) {
        return (t == null ? null : new Member(
                t.id(),
                "DUMMY", "DUMMY",
                t.startDate(),
                null,
                academicTitleConverter.toEntity(t.academicTitleDTO()),
                null,
                scientificFieldConverter.toEntity(t.scientificFieldDTO())
                , new ArrayList<>()
        ));
    }
}
