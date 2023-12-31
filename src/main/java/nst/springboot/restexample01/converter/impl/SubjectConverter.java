package nst.springboot.restexample01.converter.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.impl.Subject;
import nst.springboot.restexample01.dto.SubjectDTO;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectConverter implements DTOEntityConverter<SubjectDTO, Subject> {
    private final DepartmentConverter departmentConverter;
    
    @Override
    public SubjectDTO toDto(Subject entity) {
        return (entity == null ? null : new SubjectDTO(
                entity.getId(), 
                entity.getName(),
                entity.getEspb(),
                departmentConverter.toDto(entity.getDepartment())
        ));
    }

    @Override
    public Subject toEntity(SubjectDTO dto) {
        return (dto == null ? null : new Subject(
                dto.id(),
                dto.name(),
                dto.espb(),
        departmentConverter.toEntity(dto.departmentDTO())));
    }
    
}
