package nst.springboot.restexample01.controller;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.dto.SecretaryHistoryDTO;
import nst.springboot.restexample01.service.abstraction.SecretaryHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/secretary-history")
public class SecretaryHistoryController {
    private final SecretaryHistoryService secretaryHistoryService;

    @GetMapping
    public ResponseEntity<List<SecretaryHistoryDTO>> getAll(){
        return ResponseEntity.ok(secretaryHistoryService.getAll());
    }
}
