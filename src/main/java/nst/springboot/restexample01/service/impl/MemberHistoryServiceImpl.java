package nst.springboot.restexample01.service.impl;

import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.dto.MemberHistoryDTO;
import nst.springboot.restexample01.repository.MemberHistoryRepository;
import nst.springboot.restexample01.service.abstraction.MemberHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberHistoryServiceImpl implements MemberHistoryService {
    private MemberHistoryRepository memberHistoryRepository;
    @Override
    public MemberHistoryDTO save(MemberHistoryDTO e) throws Exception {
        return null;
    }

    @Override
    public List<MemberHistoryDTO> getAll() {
        return null;
    }

    @Override
    public void delete(Long aLong) throws Exception {

    }
}
