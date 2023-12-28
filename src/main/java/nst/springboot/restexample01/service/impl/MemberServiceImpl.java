package nst.springboot.restexample01.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.impl.*;
import nst.springboot.restexample01.domain.impl.*;
import nst.springboot.restexample01.dto.DepartmentChangeMemberDTO;
import nst.springboot.restexample01.dto.MemberDTO;
import nst.springboot.restexample01.dto.AcademicTitleMemberDTO;
import nst.springboot.restexample01.dto.RoleChangeMemberDTO;
import nst.springboot.restexample01.repository.*;
import nst.springboot.restexample01.role.MemberRole;
import nst.springboot.restexample01.service.abstraction.MemberService;
import nst.springboot.restexample01.util.ResolveEntityLinksUtil;
import org.springframework.data.domain.Pageable;
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
    private final AcademicTitleMemberDTOConverter academicTitleMemberDTOConverter;
    private final AcademicTitleConverter academicTitleConverter;
    private final ScientificFieldConverter scientificFieldConverter;
    private final DepartmentRepository departmentRepository;
    private final AcademicTitleRepository academicTitleRepository;
    private final EducationTitleRepository educationTitleRepository;
    private final ScientificFieldRepository scientificFieldRepository;
    private final AcademicTitleHistoryRepository academicTitleHistoryRepository;
    private final ResolveEntityLinksUtil resolveEntityLinksUtil;
    private final MemberHistoryRepository memberHistoryRepository;
    private final RoleChangeMemberDTOConverter roleChangeConverter;
    private final DepartmentChangeMemberDTOConverter departmentChangeMemberConverter;
    @Override
    @Transactional
    public MemberDTO save(MemberDTO memberDTO) throws Exception {
        final Member memberToSave = memberConverter.toEntity(memberDTO);

        if(memberToSave.getRole() == MemberRole.DIRECTOR ||
                memberToSave.getRole() == MemberRole.SECRETARY){
            throw new Exception("The member you are trying to save is a director or secretary." +
                    "This endpoint is only concerned with adding new regular members." +
                    "To add a custom member, please refer to a different endpoint.");
        }

        final Optional<Member> testingMemberOpt =
                memberRepository.findByFirstNameAndLastName(
                        memberToSave.getFirstName(),
                        memberToSave.getLastName()
                );

        if(testingMemberOpt.isPresent()){
            throw new Exception("This member already exists. If you're trying to " +
                    "update something about this user please try a different endpoint." +
                    "This endpoint is only concerned with adding new members.");
        }

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


//    @Override
//    public List<MemberDTO> getAll() {
//        return memberConverter.listToDto(
//                memberRepository.findAll()
//        );
//    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == null){
            throw new Exception("Id must not be null");
        }
        final var memberOptDb =
                memberRepository.findById(id);
        if(memberOptDb.isEmpty()){
            throw new Exception("There is no member with " +
                    "given id.");
        }
        final Member member = memberOptDb.get();
        if(member.getRole() == MemberRole.SECRETARY ||
            member.getRole() == MemberRole.DIRECTOR){
            throw new Exception("You may not delete a secretary or a " +
                    "director. The proper way to handle director and secretary " +
                    "changes is to update their roles to member first, then delete" +
                    "them. This requires a new member to take their spot as director " +
                    "or secretary.");
        }

        memberRepository.deleteById(id);
    }

    private void validateUpdateAcademicTitleInput(AcademicTitleMemberDTO member)
                    throws Exception{
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
    }

    @Override
    @Transactional
    public AcademicTitleMemberDTO updateAcademicTitle(AcademicTitleMemberDTO member) throws Exception {

        validateUpdateAcademicTitleInput(member);

        final Optional<Member> memberOptDb = memberRepository
                .findById(member.id());

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

        return academicTitleMemberDTOConverter.toDto(savedMember);
    }
    private Member fetchMemberIfInputValid (RoleChangeMemberDTO memberDTO) throws Exception{
        if(memberDTO.id() == null){
            throw new Exception("You must input an id for member role change.");
        }

        if(memberDTO.newRole() == MemberRole.REGULAR){
            throw new Exception("You may not degrade a current secretary or director to " +
                    "a regular member. Downgrading happens automatically when a new director or " +
                    "secretary are chosen. To downgrade this member, please provide a new replacement.");
        }

        return getMember(memberDTO);
    }

    private Department fetchDepartmentIfInputValid(Member memberDb) throws Exception {
        final Optional<Department> departmentForRoleChange =
                departmentRepository.findById(memberDb.getDepartment().getId());

        if(departmentForRoleChange.isEmpty()){
            throw new Exception("The department this member has been assigned to " +
                    "seems to be invalid. Please update member to proceed.");
        }

        return departmentForRoleChange.get();
    }

    private Member fetchCurrentRoleHolderIfUnique(MemberRole role, Long departmentId)
                                                                    throws Exception{
        final List<Member> currentRoleHolderList =
                memberRepository.findRoleHolder(role,departmentId);
        if(currentRoleHolderList.size() != 1){
            throw new Exception("This department has more than one " +
                    role.toString().toUpperCase() + ". Please address this by " +
                    "removing one of them manually.");
        }

        return currentRoleHolderList.get(0);
    }

    private MemberRole getOppositeChairmanRole(MemberRole role){
        return role == MemberRole.DIRECTOR ? MemberRole.SECRETARY : MemberRole.DIRECTOR;
    }

    @Override
    @Transactional
    public RoleChangeMemberDTO updateRole(RoleChangeMemberDTO memberDTO) throws Exception {

        final var memberDb = fetchMemberIfInputValid(memberDTO);

        if (memberDb.getDepartment().getId() == null) {
            throw new Exception("This member may not be assigned to any " +
                    "department. Please fix this error by updating said member" +
                    "before proceeding.");
        }

        final var departmentDb = fetchDepartmentIfInputValid(memberDb);

        final Member currentRoleHolder =
                fetchCurrentRoleHolderIfUnique(memberDTO.newRole()
                        ,departmentDb.getId());

        retireCurrentChairman(currentRoleHolder);

        switch (memberDb.getRole()){
            case REGULAR:
                currentRoleHolder.setRole(MemberRole.REGULAR);
                memberRepository.save(currentRoleHolder);
                break;
            case DIRECTOR:
            case SECRETARY:
                final var oppositeRole = getOppositeChairmanRole(
                        memberDb.getRole());
                final var oppositeRoleHolder =
                        fetchCurrentRoleHolderIfUnique(
                                oppositeRole,
                                departmentDb.getId());

                oppositeRoleHolder.setRole(memberDb.getRole());
                memberRepository.save(oppositeRoleHolder);
        }

        memberDb.setRole(memberDTO.newRole());
        memberDb.setStartDate(LocalDate.now());
        final var newRoleHolder =
                memberRepository.save(memberDb);

        return roleChangeConverter.toDto(newRoleHolder);

    }

    private void retireCurrentChairman(Member currentRoleHolder){
        final LocalDate startDate = currentRoleHolder.getStartDate();
        final LocalDate endDate = LocalDate.now();
        final MemberRole role = currentRoleHolder.getRole();
        final Department department = currentRoleHolder
                .getDepartment();

        final MemberHistory historyToSave =
                new MemberHistory(
                        null, startDate, endDate,
                        role, department, currentRoleHolder);

        memberHistoryRepository.save(historyToSave);
    }

    private Member getMember(RoleChangeMemberDTO memberDTO) throws Exception {

        final Optional<Member> memberOptDb =
                memberRepository.findById(memberDTO.id());

        if(memberOptDb.isEmpty()) {
            throw new Exception("There are no members with said id. If you wish to " +
                    "add a new member, please refer to a different endpoint.");
        }

        final Member memberDb = memberOptDb.get();
        final MemberRole newRole = memberDTO.newRole();

        if((memberDb.getRole() == MemberRole.REGULAR &&
            newRole == MemberRole.REGULAR) ||
                (memberDb.getRole() == MemberRole.DIRECTOR &&
                        newRole == MemberRole.DIRECTOR) ||
                (memberDb.getRole() == MemberRole.SECRETARY &&
                        newRole == MemberRole.SECRETARY)){
            throw new Exception("There is no need for a role change. " +
                    "User with given id already has that role.");
        }
        return memberDb;
    }

    @Override
    public MemberDTO queryById(Long id) throws Exception{

        if(id == null){
            throw new Exception("Id must not be null.");
        }

        final Optional<Member> memberDbOpt =
                memberRepository.findById(id);

        if(memberDbOpt.isEmpty()){
            throw new Exception("Member with given id not found.");
        }

        final Member savedMember = memberDbOpt.get();

        return memberConverter.toDto(savedMember);
    }

    @Override
    public List<MemberDTO> getAllOfType(String type) throws Exception {
        if(type == null || type.isEmpty()){
            throw new Exception("You must input a query type for searching members.");
        }

        if(!type.equalsIgnoreCase("REGULAR")
                && !type.equalsIgnoreCase("DIRECTOR")
                && !type.equalsIgnoreCase("SECRETARY")){
            throw new Exception("Illegal type of member inputted. Valid types are: " +
                    "'REGULAR', 'SECRETARY' and 'DIRECTOR'");
        }

        return memberConverter.listToDto(
            memberRepository.findAllByType(MemberRole.valueOf(type.toUpperCase()))
        );
    }

    @Override
    public List<MemberDTO> getAll(Pageable pageable) {
        return memberConverter.listToDto(
            memberRepository.findAll(pageable).getContent()
        );
    }

    @Override
    public DepartmentChangeMemberDTO updateDepartment(DepartmentChangeMemberDTO memberDTO)
                                                                        throws Exception{
        if(memberDTO.id() == null || memberDTO.newDepartmentId() == null){
            throw new Exception("DTO input invalid. Try again.");
        }

        final Long memberId = memberDTO.id();
        final Long newDepartmentId = memberDTO.newDepartmentId();

        final Optional<Member> memberOptDb =
                memberRepository.findById(memberId);

        if(memberOptDb.isEmpty()){
            throw new Exception("There is no member with given id.");
        }

        final var memberToChange = memberOptDb.get();

        if(memberToChange.getRole() == MemberRole.DIRECTOR ||
            memberToChange.getRole() == MemberRole.SECRETARY){
            throw new Exception("You may not change the department of a " +
                    "sitting director or a secretary. This feature is only " +
                    "available for regular members.");
        }

        final Optional<Department> departmentOptDb =
                departmentRepository.findById(newDepartmentId);

        if(departmentOptDb.isEmpty()){
            throw new Exception("There is no department with said id.");
        }

        final var newDepartment = departmentOptDb.get();

        if(memberToChange.getDepartment() != null
                && (memberToChange.getDepartment().getId().longValue()
                == newDepartmentId.longValue())){
            throw new Exception("There is no need for a department change." +
                    " This member is already assigned to that department.");
        }

        memberToChange.setDepartment(newDepartment);
        final Member memberSaved = memberRepository.save(memberToChange);
        return departmentChangeMemberConverter.toDto(memberSaved);

    }
}
