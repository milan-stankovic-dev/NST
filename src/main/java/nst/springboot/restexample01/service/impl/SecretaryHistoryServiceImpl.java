package nst.springboot.restexample01.service.impl;


import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.controller.SecretaryHistoryController;
import nst.springboot.restexample01.converter.impl.SecretaryHistoryConverter;
import nst.springboot.restexample01.dto.SecretaryHistoryDTO;
import nst.springboot.restexample01.repository.SecretaryHistoryRepository;
import nst.springboot.restexample01.service.abstraction.SecretaryHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecretaryHistoryServiceImpl implements SecretaryHistoryService {
    private final SecretaryHistoryRepository secretaryHistoryRepository;
    private final SecretaryHistoryConverter secretaryHistoryConverter;
    @Override
    public SecretaryHistoryDTO save(SecretaryHistoryDTO e) throws Exception {
        return null;
    }

    @Override
    public List<SecretaryHistoryDTO> getAll() {
        return secretaryHistoryConverter.listToDto(
                secretaryHistoryRepository.findAll()
        );
    }

    @Override
    public void delete(Long aLong) throws Exception {

    }

    @Override
    public SecretaryHistoryDTO update(SecretaryHistoryDTO e) throws Exception {
        return null;
    }

    @Override
    public SecretaryHistoryDTO findById(Long aLong) throws Exception {
        return null;
    }
}
