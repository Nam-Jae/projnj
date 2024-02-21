package projnj.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import projnj.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "calls", path = "calls")
public interface CallRepository
    extends PagingAndSortingRepository<Call, Long> {}
