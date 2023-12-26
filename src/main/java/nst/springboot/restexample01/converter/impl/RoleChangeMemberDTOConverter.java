package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.converter.DTOEntityConverter;
import nst.springboot.restexample01.domain.impl.Member;
import nst.springboot.restexample01.dto.RoleChangeMemberDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RoleChangeMemberDTOConverter implements
        DTOEntityConverter<RoleChangeMemberDTO, Member> {
    @Override
    public RoleChangeMemberDTO toDto(Member e) {
        return new RoleChangeMemberDTO(
                e.getId(),
                e.getRole()
        );
    }

    @Override
    public Member toEntity(RoleChangeMemberDTO t) {
        return new Member(
                t.id(),
                "DUMMY", "DUMMY",
                t.newRole(),
                null, null, null,
                null, null,
                new ArrayList<>());
    }
}
