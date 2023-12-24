package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.dto.DirectorDTO;
import nst.springboot.restexample01.service.abstraction.DirectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    public ResponseEntity<DirectorDTO> update(@Valid @RequestBody
                                              DirectorDTO directorDTO) throws Exception{
        final var updatedDirectorDTO = directorService.update(directorDTO);
        return new ResponseEntity<>(updatedDirectorDTO, HttpStatus.OK);
    }
}
