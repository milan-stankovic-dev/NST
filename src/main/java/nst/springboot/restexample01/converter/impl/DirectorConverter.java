package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.Department;
import nst.springboot.restexample01.domain.Director;
import nst.springboot.restexample01.dto.DirectorDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DirectorConverter implements DTOEntityConverter
                                            <DirectorDTO, Director>{
    @Override
    public DirectorDTO toDto(Director e) {
        return new DirectorDTO(e.getId(), e.getStartDate(),
                e.getFirstName(), e.getLastName(),
                e.getDepartment() == null? null : e.getDepartment().getId());
    }

    @Override
    public Director toEntity(DirectorDTO t) {
        return new Director(
          t.id(), t.startDate(), t.firstName(), t.lastName(),
                new Department(t.id(), null, null, null,
                        new ArrayList<>(), null, new ArrayList<>())

        );
    }
}
