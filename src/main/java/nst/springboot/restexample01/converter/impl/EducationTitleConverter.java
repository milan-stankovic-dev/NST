package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.impl.EducationTitle;
import nst.springboot.restexample01.dto.EducationTitleDTO;
import org.springframework.stereotype.Component;

@Component
public class EducationTitleConverter implements DTOEntityConverter
                                                <EducationTitleDTO, EducationTitle>{
    @Override
    public EducationTitleDTO toDto(EducationTitle e) {
        return (e == null ? null : new EducationTitleDTO(e.getId(),e.getTitleName()));
    }

    @Override
    public EducationTitle toEntity(EducationTitleDTO t) {
        return (t == null ? null : new EducationTitle(t.id(), t.titleName()));
    }
}
