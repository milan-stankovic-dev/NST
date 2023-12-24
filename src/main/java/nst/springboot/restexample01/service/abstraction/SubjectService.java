package nst.springboot.restexample01.service.abstraction;

import nst.springboot.restexample01.dto.SubjectDTO;
import nst.springboot.restexample01.service.DomainService;

public interface SubjectService extends DomainService<SubjectDTO, Long> { }
