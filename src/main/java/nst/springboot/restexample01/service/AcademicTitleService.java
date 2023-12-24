package nst.springboot.restexample01.service;

import nst.springboot.restexample01.dto.AcademicTitleDTO;

public interface AcademicTitleService {
    AcademicTitleDTO save(AcademicTitleDTO academicTitleDTO) throws Exception;
    void delete(Long id) throws Exception;
}
