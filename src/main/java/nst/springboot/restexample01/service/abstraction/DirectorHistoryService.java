package nst.springboot.restexample01.service.abstraction;

import nst.springboot.restexample01.domain.DirectorHistory;
import nst.springboot.restexample01.dto.DirectorHistoryDTO;
import nst.springboot.restexample01.service.DomainService;

public interface DirectorHistoryService extends DomainService
                                                <DirectorHistoryDTO, Long> { }
