package nst.springboot.restexample01.service;

import nst.springboot.restexample01.domain.ScientificField;
import nst.springboot.restexample01.dto.ScientificFieldDTO;

public interface ScientificFieldService {
    ScientificFieldDTO save(ScientificFieldDTO scientificFieldDTO) throws Exception;
    void delete(Long id) throws Exception;
}
