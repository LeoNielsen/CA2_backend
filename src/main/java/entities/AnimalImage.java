package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "animal_Image")
public class AnimalImage {

    @Id
    @Basic(optional = false)
    @NotNull
    private String id;
    @Column
    private String URL;

    public AnimalImage(String id, String URL) {
        this.id = id;
        this.URL = URL;
    }

    public AnimalImage() {

    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}