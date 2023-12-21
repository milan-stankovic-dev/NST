/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.controller.domain.Department;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.DepartmentDTO;
import org.springframework.stereotype.Component;

/**
 *
 * @author student2
 */

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
