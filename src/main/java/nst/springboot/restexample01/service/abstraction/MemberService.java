package nst.springboot.restexample01.service.abstraction;

import nst.springboot.restexample01.dto.DepartmentChangeMemberDTO;
import nst.springboot.restexample01.dto.MemberDTO;
import nst.springboot.restexample01.dto.AcademicTitleMemberDTO;
import nst.springboot.restexample01.dto.RoleChangeMemberDTO;
import nst.springboot.restexample01.service.DomainService;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberService extends DomainService<MemberDTO, Long> {
    AcademicTitleMemberDTO updateAcademicTitle(AcademicTitleMemberDTO member) throws Exception;

    RoleChangeMemberDTO updateRole(RoleChangeMemberDTO memberDTO) throws Exception;

    MemberDTO queryById(Long id) throws Exception;

    List<MemberDTO> getAllOfType(String type) throws Exception;

    List<MemberDTO> getAll(Pageable pageable);

    DepartmentChangeMemberDTO updateDepartment(DepartmentChangeMemberDTO memberDTO) throws Exception;
}
