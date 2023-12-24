package nst.springboot.restexample01.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.domain.Department;
import nst.springboot.restexample01.repository.DepartmentRepository;
import nst.springboot.restexample01.service.abstraction.DepartmentService;
import nst.springboot.restexample01.converter.impl.DepartmentConverter;
import nst.springboot.restexample01.dto.DepartmentDTO;
import nst.springboot.restexample01.exception.DepartmentAlreadyExistException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentConverter departmentConverter;
    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO save(DepartmentDTO departmentDto) throws Exception {
        Optional<Department> dept = departmentRepository.findByName(departmentDto.name());
        if (dept.isPresent()) {
            throw new DepartmentAlreadyExistException("Department sa tim imenom postoji!");
        } else {
            //DTO - > Entity
            //Department department = new Department(departmentDto.getId(), departmentDto.getName());
            Department department = departmentConverter.toEntity(departmentDto);
            department = departmentRepository.save(department);
            return departmentConverter.toDto(department);
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        //proveri da li postoji department
        Optional<Department> dept = departmentRepository.findById(id);
        if (dept.isPresent()) {
            //postoji
            Department department = dept.get();
            departmentRepository.delete(department);
        } else {
            throw new Exception("Department does not exist!");
        }

    }

    @Override
    public DepartmentDTO update(DepartmentDTO department) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DepartmentDTO findById(Long id) throws Exception {
        Optional<Department> dept = departmentRepository.findById(id);
        if (dept.isPresent()) {
            //postoji
            Department department = dept.get();
            return departmentConverter.toDto(department);
        } else {
            throw new Exception("Department does not exist!");
        }
    }

    @Override
    public List<DepartmentDTO> getAll() {
        return departmentRepository
                .findAll()
                .stream().map(entity -> departmentConverter.toDto(entity))
                .collect(Collectors.toList());
    }

}
