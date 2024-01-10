package nst.springboot.restexample01.controller;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.domain.impl.AcademicTitleHistory;
import nst.springboot.restexample01.dto.AcademicTitleDTO;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDTO;
import nst.springboot.restexample01.service.abstraction.AcademicTitleHistoryService;
import nst.springboot.restexample01.service.abstraction.AcademicTitleService;
import nst.springboot.restexample01.util.PaginationUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/academic-title-history")
public class AcademicTitleHistoryController {
    private final AcademicTitleHistoryService academicTitleHistoryService;
    private final PaginationUtil paginationUtil;

    @GetMapping("/all/pageable")
    public ResponseEntity<List<AcademicTitleHistoryDTO>> getAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "pageSize",defaultValue = "3") int pageSize,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortingCriterium,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection
    ){
        final Pageable pageable =
                paginationUtil.createPageable(page, pageSize,
                        sortingCriterium, sortDirection);

        return ResponseEntity.ok(academicTitleHistoryService
                .getAll(pageable));
    }

    @GetMapping("/query")
    public ResponseEntity<List<AcademicTitleHistoryDTO>> allHistoriesForMember(
            @RequestParam("member-id") Long memberId) {
        return ResponseEntity.ok(academicTitleHistoryService
                .historiesForMember(memberId));
    }
}
