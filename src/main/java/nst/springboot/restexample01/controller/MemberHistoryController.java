package nst.springboot.restexample01.controller;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.dto.MemberHistoryDTO;
import nst.springboot.restexample01.service.abstraction.MemberHistoryService;
import nst.springboot.restexample01.util.PaginationUtil;
import org.springframework.data.domain.Page;
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
@RequestMapping("/member-history")
public class MemberHistoryController {
    private final MemberHistoryService memberHistoryService;
    private final PaginationUtil paginationUtil;

    @GetMapping("/all/paging")
    public ResponseEntity<List<MemberHistoryDTO>> findAllPaging(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "pageSize", defaultValue = "3") int pageSize,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortingCriterium,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection){

        final Pageable pageable =
                paginationUtil.createPageable(page, pageSize,
                        sortingCriterium, sortDirection);

        return ResponseEntity.ok(memberHistoryService.getAll(pageable));
    }

    @GetMapping("/queryByType")
    public ResponseEntity<List<MemberHistoryDTO>> findByType(
            @RequestParam String memberRole) throws Exception {

        return ResponseEntity.ok(memberHistoryService.getAll(memberRole));
    }

}
