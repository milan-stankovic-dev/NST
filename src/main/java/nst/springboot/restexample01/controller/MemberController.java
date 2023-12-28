package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.dto.DepartmentChangeMemberDTO;
import nst.springboot.restexample01.dto.MemberDTO;
import nst.springboot.restexample01.dto.AcademicTitleMemberDTO;
import nst.springboot.restexample01.dto.RoleChangeMemberDTO;
import nst.springboot.restexample01.role.MemberRole;
import nst.springboot.restexample01.service.abstraction.MemberService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/paging")
    public ResponseEntity<List<MemberDTO>> getAllPaging(
        @RequestParam(name = "page", defaultValue = "0") int page,
        @RequestParam(name = "pageSize",defaultValue = "3") int pageSize,
        @RequestParam(name = "sortBy", defaultValue = "id") String sortingCriterium,
        @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {

//        final Pageable pageable;
//        if(sortDirection.equalsIgnoreCase("asc")){
//            pageable = PageRequest.of(page, pageSize,
//                    Sort.by(sortingCriterium).ascending());
//        } else {
//            pageable = PageRequest.of(page, pageSize,
//                    Sort.by(sortDirection).descending());
//        }
        final Pageable pageable =
                PageRequest.of(page, pageSize ,
                        switch (sortDirection.toLowerCase()) {
                            case "desc" -> Sort.by(sortingCriterium).descending();
                            default -> Sort.by(sortingCriterium).ascending();
                        });
        System.out.println(pageable);
        return ResponseEntity.ok(memberService.getAll(pageable));
    }

    @GetMapping("/queryById")
    public ResponseEntity<MemberDTO> queryById(@RequestParam("id") Long id) throws Exception {
        return ResponseEntity.ok(memberService.queryById(id));
    }

    @GetMapping("/queryByType")
    public ResponseEntity<List<MemberDTO>> getAllByRole(@RequestParam("role")
                                                        String role) throws Exception{
        return ResponseEntity.ok(memberService.getAllOfType(role));
    }

    @PostMapping("/save-regular")
    public ResponseEntity<MemberDTO> save(@Valid @RequestBody
                                          MemberDTO memberDTO) throws Exception{
        return ResponseEntity.ok(memberService.save(memberDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception{
        memberService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/update-academic-title")
    public ResponseEntity<AcademicTitleMemberDTO>
            updateAcademicTitle(@Valid @RequestBody AcademicTitleMemberDTO academicTitleMemberDTO) throws Exception{

        return ResponseEntity.ok(memberService
                .updateAcademicTitle(academicTitleMemberDTO));
    }

    @PatchMapping("/upgrade-role")
    public ResponseEntity<RoleChangeMemberDTO> updateRole(@Valid @RequestBody
                                                          RoleChangeMemberDTO memberDTO) throws Exception{
        return ResponseEntity.ok(memberService
                .updateRole(memberDTO));
    }

    @PatchMapping("/update-department")
    public ResponseEntity<DepartmentChangeMemberDTO> updateDepartment(
            @Valid @RequestBody DepartmentChangeMemberDTO memberDTO) throws Exception {
        return ResponseEntity.ok(memberService
                .updateDepartment(memberDTO));
    }


}
