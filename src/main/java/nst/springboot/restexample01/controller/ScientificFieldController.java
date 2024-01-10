package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.dto.ScientificFieldDTO;
import nst.springboot.restexample01.service.abstraction.ScientificFieldService;
import nst.springboot.restexample01.util.PaginationUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scientific-field")
public class ScientificFieldController {
    private final ScientificFieldService scientificFieldService;
    private final PaginationUtil paginationUtil;

    @GetMapping("/all/pageable")
    public ResponseEntity<List<ScientificFieldDTO>> findAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "pageSize", defaultValue = "3") int pageSize,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortingCriterium,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortingDirection
    ){
        final Pageable pageable =
                paginationUtil.createPageable(page, pageSize,
                        sortingCriterium, sortingDirection);

        return ResponseEntity.ok(scientificFieldService.getAll(pageable));
    }

    @PostMapping("/save")
    public ResponseEntity<ScientificFieldDTO> save(@Valid @RequestBody
                                                   ScientificFieldDTO scientificFieldDTO) throws Exception{
        final var scientificFieldDtoFromService =
                scientificFieldService.save(scientificFieldDTO);
        return ResponseEntity.ok(scientificFieldDtoFromService);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception{
        scientificFieldService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
