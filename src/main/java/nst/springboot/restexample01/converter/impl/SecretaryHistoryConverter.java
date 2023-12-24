package nst.springboot.restexample01.converter.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.Department;
import nst.springboot.restexample01.domain.SecretaryHistory;
import nst.springboot.restexample01.dto.SecretaryHistoryDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class SecretaryHistoryConverter implements DTOEntityConverter
                                                    <SecretaryHistoryDTO, SecretaryHistory>{

    private final SecretaryConverter secretaryConverter;
    @Override
    public SecretaryHistoryDTO toDto(SecretaryHistory e) {
        return new SecretaryHistoryDTO(
                e.getId(),
                e.getStartDate(),
                e.getEndDate(),
                secretaryConverter.toDto(e.getSecretary()),
                e.getDepartment() == null? null : e.getDepartment().getId()
        );
    }

    @Override
    public SecretaryHistory toEntity(SecretaryHistoryDTO t) {
        return new SecretaryHistory(
                        t.id(),
                        t.startDate(),
                        t.endDate(),
                secretaryConverter.toEntity(t.secretaryDTO()),
                new Department(t.id(), null, null, null,
                                new ArrayList<>(), null, new ArrayList<>())
                );
    }
}
