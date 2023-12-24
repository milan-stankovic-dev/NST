package nst.springboot.restexample01.service;

import jakarta.validation.Valid;
import nst.springboot.restexample01.dto.EducationTitleDTO;

public interface EducationTitleService {
    EducationTitleDTO save(@Valid EducationTitleDTO educationTitleDTO) throws Exception;
    void delete(Long id) throws Exception;
}
