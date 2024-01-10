package nst.springboot.restexample01.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class PaginationUtil {

    public Pageable createPageable(int page, int pageSize,
                                   String sortingCriterium,
                                   String sortingDirection){
        return PageRequest.of(page, pageSize,
                switch (sortingDirection.toLowerCase()) {
                    case "desc" -> Sort.by(sortingCriterium).descending();
                    default -> Sort.by(sortingCriterium).ascending();
                });
    }
}
