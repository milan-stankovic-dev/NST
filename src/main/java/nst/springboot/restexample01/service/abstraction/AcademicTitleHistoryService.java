package nst.springboot.restexample01.service.abstraction;

import nst.springboot.restexample01.domain.impl.AcademicTitleHistory;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDTO;
import nst.springboot.restexample01.service.DomainService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcademicTitleHistoryService extends
        DomainService<AcademicTitleHistoryDTO, Long> {
    List<AcademicTitleHistoryDTO> historiesForMember(Long memberId);
}
