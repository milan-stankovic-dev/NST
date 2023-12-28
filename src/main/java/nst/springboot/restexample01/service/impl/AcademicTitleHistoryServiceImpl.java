package nst.springboot.restexample01.service.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.impl.AcademicTitleHistoryConverter;
import nst.springboot.restexample01.domain.impl.AcademicTitleHistory;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDTO;
import nst.springboot.restexample01.repository.AcademicTitleHistoryRepository;
import nst.springboot.restexample01.service.abstraction.AcademicTitleHistoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademicTitleHistoryServiceImpl implements
        AcademicTitleHistoryService {

    private final AcademicTitleHistoryRepository
            academicTitleHistoryRepository;
    private final AcademicTitleHistoryConverter
            academicTitleHistoryConverter;

    @Override
    public AcademicTitleHistoryDTO save(AcademicTitleHistoryDTO e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<AcademicTitleHistoryDTO> getAll(Pageable pageable) {
        return academicTitleHistoryConverter.listToDto(
          academicTitleHistoryRepository.findAll(pageable).getContent()
        );
    }

    @Override
    public void delete(Long aLong) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<AcademicTitleHistoryDTO> historiesForMember(Long memberId){
        return academicTitleHistoryConverter.listToDto(
                academicTitleHistoryRepository.findByMemberId(memberId)
        );
    }
}
