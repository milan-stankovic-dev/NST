package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.domain.Department;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.DepartmentDTO;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverter implements DtoEntityConverter<DepartmentDTO, Department>{

    @Override
    public DepartmentDTO toDto(Department entity) {
        return new DepartmentDTO(
                entity.getId(),
                entity.getName(),
                entity.getShortName(),
                entity.getSecretary(),
                entity.getSecretaryHistories(),
                entity.getDirector(),
                entity.getDirectorHistories()
        );
    }

    @Override
    public Department toEntity(DepartmentDTO dto) {
        return new Department(
                dto.id(),
                dto.name(),
                dto.shortName(),
                dto.secretary(),
                dto.secretaryHistories(),
                dto.director(),
                dto.directorHistories());
    }
    
}
