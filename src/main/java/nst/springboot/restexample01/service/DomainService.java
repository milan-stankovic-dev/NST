package nst.springboot.restexample01.service;

import java.util.List;

public interface DomainService<DTO, ID> {
    DTO save(DTO e) throws Exception;
    List<DTO> getAll();
    void delete(ID id) throws Exception;
    DTO update(DTO e) throws Exception;
    DTO findById(ID id) throws Exception;
}
