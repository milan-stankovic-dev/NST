package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.impl.ScientificField;
import nst.springboot.restexample01.dto.ScientificFieldDTO;
import org.springframework.stereotype.Component;

@Component
public class ScientificFieldConverter implements DTOEntityConverter
        <ScientificFieldDTO, ScientificField> {

    @Override
    public ScientificFieldDTO toDto(ScientificField e) {
        return (e == null ? null : new ScientificFieldDTO(e.getId(),e.getFieldName()));
    }

    @Override
    public ScientificField toEntity(ScientificFieldDTO t) {
        return (t == null ? null : new ScientificField(t.id(), t.fieldName()));
    }
}
