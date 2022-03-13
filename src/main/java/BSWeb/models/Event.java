package BSWeb.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String text;
    private String date;

    public Event(){}

    public Event(String title, String text, String date){
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public Event(Long id, String title, String text, String date){
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

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

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }


}
