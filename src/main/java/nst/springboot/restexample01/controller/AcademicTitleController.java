package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.dto.AcademicTitleDTO;
import nst.springboot.restexample01.service.abstraction.AcademicTitleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/academic-title")
public class AcademicTitleController {
    private final AcademicTitleService academicTitleService;

    @PostMapping
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
}
