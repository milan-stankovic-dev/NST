package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.impl.ScientificField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScientificFieldRepository extends JpaRepository<ScientificField, Long> {
    Optional<ScientificField> findByFieldName(String scientificFieldName);
}
