package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.impl.AcademicTitleHistory;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicTitleHistoryRepository extends JpaRepository
                            <AcademicTitleHistory, Long> {
}
