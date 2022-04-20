package dtos;

import java.util.List;

public class DogFactDTO {
    private List<String> facts;

    public DogFactDTO(List<String> fact) {
        this.facts = fact;
    }

    public List<String> getFacts() {
        return facts;
    }

    public void setFacts(List<String> facts) {
        this.facts = facts;
    }
}
