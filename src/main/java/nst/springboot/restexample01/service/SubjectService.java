package nst.springboot.restexample01.service;

import java.util.List;

import nst.springboot.restexample01.dto.SubjectDTO;

public interface SubjectService {
    SubjectDTO save(SubjectDTO subjectDto)throws Exception;
    List<SubjectDTO> getAll();
    void delete(Long id) throws Exception;
    void update(SubjectDTO subjectDto)throws Exception;
    SubjectDTO findById(Long id)throws Exception;
}
