package terminalsales.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import terminalsales.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "insuranceSubscriptions",
    path = "insuranceSubscriptions"
)
public interface InsuranceSubscriptionRepository
    extends PagingAndSortingRepository<InsuranceSubscription, Long> {}
