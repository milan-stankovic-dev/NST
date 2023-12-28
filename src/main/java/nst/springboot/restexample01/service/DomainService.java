package nst.springboot.restexample01.service;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DomainService<DTO, ID> {
    DTO save(DTO e) throws Exception;
    List<DTO> getAll(Pageable pageable);
    void delete(ID id) throws Exception;

}
