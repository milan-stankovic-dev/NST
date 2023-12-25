package nst.springboot.restexample01.converter.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.impl.Department;
import nst.springboot.restexample01.dto.DepartmentDTO;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentConverter implements DTOEntityConverter<DepartmentDTO, Department> {

    private final SecretaryConverter secretaryConverter;
    private final DirectorConverter directorConverter;
    private final SecretaryHistoryConverter secretaryHistoryConverter;
    private final DirectorHistoryConverter directorHistoryConverter;

    @Override
    public DepartmentDTO toDto(Department entity) {
        return (entity == null? null : new DepartmentDTO(
                entity.getId(),
                entity.getName(),
                entity.getShortName(),
                secretaryConverter.toDto(
                        entity.getSecretary()),
                secretaryHistoryConverter.listToDto(
                        entity.getSecretaryHistories()
                ),
                directorConverter.toDto(
                        entity.getDirector()
                ),
                directorHistoryConverter.listToDto(
                        entity.getDirectorHistories()
                )
        ));
    }

    @Override
    public Department toEntity(DepartmentDTO dto) {
        return (dto == null? null : new Department(
                dto.id(),
                dto.name(),
                dto.shortName(),
                secretaryConverter.toEntity(
                        dto.secretaryDTO()
                ),
                secretaryHistoryConverter.listToEntity(
                        dto.secretaryHistories()
                ),
                directorConverter.toEntity(
                        dto.directorDTO()
                ),
                directorHistoryConverter.listToEntity(
                        dto.directorHistories()
                )));
    }
    
}
