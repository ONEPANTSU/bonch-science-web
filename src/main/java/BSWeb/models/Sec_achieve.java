package BSWeb.models;



import javax.persistence.*;


@Entity
public class Sec_achieve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sec_id;

    private Long achieve_id;


    public Long getAchieve_id() {
        return achieve_id;
    }

    public void setAchieve_id(Long achieve_id) {
        this.achieve_id = achieve_id;
    }

    public Long getSec_id() {
        return sec_id;
    }

    public void setSec_id(Long sec_id) {
        this.sec_id = sec_id;
    }

}
