package BSWeb.models;

import javax.persistence.*;

@Entity
public class SECAchieve {
    @Id
    private Long id;
    private Long sec_id;
    private Long achieve_id;

    SECAchieve(){}
    SECAchieve(Long id, Long sec_id, Long achieve_id){
        this.id = id;
        this.sec_id = sec_id;
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

    public Long getSec_id() { return sec_id; }

    public void setSec_id(Long sec_id) { this.sec_id = sec_id; }
}
