package ch.heg.ig.sda.app.io;

import ch.heg.ig.sda.app.business.Recette;

import java.util.Collection;

public abstract class RecettesDatabaseLoader {

    protected String filepath;

    protected Collection<Recette> recettes;

    public RecettesDatabaseLoader(String filepath) {
        this.filepath = filepath;
    }

    public String getFilepath() {
        return filepath;
    }

    public Collection<Recette> getRecettes() {
        return recettes;
    }

}
