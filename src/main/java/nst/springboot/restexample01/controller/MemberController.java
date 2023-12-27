package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.dto.MemberDTO;
import nst.springboot.restexample01.dto.AcademicTitleMemberDTO;
import nst.springboot.restexample01.dto.RoleChangeMemberDTO;
import nst.springboot.restexample01.service.abstraction.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/all")
    public ResponseEntity<List<MemberDTO>> getAll(){
        return ResponseEntity.ok(memberService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception{
        memberService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/query")
    public ResponseEntity<MemberDTO> queryById(@RequestParam("id") Long id) throws Exception {
        return ResponseEntity.ok(memberService.queryById(id));
    }

    @PostMapping("/save-regular")
    public ResponseEntity<MemberDTO> save(@Valid @RequestBody
                                              MemberDTO memberDTO) throws Exception{
        return ResponseEntity.ok(memberService.save(memberDTO));
    }

    @PatchMapping("/update-academic-title")
    public ResponseEntity<AcademicTitleMemberDTO>
            updateAcademicTitle(@Valid @RequestBody AcademicTitleMemberDTO academicTitleMemberDTO) throws Exception{

        return ResponseEntity.ok(memberService
                .updateAcademicTitle(academicTitleMemberDTO));
    }

    @PatchMapping("/update-role")
    public ResponseEntity<RoleChangeMemberDTO> updateRole(@Valid @RequestBody
                                                          RoleChangeMemberDTO memberDTO) throws Exception{
        return ResponseEntity.ok(memberService
                .updateRole(memberDTO));
    }
}
