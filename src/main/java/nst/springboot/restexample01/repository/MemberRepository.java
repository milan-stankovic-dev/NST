package nst.springboot.restexample01.repository;

import nst.springboot.restexample01.domain.impl.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
