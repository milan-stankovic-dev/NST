package nst.springboot.restexample01.service.abstraction;

import jakarta.validation.Valid;
import nst.springboot.restexample01.dto.EducationTitleDTO;
import nst.springboot.restexample01.service.DomainService;

public interface EducationTitleService
        extends DomainService<EducationTitleDTO, Long> { }
