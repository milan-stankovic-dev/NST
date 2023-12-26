package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.impl.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretaryRepository extends JpaRepository<Secretary, Long> { }
