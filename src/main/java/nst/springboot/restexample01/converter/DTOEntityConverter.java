package nst.springboot.restexample01.converter;

import java.util.List;

public interface DTOEntityConverter<DTO, ENTITY> {
    DTO toDto(ENTITY e);
    ENTITY toEntity(DTO t);
    default List<ENTITY> listToEntity(List<DTO> dtos){
        return dtos.stream().map(this::toEntity).toList();
    }
    default List<DTO> listToDto(List<ENTITY> entities){
        return entities.stream().map(this::toDto).toList();
    }
}
