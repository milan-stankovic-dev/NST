package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.impl.MemberHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberHistoryRepository
        extends JpaRepository<MemberHistory, Long> { }
