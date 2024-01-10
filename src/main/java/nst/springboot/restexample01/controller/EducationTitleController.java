package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.dto.EducationTitleDTO;
import nst.springboot.restexample01.service.abstraction.EducationTitleService;
import nst.springboot.restexample01.util.PaginationUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/education-title")
public class EducationTitleController {
    private final EducationTitleService educationTitleService;
    private final PaginationUtil paginationUtil;

    @PostMapping("/save")
    public ResponseEntity<EducationTitleDTO> save(@Valid @RequestBody
                                                  EducationTitleDTO educationTitleDTO) throws Exception{
        final var educationTitleFromServiceDTO =
                educationTitleService.save(educationTitleDTO);
        return ResponseEntity.ok(educationTitleFromServiceDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception{
        educationTitleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all/pageable")
    public ResponseEntity<List<EducationTitleDTO>> getAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "pageSize", defaultValue = "3") int pageSize,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortingCriterium,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortingDirection
    ){
        final Pageable pageable =
                paginationUtil.createPageable(page, pageSize,
                        sortingCriterium, sortingDirection);

        return ResponseEntity.ok(educationTitleService.getAll(pageable));
    }
}
