package nst.springboot.restexample01.service.abstraction;

import nst.springboot.restexample01.dto.MemberHistoryDTO;
import nst.springboot.restexample01.service.DomainService;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberHistoryService{
    List<MemberHistoryDTO> getAll(Pageable pageable);
}
