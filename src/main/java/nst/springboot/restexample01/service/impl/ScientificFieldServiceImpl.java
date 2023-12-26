package nst.springboot.restexample01.service.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.impl.ScientificFieldConverter;
import nst.springboot.restexample01.domain.impl.ScientificField;
import nst.springboot.restexample01.dto.ScientificFieldDTO;
import nst.springboot.restexample01.repository.ScientificFieldRepository;
import nst.springboot.restexample01.service.abstraction.ScientificFieldService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScientificFieldServiceImpl implements ScientificFieldService {
    private final ScientificFieldRepository scientificFieldRepository;
    private final ScientificFieldConverter scientificFieldConverter;
    @Override
    public ScientificFieldDTO save(ScientificFieldDTO scientificFieldDTO) throws Exception {
        final ScientificField fieldToSave =
                scientificFieldConverter.toEntity(scientificFieldDTO);
        fieldToSave.setId(null);
        final ScientificField fieldSaved = scientificFieldRepository
                .save(fieldToSave);
        return scientificFieldConverter.toDto(fieldSaved);
    }

    @Override
    public List<ScientificFieldDTO> getAll() {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == null){
            throw new Exception("Id must not be null.");
        }

        final var scientificFieldOptFromDB = scientificFieldRepository.findById(id);

        if(scientificFieldOptFromDB.isEmpty()){
            throw new Exception("There is no scientific field with said id.");
        }

        scientificFieldRepository.deleteById(id);
    }

}
