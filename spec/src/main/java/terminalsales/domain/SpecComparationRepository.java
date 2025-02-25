package terminalsales.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import terminalsales.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "specComparations",
    path = "specComparations"
)
public interface SpecComparationRepository
    extends PagingAndSortingRepository<SpecComparation, Long> {}
