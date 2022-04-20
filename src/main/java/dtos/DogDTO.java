package dtos;

public class DogDTO {
    private String fact;
    private String url;

    public DogDTO(DogFactDTO factDTO, DogImageDTO dogImageDTO) {
        this.fact = factDTO.getFacts().get(0);
        this.url = dogImageDTO.getUrl();

    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
