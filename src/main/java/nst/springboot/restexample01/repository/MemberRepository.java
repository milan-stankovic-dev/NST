package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.impl.Member;
import nst.springboot.restexample01.role.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByFirstNameAndLastName(String firstName, String lastName);
}
