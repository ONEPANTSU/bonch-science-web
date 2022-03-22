package BSWeb.repo;

import BSWeb.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PostRepository extends CrudRepository<Post, Long> {
    @Query("select p from Post p order by p.id DESC")
     List<Post> findAllByOrderByIdDesc();
}
