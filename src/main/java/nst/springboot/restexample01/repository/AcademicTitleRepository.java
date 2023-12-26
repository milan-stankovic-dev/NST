package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.impl.AcademicTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcademicTitleRepository extends JpaRepository<AcademicTitle, Long> {
    Optional<AcademicTitle> findByTitleName(String academicTitleName);
}
