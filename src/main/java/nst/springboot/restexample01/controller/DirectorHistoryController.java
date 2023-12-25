package nst.springboot.restexample01.controller;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.dto.DirectorHistoryDTO;
import nst.springboot.restexample01.service.abstraction.DirectorHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/director-history")
public class DirectorHistoryController {
    private final DirectorHistoryService directorHistoryService;

    @GetMapping
    public ResponseEntity<List<DirectorHistoryDTO>> getAll(){
        return ResponseEntity.ok(directorHistoryService.getAll());
    }
}
