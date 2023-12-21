/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.controller.domain.Department;
import nst.springboot.restexample01.controller.domain.Subject;
import nst.springboot.restexample01.controller.repository.DepartmentRepository;
import nst.springboot.restexample01.controller.repository.SubjectRepository;
import nst.springboot.restexample01.controller.service.SubjectService;
import nst.springboot.restexample01.converter.impl.DepartmentConverter;
import nst.springboot.restexample01.converter.impl.SubjectConverter;
import nst.springboot.restexample01.dto.SubjectDTO;
import org.springframework.stereotype.Service;

/**
 *
 * @author student2
 */
@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final DepartmentConverter departmentConverter;
    private final SubjectConverter subjectConverter;

    private final SubjectRepository subjectRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public SubjectDTO save(SubjectDTO subjectDto) throws Exception {
          throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<SubjectDTO> getAll() {
        return subjectRepository
                .findAll()
                .stream().map(entity -> subjectConverter.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) throws Exception {
        Optional<Subject> subject = subjectRepository.findById(id);
        if (subject.isPresent()) {
            Subject subj = subject.get();
            subjectRepository.delete(subj);
        } else {
            throw new Exception("Subject does not exist!");
        }

    }

    @Override
    public void update(SubjectDTO subjectDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SubjectDTO findById(Long id) throws Exception {
        Optional<Subject> subject = subjectRepository.findById(id);
        if (subject.isPresent()) {
            //postoji
            Subject subj = subject.get();
            return subjectConverter.toDto(subj);
        } else {
            throw new Exception("Subject does not exist!");
        }
    }

}
