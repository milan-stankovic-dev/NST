package nst.springboot.restexample01.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.impl.MemberConverter;
import nst.springboot.restexample01.domain.impl.*;
import nst.springboot.restexample01.dto.MemberDTO;
import nst.springboot.restexample01.repository.*;
import nst.springboot.restexample01.service.abstraction.MemberService;
import nst.springboot.restexample01.util.ResolveEntityLinksUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberConverter memberConverter;
    private final DepartmentRepository departmentRepository;
    private final AcademicTitleRepository academicTitleRepository;
    private final EducationTitleRepository educationTitleRepository;
    private final ScientificFieldRepository scientificFieldRepository;
    private final AcademicTitleHistoryRepository academicTitleHistoryRepository;
    private final ResolveEntityLinksUtil resolveEntityLinksUtil;
    @Override
    @Transactional
    public MemberDTO save(MemberDTO memberDTO) throws Exception {
        final Member memberToSave = memberConverter.toEntity(memberDTO);

        final Department newDept = resolveEntityLinksUtil.saveIfNotNull(
                memberToSave.getDepartment(), departmentRepository);
        final AcademicTitle newAcTitle = resolveEntityLinksUtil.saveIfNotNull(
                memberToSave.getAcademicTitle(), academicTitleRepository);
        final EducationTitle newEducTitle = resolveEntityLinksUtil.saveIfNotNull(
                memberToSave.getEducationTitle(), educationTitleRepository);
        final ScientificField newSciField = resolveEntityLinksUtil.saveIfNotNull(
                memberToSave.getScientificField(), scientificFieldRepository);

        memberToSave.setDepartment(newDept);
        memberToSave.setAcademicTitle(newAcTitle);
        memberToSave.setEducationTitle(newEducTitle);
        memberToSave.setScientificField(newSciField);

        final List<AcademicTitleHistory> histories = memberToSave.getHistories();
        memberToSave.setHistories(new ArrayList<>());
        final Member savedMember = memberRepository.save(memberToSave);

        histories.stream().forEach(h -> h.getMember().setId(savedMember.getId()));

        resolveEntityLinksUtil.saveListIfNotNull(
                        histories,
                        academicTitleHistoryRepository);

        return memberConverter.toDto(savedMember);
    }


    @Override
    public List<MemberDTO> getAll() {
        return memberConverter.listToDto(
                memberRepository.findAll()
        );
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == null){
            throw new Exception("Id must not be null");
        }
        memberRepository.deleteById(id);
    }

    @Override
    public MemberDTO update(MemberDTO e) throws Exception {
        return null;
    }

    @Override
    public MemberDTO findById(Long aLong) throws Exception {
        return null;
    }
}
