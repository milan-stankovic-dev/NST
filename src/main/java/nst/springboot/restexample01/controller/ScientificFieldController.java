package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.dto.ScientificFieldDTO;
import nst.springboot.restexample01.service.abstraction.ScientificFieldService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scientific-field")
public class ScientificFieldController {
    private final ScientificFieldService scientificFieldService;

    @PostMapping
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

    @GetMapping
    public ResponseEntity<List<ScientificFieldDTO>> findAll(){
        return ResponseEntity.ok(scientificFieldService.getAll());
    }
}
