package ch.heg.ig.sda.app.io;

import ch.heg.ig.sda.app.business.Categorie;
import ch.heg.ig.sda.app.business.Recette;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class RecettesDatabaseLoader {

    protected String filepath;

    protected Collection<Recette> recettes;
    protected Map<String,Categorie> categories;

    public RecettesDatabaseLoader(String filepath) {
        this.filepath = filepath;
    }

    public String getFilepath() {
        return filepath;
    }

    public Collection<Recette> getRecettes() {return recettes;}
    public Map<String,Categorie> getCategories() { return categories;}


}
