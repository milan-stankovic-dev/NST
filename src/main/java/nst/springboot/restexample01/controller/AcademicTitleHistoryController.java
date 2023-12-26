package nst.springboot.restexample01.controller;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.domain.impl.AcademicTitleHistory;
import nst.springboot.restexample01.dto.AcademicTitleDTO;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDTO;
import nst.springboot.restexample01.service.abstraction.AcademicTitleHistoryService;
import nst.springboot.restexample01.service.abstraction.AcademicTitleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("academic-title-history")
public class AcademicTitleHistoryController {
    private final AcademicTitleHistoryService academicTitleHistoryService;
    @GetMapping
    public ResponseEntity<List<AcademicTitleHistoryDTO>> getAll(){
        return ResponseEntity.ok(academicTitleHistoryService.getAll());
    }

    @GetMapping("/query")
    public ResponseEntity<List<AcademicTitleHistoryDTO>> allHistoriesForMember(
            @RequestParam("member-id") Long memberId) {
        return ResponseEntity.ok(academicTitleHistoryService
                .historiesForMember(memberId));
    }
}
