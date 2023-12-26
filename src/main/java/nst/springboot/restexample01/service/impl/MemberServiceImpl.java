package nst.springboot.restexample01.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.impl.AcademicTitleConverter;
import nst.springboot.restexample01.converter.impl.MemberConverter;
import nst.springboot.restexample01.converter.impl.MinimalMemberConverter;
import nst.springboot.restexample01.converter.impl.ScientificFieldConverter;
import nst.springboot.restexample01.domain.impl.*;
import nst.springboot.restexample01.dto.MemberDTO;
import nst.springboot.restexample01.dto.MinimalMemberDTO;
import nst.springboot.restexample01.repository.*;
import nst.springboot.restexample01.service.abstraction.MemberService;
import nst.springboot.restexample01.util.ResolveEntityLinksUtil;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberConverter memberConverter;
    private final MinimalMemberConverter minimalMemberConverter;
    private final AcademicTitleConverter academicTitleConverter;
    private final ScientificFieldConverter scientificFieldConverter;
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

    @Override
    @Transactional
    public MinimalMemberDTO updateAcademicTitle(MinimalMemberDTO member) throws Exception {
        final Long id = member.id();

        if(id == null){
            throw new Exception("You must give member's id.");
        }

        if(member.academicTitleDTO() == null){
            throw new Exception("You must input a valid academic title");
        }

        final String academicTitleName =
                member.academicTitleDTO().titleName();

        if(academicTitleName == null || academicTitleName.isEmpty()){
            throw new Exception("Your academic title must have a title" +
                    " name.");
        }

        if(member.scientificFieldDTO() == null){
            throw new Exception("You must input a valid scientific field");
        }

        final String scientificFieldName =
                member.scientificFieldDTO().fieldName();

        if(scientificFieldName == null || scientificFieldName.isEmpty()){
            throw new Exception("Your scientific field must have a proper" +
                    "name");
        }

        final Optional<Member> memberOptDb = memberRepository
                .findById(id);

        if(memberOptDb.isEmpty()){
            throw new Exception("This member may not exist.");
        }

        final Member memberForUpdate = memberOptDb.get();

            final AcademicTitle academicTitle =
                    resolveEntityLinksUtil
                            .saveIfNotNull(
                                    academicTitleConverter.toEntity(
                                            member.academicTitleDTO()),
                                    academicTitleRepository);

            final ScientificField scientificField =
                    resolveEntityLinksUtil
                            .saveIfNotNull(
                                    scientificFieldConverter.toEntity(
                                            member.scientificFieldDTO()),
                                    scientificFieldRepository
                            );

                final LocalDate startDate =
                        memberForUpdate.getStartDate();
                final LocalDate endDate =
                        LocalDate.now();

                final AcademicTitleHistory historyToSave =
                        new AcademicTitleHistory(null, startDate, endDate,
                                                 memberForUpdate,
                                                 memberForUpdate.getAcademicTitle(),
                                                 memberForUpdate.getScientificField());
                academicTitleHistoryRepository.save(historyToSave);

        memberForUpdate.setAcademicTitle(academicTitle);
        memberForUpdate.setScientificField(scientificField);
        memberForUpdate.setStartDate(endDate);
        final var savedMember = memberRepository.save(memberForUpdate);

        return minimalMemberConverter.toDto(savedMember);
    }
}
