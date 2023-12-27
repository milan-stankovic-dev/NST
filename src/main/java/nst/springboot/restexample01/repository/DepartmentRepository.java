package nst.springboot.restexample01.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import nst.springboot.restexample01.domain.impl.Department;
import nst.springboot.restexample01.domain.impl.Member;
import nst.springboot.restexample01.role.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department, Long>{
    //vrati depratment na osnovu imena
    Optional<Department> findByName(String name);

}
