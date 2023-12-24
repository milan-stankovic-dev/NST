package nst.springboot.restexample01.service.abstraction;

import nst.springboot.restexample01.dto.AcademicTitleDTO;
import nst.springboot.restexample01.service.DomainService;

public interface AcademicTitleService extends
        DomainService<AcademicTitleDTO, Long> {
}
