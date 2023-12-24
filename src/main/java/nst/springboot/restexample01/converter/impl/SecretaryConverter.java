package nst.springboot.restexample01.converter.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.Department;
import nst.springboot.restexample01.domain.Secretary;
import nst.springboot.restexample01.dto.DirectorDTO;
import nst.springboot.restexample01.dto.SecretaryDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SecretaryConverter implements DTOEntityConverter
                                            <SecretaryDTO, Secretary> {
    @Override
    public SecretaryDTO toDto(Secretary e) {
        return new SecretaryDTO(e.getId(), e.getStartDate(),
                e.getFirstName(), e.getLastName(),
                e.getDepartment() == null? null : e.getDepartment().getId());
    }

    @Override
    public Secretary toEntity(SecretaryDTO t) {
        return new Secretary(
                t.id(), t.startDate(), t.firstName(), t.lastName(),
                new Department(t.id(), null, null, null,
                        new ArrayList<>(), null, new ArrayList<>())

        );
    }
}
