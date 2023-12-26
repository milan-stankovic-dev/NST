package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.impl.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByFirstNameAndLastName(String firstName, String lastName);
}
