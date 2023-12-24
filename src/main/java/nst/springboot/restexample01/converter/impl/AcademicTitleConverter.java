package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.AcademicTitle;
import nst.springboot.restexample01.dto.AcademicTitleDTO;
import org.springframework.stereotype.Component;

@Component
public class AcademicTitleConverter implements DTOEntityConverter
                                                <AcademicTitleDTO, AcademicTitle>{
    @Override
    public AcademicTitleDTO toDto(AcademicTitle e) {
        return new AcademicTitleDTO(e.getId(),e.getTitleName());
    }

    @Override
    public AcademicTitle toEntity(AcademicTitleDTO t) {
        return new AcademicTitle(t.id(),t.titleName());
    }
}
