package nst.springboot.restexample01.service.impl;

import nst.springboot.restexample01.dto.SecretaryDTO;
import nst.springboot.restexample01.service.abstraction.SecretaryService;

import java.util.List;

public class SecretaryServiceImpl implements SecretaryService {
    @Override
    public SecretaryDTO save(SecretaryDTO e) throws Exception {
        return null;
    }

    @Override
    public List<SecretaryDTO> getAll() {
        return null;
    }

    @Override
    public void delete(Long aLong) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
