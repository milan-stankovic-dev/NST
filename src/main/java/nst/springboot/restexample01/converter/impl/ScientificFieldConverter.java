package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.ScientificField;
import nst.springboot.restexample01.dto.ScientificFieldDTO;
import org.springframework.stereotype.Component;

@Component
public class ScientificFieldConverter implements DTOEntityConverter
        <ScientificFieldDTO, ScientificField> {

    @Override
    public ScientificFieldDTO toDto(ScientificField e) {
        return new ScientificFieldDTO(e.getId(),e.getFieldName());
    }

    @Override
    public ScientificField toEntity(ScientificFieldDTO t) {
        return new ScientificField(t.id(), t.fieldName());
    }
}
