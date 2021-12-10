package BSWeb.repo;

import BSWeb.models.SEC;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SECRepository extends CrudRepository<SEC, Long> {

}
