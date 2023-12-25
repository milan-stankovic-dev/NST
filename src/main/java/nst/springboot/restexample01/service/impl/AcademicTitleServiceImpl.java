package nst.springboot.restexample01.service.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.impl.AcademicTitleConverter;
import nst.springboot.restexample01.domain.impl.AcademicTitle;
import nst.springboot.restexample01.dto.AcademicTitleDTO;
import nst.springboot.restexample01.repository.AcademicTitleRepository;
import nst.springboot.restexample01.service.abstraction.AcademicTitleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcademicTitleServiceImpl implements AcademicTitleService {
    private final AcademicTitleRepository academicTitleRepository;
    private final AcademicTitleConverter academicTitleConverter;

    @Override
    public AcademicTitleDTO save(AcademicTitleDTO academicTitleDTO) throws Exception {
        final AcademicTitle titleForSaving = academicTitleConverter.toEntity(academicTitleDTO);
        titleForSaving.setId(null);
        final AcademicTitle titleSaved = academicTitleRepository.save(titleForSaving);
        return academicTitleConverter.toDto(titleSaved);
    }

    @Override
    public List<AcademicTitleDTO> getAll() {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == null){
            throw new Exception("You must input an id to delete.");
        }

        final Optional<AcademicTitle> academicTitleOptFromDB = academicTitleRepository.findById(id);

        if(academicTitleOptFromDB.isEmpty()){
            throw new Exception("There is no academic title with said id.");
        }

        academicTitleRepository.deleteById(id);
    }

    @Override
    public AcademicTitleDTO update(AcademicTitleDTO e) throws Exception {
        return null;
    }

    @Override
    public AcademicTitleDTO findById(Long aLong) throws Exception {
        return null;
    }
}
