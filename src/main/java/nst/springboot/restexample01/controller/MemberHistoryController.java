package nst.springboot.restexample01.controller;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.dto.MemberHistoryDTO;
import nst.springboot.restexample01.service.abstraction.MemberHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member-history")
public class MemberHistoryController {
    private final MemberHistoryService memberHistoryService;

    @GetMapping("/all")
    public ResponseEntity<List<MemberHistoryDTO>> findAll(){
        return ResponseEntity.ok(memberHistoryService.getAll());
    }

}
