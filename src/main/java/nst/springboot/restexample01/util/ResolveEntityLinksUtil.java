package nst.springboot.restexample01.util;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import nst.springboot.restexample01.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ResolveEntityLinksUtil {

    @Transactional
    public <T extends BaseEntity> T saveIfNotNull(
            T entity, JpaRepository<T, Long> repository) {

        if(entity == null){
            throw new IllegalArgumentException("There is a null entity" +
                    " that is preventing" +
                    " the saving process");
        }
        final Optional<T> entityDbOpt = repository.findById(entity.getId());

        if (entity.getId() == null || entityDbOpt.isEmpty()) {
            return repository.save(entity);
        }

        return entityDbOpt.get();
    }

    @Transactional
    public <T extends BaseEntity> List<T> saveListIfNotNull(
            List<T> entities,
            JpaRepository<T, Long> repository) {
        if(entities == null){
            throw new IllegalArgumentException("Null list of sub-entities detected while " +
                    "saving your main entity. Null lists are not allowed." +
                    "Please replace with empty list.");
        }
        final List<T> retVal = new ArrayList<>();

        entities.stream().forEach(t -> {
            retVal.add(saveIfNotNull(t, repository));
        });

        return retVal;
    }

}
