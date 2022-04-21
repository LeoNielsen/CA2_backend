package dtos;

public class CatDTO {

    private String id;
    private String fact;
    private String url;

    public CatDTO(CatFactDTO factDTO, AnimalImageDTO catImageDTO) {
        this.id = catImageDTO.getId();
        this.fact = factDTO.getFact();
        this.url = catImageDTO.getUrl();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
