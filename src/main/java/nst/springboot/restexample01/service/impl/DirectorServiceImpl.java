package nst.springboot.restexample01.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nst.springboot.restexample01.converter.impl.DirectorConverter;
import nst.springboot.restexample01.domain.Department;
import nst.springboot.restexample01.domain.Director;
import nst.springboot.restexample01.domain.DirectorHistory;
import nst.springboot.restexample01.dto.DirectorDTO;
import nst.springboot.restexample01.repository.DepartmentRepository;
import nst.springboot.restexample01.repository.DirectorHistoryRepository;
import nst.springboot.restexample01.repository.DirectorRepository;
import nst.springboot.restexample01.service.abstraction.DirectorService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
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

        final Optional<Department> departmentOptFromDB
                = departmentRepository.findById(id);

        if(departmentOptFromDB.isEmpty()){
            throw new EntityNotFoundException("Not a valid department id.");
        }

        return departmentOptFromDB.get();
    }

    private DirectorDTO saveNewDirectorDifferentScenarios(Department directorChangeDepartment,
                                                Director newDirector){
        final Optional<Director> currentDirectorOpt =
                directorRepository.findById(
                        directorChangeDepartment.getDirector().getId());

        if(currentDirectorOpt.isEmpty()){
            final Director savedDirector = directorRepository.save(newDirector);
            return directorConverter.toDto(savedDirector);
        }

        final Director currentDirector = currentDirectorOpt.get();
        moveCurrentDirectorToHistory(currentDirector);

        final var newDirectorSaved = directorRepository.save(newDirector);

        return directorConverter.toDto(newDirectorSaved);
    }
    private void moveCurrentDirectorToHistory(Director currentDirector) {

        final Instant startDate = currentDirector.getStartDate();
        final Instant endDate = Instant.from(Instant.now().atZone
                (ZoneId.systemDefault()).toLocalDate());

        final Department directorChangeDepartment =
                fetchDepartmentIfItExists(currentDirector.getDepartment().getId());

        final DirectorHistory newlyHistoricDirector =
                new DirectorHistory(null, startDate, endDate,
                        directorChangeDepartment, currentDirector);

        directorHistoryRepository.save(newlyHistoricDirector);
        directorRepository.delete(currentDirector);
    }
    @Transactional
    private DirectorDTO changeDirectorHistoryKept(DirectorDTO directorDTO)
            throws Exception{

        validateDepartmentID(directorDTO.departmentId());
        final Director newDirector =
                directorConverter.toEntity(directorDTO);

        final Department directorChangeDepartment =
                fetchDepartmentIfItExists(directorDTO.departmentId());

        return saveNewDirectorDifferentScenarios(directorChangeDepartment,
                newDirector);

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
    public DirectorDTO update(DirectorDTO directorDTO) throws Exception {

    return null;
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
