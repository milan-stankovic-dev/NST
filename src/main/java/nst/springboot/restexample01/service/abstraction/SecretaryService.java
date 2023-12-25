package nst.springboot.restexample01.service.abstraction;

import nst.springboot.restexample01.dto.SecretaryDTO;
import nst.springboot.restexample01.service.DomainService;

public interface SecretaryService extends DomainService<SecretaryDTO, Long> {
}
