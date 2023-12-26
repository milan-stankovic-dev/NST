package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.dto.AcademicTitleDTO;
import nst.springboot.restexample01.dto.MemberDTO;
import nst.springboot.restexample01.dto.MinimalMemberDTO;
import nst.springboot.restexample01.service.abstraction.MemberService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAll(){
        return ResponseEntity.ok(memberService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception{
        memberService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<MemberDTO> save(@Valid @RequestBody
                                              MemberDTO memberDTO) throws Exception{
        return ResponseEntity.ok(memberService.save(memberDTO));
    }

    @PatchMapping
    public ResponseEntity<MinimalMemberDTO>
            updateAcademicTitle(@Valid @RequestBody MinimalMemberDTO minimalMemberDTO) throws Exception{

        return ResponseEntity.ok(memberService
                .updateAcademicTitle(minimalMemberDTO));
    }
}
