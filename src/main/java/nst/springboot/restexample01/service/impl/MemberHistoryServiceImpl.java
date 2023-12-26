package nst.springboot.restexample01.service.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.impl.MemberHistoryConverter;
import nst.springboot.restexample01.dto.MemberHistoryDTO;
import nst.springboot.restexample01.repository.MemberHistoryRepository;
import nst.springboot.restexample01.service.abstraction.MemberHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberHistoryServiceImpl implements MemberHistoryService {
    private MemberHistoryRepository memberHistoryRepository;
    private MemberHistoryConverter memberHistoryConverter;

    @Override
    public List<MemberHistoryDTO> getAll() {
        return memberHistoryConverter.listToDto(
                memberHistoryRepository.findAll()
        );
    }


}
