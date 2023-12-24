package nst.springboot.restexample01.service.abstraction;

import nst.springboot.restexample01.dto.DirectorDTO;
import nst.springboot.restexample01.service.DomainService;

public interface DirectorService extends DomainService<DirectorDTO, Long> {
}
