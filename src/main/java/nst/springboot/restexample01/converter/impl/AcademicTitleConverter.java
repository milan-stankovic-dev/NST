package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.impl.AcademicTitle;
import nst.springboot.restexample01.dto.AcademicTitleDTO;
import org.springframework.stereotype.Component;

@Component
public class AcademicTitleConverter implements DTOEntityConverter
                                                <AcademicTitleDTO, AcademicTitle>{
    @Override
    public AcademicTitleDTO toDto(AcademicTitle e) {
        return (e == null? null : new AcademicTitleDTO(e.getId(),e.getTitleName()));
    }

    @Override
    public AcademicTitle toEntity(AcademicTitleDTO t) {
        return (t == null ? null : new AcademicTitle(t.id(), t.titleName()));
    }
}
