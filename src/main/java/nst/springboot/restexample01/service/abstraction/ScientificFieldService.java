package nst.springboot.restexample01.service.abstraction;

import nst.springboot.restexample01.domain.ScientificField;
import nst.springboot.restexample01.dto.ScientificFieldDTO;
import nst.springboot.restexample01.service.DomainService;

public interface ScientificFieldService
        extends DomainService<ScientificFieldDTO, Long> {
}
