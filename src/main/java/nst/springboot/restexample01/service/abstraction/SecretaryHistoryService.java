package nst.springboot.restexample01.service.abstraction;

import nst.springboot.restexample01.dto.SecretaryHistoryDTO;
import nst.springboot.restexample01.service.DomainService;

public interface SecretaryHistoryService extends DomainService<SecretaryHistoryDTO, Long> { }
