package projnj.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import projnj.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "dispatches",
    path = "dispatches"
)
public interface DispatchRepository
    extends PagingAndSortingRepository<Dispatch, Long> {}
