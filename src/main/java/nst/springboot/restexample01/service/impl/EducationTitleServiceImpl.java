package nst.springboot.restexample01.service.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.impl.EducationTitleConverter;
import nst.springboot.restexample01.domain.EducationTitle;
import nst.springboot.restexample01.dto.EducationTitleDTO;
import nst.springboot.restexample01.repository.EducationTitleRepository;
import nst.springboot.restexample01.service.abstraction.EducationTitleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationTitleServiceImpl implements EducationTitleService {
    private final EducationTitleRepository educationTitleRepository;
    private final EducationTitleConverter educationTitleConverter;

    @Override
    public EducationTitleDTO save(@Valid EducationTitleDTO educationTitleDTO)
            throws Exception {
        final EducationTitle titleToSave =
            educationTitleConverter.toEntity(educationTitleDTO);
        titleToSave.setId(null);
        final EducationTitle titleSaved =
                educationTitleRepository.save(titleToSave);

        return educationTitleConverter.toDto(titleSaved);
    }

    @Override
    public List<EducationTitleDTO> getAll() {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == null){
            throw new Exception("ID must not be null.");
        }

        final var educationTitleOptFromDB = educationTitleRepository.findById(id);

        if(educationTitleOptFromDB.isEmpty()){
            throw new Exception("There is no scientific field with said ID.");
        }

        educationTitleRepository.deleteById(id);
    }

    @Override
    public EducationTitleDTO update(EducationTitleDTO e) throws Exception {
        return null;
    }

    @Override
    public EducationTitleDTO findById(Long aLong) throws Exception {
        return null;
    }
}
