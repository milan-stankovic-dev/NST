package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import java.util.List;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.service.abstraction.SubjectService;
import nst.springboot.restexample01.dto.SubjectDTO;
import nst.springboot.restexample01.util.PaginationUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;
    private final PaginationUtil paginationUtil;

    //dodaj novi department
    @PostMapping("/save")
    public ResponseEntity<SubjectDTO> save(@Valid @RequestBody SubjectDTO subject) throws Exception {
        //ResponseEntity
        SubjectDTO subjectDto = subjectService.save(subject);
        return new ResponseEntity<>(subjectDto, HttpStatus.CREATED);
    }

    //vrati sve
    @GetMapping("/all/paging")
    public ResponseEntity<List<SubjectDTO>> getAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "pageSize", defaultValue = "3") int pageSize,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortingCriterium,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortingDirection
    ) {
        final Pageable pageable =
                paginationUtil.createPageable(page, pageSize,
                        sortingCriterium, sortingDirection);

        return ResponseEntity.ok(subjectService.getAll(pageable));
    }

    //pronadji na osnovu ID/a
    //localhost:8080/department/1
    @GetMapping("/{id}")
    public SubjectDTO findById(@PathVariable("id") Long id) throws Exception {
        return subjectService.findById(id);
    }

    //pronadji na osnovu ID/a
    //localhost:8080/department/query?id=1
    @GetMapping("/query")
    public SubjectDTO queryById(@RequestParam("id") Long id) throws Exception {
        return subjectService.findById(id);
    }

    //azuriraj
    
    //obrisi
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        /*
        try {
            departmentService.delete(id);
            return new ResponseEntity<>("Department removed!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(">>" + e.getMessage(), HttpStatus.NOT_FOUND);
        }*/
        
        subjectService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
