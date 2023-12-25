package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.impl.DirectorHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorHistoryRepository extends
        JpaRepository<DirectorHistory, Long> { }
