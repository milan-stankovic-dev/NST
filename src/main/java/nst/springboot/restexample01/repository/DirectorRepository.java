package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
}
