package BSWeb.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String text;
    private int views;

    public Post(String title, String text){
        this.title = title;
        this.text = text;
    }
    public Post(Long id, String title, String text){
        this.id = id;
        this.title = title;
        this.text = text;
    }
    public Post(){};

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

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public int getViews() {
        return views;
    }
    public void setViews(int views) {
        this.views = views;
    }
}
