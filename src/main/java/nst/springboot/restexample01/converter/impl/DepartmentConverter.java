package nst.springboot.restexample01.converter.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.impl.Department;
import nst.springboot.restexample01.dto.DepartmentDTO;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentConverter implements DTOEntityConverter<DepartmentDTO, Department> {
    @Override
    public DepartmentDTO toDto(Department entity) {
        return (entity == null? null : new DepartmentDTO(
                entity.getId(),
                entity.getName(),
                entity.getShortName()
        ));
    }

    @Override
    public Department toEntity(DepartmentDTO dto) {
        return (dto == null? null : new Department(
                dto.id(),
                dto.name(),
                dto.shortName()));
    }
    
}
