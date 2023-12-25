package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.impl.SecretaryHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretaryHistoryRepository extends JpaRepository<SecretaryHistory, Long> {
}
