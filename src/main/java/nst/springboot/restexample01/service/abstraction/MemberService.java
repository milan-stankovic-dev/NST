package nst.springboot.restexample01.service.abstraction;

import nst.springboot.restexample01.dto.MemberDTO;
import nst.springboot.restexample01.dto.MinimalMemberDTO;
import nst.springboot.restexample01.service.DomainService;

public interface MemberService extends DomainService<MemberDTO, Long> {
    MinimalMemberDTO updateAcademicTitle(MinimalMemberDTO member) throws Exception;
}