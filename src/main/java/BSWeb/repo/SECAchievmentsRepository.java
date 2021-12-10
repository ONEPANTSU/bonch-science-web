package BSWeb.repo;

import BSWeb.models.Achievments;
import BSWeb.models.Sec_achieve;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SECAchievmentsRepository extends CrudRepository<Sec_achieve, Long> {

}
