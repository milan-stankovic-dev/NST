package nst.springboot.restexample01.service.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.impl.DirectorHistoryConverter;
import nst.springboot.restexample01.domain.DirectorHistory;
import nst.springboot.restexample01.dto.DirectorHistoryDTO;
import nst.springboot.restexample01.repository.DirectorHistoryRepository;
import nst.springboot.restexample01.service.abstraction.DirectorHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorHistoryServiceImpl implements DirectorHistoryService {
    private final DirectorHistoryRepository directorHistoryRepository;
    private final DirectorHistoryConverter directorHistoryConverter;
    @Override
    public DirectorHistoryDTO save(DirectorHistoryDTO directorHistoryDTO)
            throws Exception {
        final var dirHistoryToSave
                = directorHistoryConverter.toEntity(directorHistoryDTO);
        return directorHistoryConverter.toDto(
          directorHistoryRepository.save(dirHistoryToSave)
        );
    }

    @Override
    public List<DirectorHistoryDTO> getAll() {
        return null;
    }

    @Override
    public void delete(Long aLong) throws Exception {

    }

    @Override
    public DirectorHistoryDTO update(DirectorHistoryDTO e) throws Exception {
        return null;
    }

    @Override
    public DirectorHistoryDTO findById(Long aLong) throws Exception {
        return null;
    }
}
