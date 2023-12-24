package nst.springboot.restexample01.service;

import java.util.List;

import nst.springboot.restexample01.dto.DepartmentDTO;

public interface DepartmentService {
    DepartmentDTO save(DepartmentDTO departmentDto) throws Exception;
    List<DepartmentDTO> getAll();
    void delete(Long id) throws Exception;
    void update(DepartmentDTO department) throws Exception;
    DepartmentDTO findById(Long id) throws Exception;
}
