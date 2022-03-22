package BSWeb.repo;

import BSWeb.models.Event;
import BSWeb.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findAllByOrderByIdDesc();
}
