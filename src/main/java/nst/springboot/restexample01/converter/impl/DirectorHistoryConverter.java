package nst.springboot.restexample01.converter.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.impl.Department;
import nst.springboot.restexample01.domain.impl.DirectorHistory;
import nst.springboot.restexample01.dto.DirectorHistoryDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class DirectorHistoryConverter implements DTOEntityConverter
                                                    <DirectorHistoryDTO, DirectorHistory>{

    private final DirectorConverter directorConverter;
    @Override
    public DirectorHistoryDTO toDto(DirectorHistory e) {
        return (e == null ? null : new DirectorHistoryDTO(
                e.getId(),
                e.getStartDate(),
                e.getEndDate(),
                directorConverter.toDto(e.getDirector()),
                e.getDepartment() == null? null : e.getDepartment().getId()
        ));
    }

    @Override
    public DirectorHistory toEntity(DirectorHistoryDTO t) {
        return (t == null ? null : new DirectorHistory(
                        t.id(),
                        t.startDate(),
                        t.endDate(),
                new Department(t.id(), "DUMMY", "DUMMY", null,
                                new ArrayList<>(), null, new ArrayList<>()),
                directorConverter.toEntity(t.directorDTO())
                ));
    }
}
