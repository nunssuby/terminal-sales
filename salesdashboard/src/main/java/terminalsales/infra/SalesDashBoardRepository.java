package terminalsales.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import terminalsales.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "salesDashBoards",
    path = "salesDashBoards"
)
public interface SalesDashBoardRepository
    extends PagingAndSortingRepository<SalesDashBoard, Long> {}
