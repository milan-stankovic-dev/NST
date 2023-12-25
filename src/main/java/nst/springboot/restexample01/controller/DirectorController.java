package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.dto.DirectorDTO;
import nst.springboot.restexample01.service.abstraction.DirectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/director")
public class DirectorController {
    private final DirectorService directorService;
    @PostMapping
    public ResponseEntity<DirectorDTO> save(@Valid @RequestBody
                                            DirectorDTO directorDTO) throws Exception{
        final var savedDirectorDTO = directorService.save(directorDTO);
        return ResponseEntity.ok(savedDirectorDTO);
    }

    @GetMapping
    public ResponseEntity<List<DirectorDTO>> getAll(){
        return ResponseEntity.ok(directorService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception{
        directorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
