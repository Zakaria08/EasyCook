package ch.heg.ig.sda.app.business;

public class Etape {

    private String description;


    public Etape(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
