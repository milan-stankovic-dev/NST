package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.dto.AcademicTitleDTO;
import nst.springboot.restexample01.service.abstraction.AcademicTitleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/academic-title")
public class AcademicTitleController {
    private final AcademicTitleService academicTitleService;

    @PostMapping("/save")
    public ResponseEntity<AcademicTitleDTO> save(@Valid @RequestBody
                                                     AcademicTitleDTO academicTitleDTO)
                                                        throws Exception{
        final var academicTitleDTOResponse = academicTitleService.save(academicTitleDTO);
        return ResponseEntity.ok(academicTitleDTOResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id) throws Exception{
        academicTitleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all/pageable")
    public ResponseEntity<List<AcademicTitleDTO>> findAll(
            @RequestParam(name = "page",defaultValue = "0") int page,
            @RequestParam(name = "pageSize", defaultValue = "3") int pageSize,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortingCriterium,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection
    ){
        final Pageable pageable =
                PageRequest.of(page, pageSize,
                        switch (sortDirection.toLowerCase()) {
                            case "desc" -> Sort.by(sortingCriterium).descending();
                            default -> Sort.by(sortingCriterium).ascending();
                        });

        return ResponseEntity.ok(academicTitleService.getAll(pageable));
    }
}
