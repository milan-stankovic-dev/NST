package nst.springboot.restexample01.dto;

import nst.springboot.restexample01.role.MemberRole;

public record RoleChangeMemberDTO(
        Long id,
        MemberRole newRole
)
{ }
