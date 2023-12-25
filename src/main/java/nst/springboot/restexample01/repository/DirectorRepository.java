package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.impl.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    Optional<Director> findByFirstNameAndLastName(String firstName, String lastName);
}
