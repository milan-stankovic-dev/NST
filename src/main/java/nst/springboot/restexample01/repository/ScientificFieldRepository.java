package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.ScientificField;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScientificFieldRepository extends JpaRepository<ScientificField, Long> {
}
