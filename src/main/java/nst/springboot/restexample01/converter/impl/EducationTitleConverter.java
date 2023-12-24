package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.EducationTitle;
import nst.springboot.restexample01.dto.EducationTitleDTO;
import org.springframework.stereotype.Component;

@Component
public class EducationTitleConverter implements DTOEntityConverter
                                                <EducationTitleDTO, EducationTitle>{
    @Override
    public EducationTitleDTO toDto(EducationTitle e) {
        return new EducationTitleDTO(e.getId(),e.getTitleName());
    }

    @Override
    public EducationTitle toEntity(EducationTitleDTO t) {
        return new EducationTitle(t.id(), t.titleName());
    }
}
