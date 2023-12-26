package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.dto.EducationTitleDTO;
import nst.springboot.restexample01.service.abstraction.EducationTitleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/education-title")
public class EducationTitleController {
    private final EducationTitleService educationTitleService;

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

    @GetMapping("/all")
    public ResponseEntity<List<EducationTitleDTO>> getAll(){
        return ResponseEntity.ok(educationTitleService.getAll());
    }
}
