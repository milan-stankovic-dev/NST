package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.impl.MemberHistory;
import nst.springboot.restexample01.role.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberHistoryRepository
        extends JpaRepository<MemberHistory, Long> {
    @Query("SELECT e FROM MemberHistory e WHERE e.role = :value")
    List<MemberHistory> findAllByType(@Param("value") MemberRole memberRole);
}
