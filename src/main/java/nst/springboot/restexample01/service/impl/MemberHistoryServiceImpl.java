package nst.springboot.restexample01.service.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.impl.MemberHistoryConverter;
import nst.springboot.restexample01.dto.MemberHistoryDTO;
import nst.springboot.restexample01.repository.MemberHistoryRepository;
import nst.springboot.restexample01.service.abstraction.MemberHistoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberHistoryServiceImpl implements MemberHistoryService {
    private final MemberHistoryRepository memberHistoryRepository;
    private final MemberHistoryConverter memberHistoryConverter;


    @Override
    public List<MemberHistoryDTO> getAll(Pageable pageable) {
        return memberHistoryConverter.listToDto(
                memberHistoryRepository.findAll(pageable).getContent()
        );
    }


}
