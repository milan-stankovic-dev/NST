package nst.springboot.restexample01.service.impl;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.domain.impl.Department;
import nst.springboot.restexample01.domain.impl.Subject;
import nst.springboot.restexample01.repository.DepartmentRepository;
import nst.springboot.restexample01.repository.SubjectRepository;
import nst.springboot.restexample01.service.abstraction.SubjectService;
import nst.springboot.restexample01.converter.impl.SubjectConverter;
import nst.springboot.restexample01.dto.SubjectDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectConverter subjectConverter;
    private final SubjectRepository subjectRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public SubjectDTO save(SubjectDTO subjectDto) throws Exception {
        final Subject subjectToSave = subjectConverter.toEntity(subjectDto);

        if(subjectToSave.getDepartment() == null){
            throw new Exception("The subject you are trying to save" +
                    "must contain a department.");
        }

        if(subjectToSave.getDepartment().getId() == null){
            departmentRepository.save(subjectToSave.getDepartment());
        } else {
            Optional<Department> departmentOptFromDB =
                    departmentRepository.findById(subjectToSave
                            .getDepartment().getId());

            if(departmentOptFromDB.isEmpty()) {
                departmentRepository.save(subjectToSave.getDepartment());
            }
        }

        final Subject savedSubject = subjectRepository.save(subjectToSave);

        return subjectConverter.toDto(savedSubject);
    }

    @Override
    public List<SubjectDTO> getAll(Pageable pageable) {
        return subjectConverter.listToDto(
                subjectRepository.findAll(pageable).getContent()
        );
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
