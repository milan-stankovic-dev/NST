package nst.springboot.restexample01.service.abstraction;

import java.util.List;

import nst.springboot.restexample01.dto.DepartmentDTO;
import nst.springboot.restexample01.service.DomainService;

public interface DepartmentService extends
        DomainService<DepartmentDTO, Long> { }
