package BSWeb.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Achievements {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long secid;
    private String title;

    public Achievements(){}
    public Achievements(Long id, Long secid, String title){
        this.id = id;
        this.secid = secid;
        this.title = title;
    }
    public Achievements(Long secid, String title){
        this.secid = secid;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getSecid() {
        return secid;
    }

    public void setSecid(Long secid) {
        this.secid = secid;
    }
}
