package entities;

import javax.persistence.*;

@Entity
@Table(name = "animal_Image")
public class AnimalImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String URL;

    public AnimalImage(String URL) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}