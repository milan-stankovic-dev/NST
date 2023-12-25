package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.impl.ScientificField;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScientificFieldRepository extends JpaRepository<ScientificField, Long> {
}
