package nst.springboot.restexample01.service.abstraction;

import nst.springboot.restexample01.dto.MemberHistoryDTO;
import nst.springboot.restexample01.service.DomainService;

public interface MemberHistoryService extends
        DomainService<MemberHistoryDTO, Long> { }
