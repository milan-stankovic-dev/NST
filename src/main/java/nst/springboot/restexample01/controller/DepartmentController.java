package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import java.util.List;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.domain.impl.Department;
import nst.springboot.restexample01.service.abstraction.DepartmentService;
import nst.springboot.restexample01.dto.DepartmentDTO;
import nst.springboot.restexample01.exception.DepartmentAlreadyExistException;
import nst.springboot.restexample01.exception.MyErrorDetails;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    //dodaj novi department
    @PostMapping("/save")
    public ResponseEntity<DepartmentDTO> save(@Valid @RequestBody DepartmentDTO departmentDto) throws Exception {
        //ResponseEntity
        DepartmentDTO deptDto = departmentService.save(departmentDto);
        return new ResponseEntity<>(deptDto, HttpStatus.CREATED);
    }

   
    @GetMapping("/all/pageable")
    public ResponseEntity<List<DepartmentDTO>> getAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "pageSize", defaultValue = "3") int pageSize,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortingCriterium,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortingDirection
    ) {
        final Pageable pageable =
                PageRequest.of(page, pageSize,
                        switch (sortingDirection.toLowerCase()){
                            case "desc" -> Sort.by(sortingCriterium).descending();
                            default -> Sort.by(sortingCriterium).ascending();
                        });

        return ResponseEntity.ok(departmentService.getAll(pageable));
    }

       //pronadji na osnovu ID/a
    //localhost:8080/department/1
    @GetMapping("/{id}")
    public DepartmentDTO findById(@PathVariable("id") Long id) throws Exception {
        System.out.println("Controller: " + id);
        return departmentService.findById(id);
    }

    //pronadji na osnovu ID/a
    //localhost:8080/department/query?id=1
    @GetMapping("/query")
    public Department queryById(@RequestParam("id") Long id) throws Exception {
        //return departmentService.findById(id);
        throw new Exception("Nije implementirana.");
    }

    //azuriraj
    //obrisi
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        /*
        try {
            departmentService.delete(id);
            return new ResponseEntity<>("Department removed!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(">>" + e.getMessage(), HttpStatus.NOT_FOUND);
        }*/

        departmentService.delete(id);
        return new ResponseEntity<>("Department removed!", HttpStatus.OK);

    }

    /*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> handleException(Exception e){
        System.out.println("nst.springboot.restexample01.controller.DepartmentController.handleException()");
        System.out.println("-----------pozvana metoda za obradu izuzetka u kontroleru -------------");
        
        MyErrorDetails myErrorDetails = new MyErrorDetails(e.getMessage());
        
        return new ResponseEntity<>(myErrorDetails, HttpStatus.NOT_FOUND);

    }*/
    @ExceptionHandler(DepartmentAlreadyExistException.class)
    public ResponseEntity<MyErrorDetails> handleException(DepartmentAlreadyExistException e) {
        System.out.println("nst.springboot.restexample01.controller.DepartmentController.handleException()");
        System.out.println("-----------pozvana metoda za obradu izuzetka u kontroleru -------------");

        MyErrorDetails myErrorDetails = new MyErrorDetails(e.getMessage());

        return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);

    }
}
