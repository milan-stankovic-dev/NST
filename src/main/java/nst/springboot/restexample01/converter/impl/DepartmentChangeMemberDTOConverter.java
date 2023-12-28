package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.impl.Department;
import nst.springboot.restexample01.domain.impl.Member;
import nst.springboot.restexample01.dto.DepartmentChangeMemberDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentChangeMemberDTOConverter implements
        DTOEntityConverter<DepartmentChangeMemberDTO, Member> {
    @Override
    public DepartmentChangeMemberDTO toDto(Member e) {
        return (e == null ? null : new DepartmentChangeMemberDTO(
           e.getId(), (e.getDepartment() == null? null : e.getDepartment().getId())
        ));
    }

    @Override
    public Member toEntity(DepartmentChangeMemberDTO t) {
        final var department = new Department();
        department.setId(t.newDepartmentId());

        return (t == null ? null : new Member(
                t.id(), "DUMMY", "DUMMY", null,
                null, department, null, null,
                null, new ArrayList<>()
        ));
    }

}
