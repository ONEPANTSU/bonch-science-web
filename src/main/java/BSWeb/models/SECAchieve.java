package BSWeb.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SECAchieve {
    @Id
    private Long id;
    private Long achieve_id;

    SECAchieve(){}
    SECAchieve(Long id, Long achieve_id){
        this.id = id;
        this.achieve_id = achieve_id;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAchieve_id() {
        return achieve_id;
    }

    public void setAchieve_id(Long achieve_id) {
        this.achieve_id = achieve_id;
    }
}
