package nst.springboot.restexample01.service.abstraction;

import nst.springboot.restexample01.dto.MemberDTO;
import nst.springboot.restexample01.dto.AcademicTitleMemberDTO;
import nst.springboot.restexample01.dto.RoleChangeMemberDTO;
import nst.springboot.restexample01.service.DomainService;

public interface MemberService extends DomainService<MemberDTO, Long> {
    AcademicTitleMemberDTO updateAcademicTitle(AcademicTitleMemberDTO member) throws Exception;

    RoleChangeMemberDTO updateRole(RoleChangeMemberDTO memberDTO);
}
