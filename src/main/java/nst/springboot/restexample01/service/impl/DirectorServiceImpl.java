package nst.springboot.restexample01.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.impl.DirectorConverter;
import nst.springboot.restexample01.domain.impl.Department;
import nst.springboot.restexample01.domain.impl.Director;
import nst.springboot.restexample01.domain.impl.DirectorHistory;
import nst.springboot.restexample01.dto.DirectorDTO;
import nst.springboot.restexample01.repository.DepartmentRepository;
import nst.springboot.restexample01.repository.DirectorHistoryRepository;
import nst.springboot.restexample01.repository.DirectorRepository;
import nst.springboot.restexample01.service.abstraction.DirectorService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {
    private final DirectorRepository directorRepository;
    private final DirectorConverter directorConverter;
    private final DepartmentRepository departmentRepository;
    private final DirectorHistoryRepository directorHistoryRepository;
    @Override
    public DirectorDTO save(DirectorDTO directorDTO) throws Exception {

        return changeDirectorHistoryKept(directorDTO);
    }
    private void validateDepartmentID(Long id) throws Exception{
        if(id == null){
            throw new Exception("You may not save a director that belongs " +
                    "to no department!");
        }
    }
    private void validateDirectorId(Long id) throws Exception{
        if(id == null){
            throw new Exception("Director id may not be null!");
        }
    }
    private Department fetchDepartmentIfItExists(Long id)
            throws EntityNotFoundException{

        if(id == null){
            throw new NullPointerException("Id must not be null");
        }

        final Optional<Department> departmentOptFromDB
                = departmentRepository.findById(id);

        if(departmentOptFromDB.isEmpty()){
            throw new EntityNotFoundException("Not a valid department id.");
        }

        return departmentOptFromDB.get();
    }

    private DirectorDTO saveNewDirectorDifferentScenarios(
                                                Director newDirector){

        final Department directorChangeDepartment = newDirector.getDepartment();

        if(directorChangeDepartment.getDirector() != null){

            final Optional<Director> currentDirectorOpt = directorRepository.findById
                    (directorChangeDepartment
                            .getDirector()
                            .getId());

//        if(currentDirectorOpt.isEmpty()){
//            final Director savedDirector = directorRepository.save(newDirector);
//
//            return directorConverter.toDto(savedDirector);
//        }

            final Director currentDirector = currentDirectorOpt.get();
            moveCurrentDirectorToHistory(currentDirector);
        }
        final var newDirectorSaved = directorRepository.save(newDirector);
        final Department updatedDepartment = newDirector.getDepartment();
        updatedDepartment.getDirector().setId(newDirectorSaved.getId());
        departmentRepository.save(updatedDepartment);

        return directorConverter.toDto(newDirectorSaved);
    }
    private void moveCurrentDirectorToHistory(Director currentDirector) {

        final LocalDate startDate = currentDirector.getStartDate();
        final LocalDate endDate = LocalDate.now();

        final Department directorChangeDepartment =
                fetchDepartmentIfItExists(currentDirector.getDepartment().getId());

        final DirectorHistory newlyHistoricDirector =
                new DirectorHistory(null, startDate, endDate,
                        directorChangeDepartment, currentDirector);

        directorHistoryRepository.save(newlyHistoricDirector);
        directorRepository.delete(currentDirector);
    }

    private Director determineDirector(DirectorDTO directorDTO){
        final Director director = directorConverter.toEntity(directorDTO);
        final String firstName = director.getFirstName();
        final String lastName = director.getLastName();

        final Optional<Director> directorDbOpt
                = directorRepository.findByFirstNameAndLastName(
                        firstName, lastName);

        if(directorDbOpt.isPresent()){
            return directorDbOpt.get();
        }
        director.setId(null);

        return director;
    }
    @Transactional
    private DirectorDTO changeDirectorHistoryKept(DirectorDTO directorDTO)
            throws Exception{

        validateDepartmentID(directorDTO.departmentId());
        final Director newDirector =
                determineDirector(directorDTO);

        final Department directorChangeDepartment =
                fetchDepartmentIfItExists(directorDTO.departmentId());

        newDirector.setDepartment(directorChangeDepartment);

        return saveNewDirectorDifferentScenarios(newDirector);

    }
    @Override
    public List<DirectorDTO> getAll() {
        return directorConverter.listToDto(
                directorRepository.findAll()
        );
    }

    @Override
    public void delete(Long id) throws Exception {
        validateDirectorId(id);

        final Optional<Director> currentDirectorOpt =
            directorRepository.findById(id);

        if(currentDirectorOpt.isEmpty()){
            throw new Exception("Director with given id not found.");
        }
        final Director currentDirector = currentDirectorOpt.get();

        moveCurrentDirectorToHistory(currentDirector);
    }


    @Override
    public DirectorDTO findById(Long id) throws Exception {
        final Optional<Director> directorOptDB
                = directorRepository.findById(id);

        if(directorOptDB.isEmpty()){
            throw new Exception("Could not find a director with given id.");
        }

        final Director foundDirector = directorOptDB.get();
        return directorConverter.toDto(foundDirector);
    }
}
