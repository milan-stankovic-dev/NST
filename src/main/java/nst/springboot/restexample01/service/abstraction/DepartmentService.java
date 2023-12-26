package nst.springboot.restexample01.service.abstraction;

import java.util.List;
import java.util.Optional;

import nst.springboot.restexample01.domain.impl.Department;
import nst.springboot.restexample01.dto.DepartmentDTO;
import nst.springboot.restexample01.service.DomainService;

public interface DepartmentService extends
        DomainService<DepartmentDTO, Long> {

    DepartmentDTO update(DepartmentDTO department) throws Exception ;
    DepartmentDTO findById(Long id) throws Exception ;

}
