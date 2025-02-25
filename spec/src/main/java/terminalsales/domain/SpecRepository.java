package terminalsales.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import terminalsales.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "specs", path = "specs")
public interface SpecRepository
    extends PagingAndSortingRepository<Spec, Long> {}
