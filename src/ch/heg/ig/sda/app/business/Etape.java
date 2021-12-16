package ch.heg.ig.sda.app.business;

import java.util.Collection;

public class Etape {

    private String name;

    private Collection<Ustensile> ustensiles;

    public Etape(String name, Collection<Ustensile> ustensiles) {
        this.name = name;
        this.ustensiles = ustensiles;
    }
}
