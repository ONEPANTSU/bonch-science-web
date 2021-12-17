package BSWeb.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SEC {
    public SEC(){}

    public SEC(String title, String full_name, String description) {
        this.title = title;
        this.full_name = full_name;
        this.description = description;
    }

    public SEC(Long id, String title, String full_name, String description) {
        this.id = id;
        this.title = title;
        this.full_name = full_name;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String full_name;
    private String description;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getFull_name() {
        return full_name;
    }
    public void setFull_name(String text) {
        this.full_name = full_name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
