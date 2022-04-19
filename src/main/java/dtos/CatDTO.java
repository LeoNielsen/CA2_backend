package dtos;

public class CatDTO {
    private String fact;
    private String url;
    private String width;
    private String height;

    public CatDTO(FactDTO factDTO, CatImageDTO catImageDTO) {
        this.fact = factDTO.getFact();
        this.url = catImageDTO.getUrl();
        this.width = catImageDTO.getWidth();
        this.height = catImageDTO.getHeight();
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

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
