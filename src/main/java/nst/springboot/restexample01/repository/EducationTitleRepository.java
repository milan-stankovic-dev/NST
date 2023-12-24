package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.EducationTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationTitleRepository extends JpaRepository<EducationTitle, Long> {
}
