package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.impl.Department;
import nst.springboot.restexample01.domain.impl.Secretary;
import nst.springboot.restexample01.dto.SecretaryDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SecretaryConverter implements DTOEntityConverter
                                            <SecretaryDTO, Secretary> {
    @Override
    public SecretaryDTO toDto(Secretary e) {
        return (e == null ? null : new SecretaryDTO(e.getId(), e.getStartDate(),
                e.getFirstName(), e.getLastName(),
                e.getDepartment() == null? null : e.getDepartment().getId()));
    }

    @Override
    public Secretary toEntity(SecretaryDTO t) {
        return (t == null ? null : new Secretary(
                t.id(), t.startDate(), t.firstName(), t.lastName(),
                new Department(t.id(), "DUMMY", "DUMMY", null,
                        new ArrayList<>(), null, new ArrayList<>())

        ));
    }
}
