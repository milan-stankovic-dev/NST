package nst.springboot.restexample01.converter.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.impl.AcademicTitleHistory;
import nst.springboot.restexample01.domain.impl.Member;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class AcademicTitleHistoryConverter implements DTOEntityConverter
                                                        <AcademicTitleHistoryDTO,
                                                                AcademicTitleHistory>{
    private final AcademicTitleConverter academicTitleConverter;
    private final ScientificFieldConverter scientificFieldConverter;

    @Override
    public AcademicTitleHistoryDTO toDto(AcademicTitleHistory e) {
        return (e == null? null : new AcademicTitleHistoryDTO(
                e.getId(),
                e.getStartDate(),
                e.getEndDate(),
                e.getMember() == null? null : e.getMember().getId(),
                academicTitleConverter.toDto(e.getAcademicTitle()),
                scientificFieldConverter.toDto(e.getScientificField())
                ));
    }

    @Override
    public AcademicTitleHistory toEntity(AcademicTitleHistoryDTO t) {
        return (t == null? null: new AcademicTitleHistory(
                t.id(),
                t.startDate(),
                t.endDate(),
                new Member(
                        t.id(), "DUMMY", "DUMMY", null,
                        null, null,
                        null, new ArrayList<>()),
                academicTitleConverter.toEntity(t.academicTitleDTO()),
                scientificFieldConverter.toEntity(t.scientificFieldDTO())
        ));
    }
}
