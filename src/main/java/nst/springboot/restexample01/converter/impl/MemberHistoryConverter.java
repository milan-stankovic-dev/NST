package nst.springboot.restexample01.converter.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.impl.MemberHistory;
import nst.springboot.restexample01.dto.MemberDTO;
import nst.springboot.restexample01.dto.MemberHistoryDTO;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberHistoryConverter implements DTOEntityConverter
                                                <MemberHistoryDTO, MemberHistory>{
    private final DepartmentConverter departmentConverter;
    private final MemberConverter memberConverter;
    @Override
    public MemberHistoryDTO toDto(MemberHistory e) {
        return new MemberHistoryDTO(
                e.getId(),
                e.getStartDate(),
                e.getEndDate(),
                e.getRole(),
                departmentConverter
                        .toDto(e.getDepartment()),
                memberConverter
                        .toDto(e.getMember()));
    }

    @Override
    public MemberHistory toEntity(MemberHistoryDTO t) {
        return new MemberHistory(
                t.id(),
                t.startDate(),
                t.endDate(),
                t.role(),
                departmentConverter
                        .toEntity(t.departmentDTO()),
                memberConverter
                        .toEntity(t.memberDTO()));
    }
}
