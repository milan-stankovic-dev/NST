package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.AcademicTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicTitleRepository extends JpaRepository<AcademicTitle, Long> {
}
