package ch.heg.ig.sda.app.business;

import ch.heg.ig.sda.app.io.RecettesCsvDatabaseLoader;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class EasyCook implements IEasyCook {

    private Map<String,Categorie> categories = new HashMap<>();     // collection de catégorie

    @Override
    public void printCategories() {
        for (Categorie categorie : categories.values()){
            System.out.println(categorie.toString());
        }
    }

    @Override
    public void loadRecipes(String filepath) {
       RecettesCsvDatabaseLoader loader = new RecettesCsvDatabaseLoader(filepath);
        loader.process();
        this.categories  = loader.getCategories();
        doLoadRecipes(loader); //spécifique à l'implémentation
    }

    protected abstract void doLoadRecipes(RecettesCsvDatabaseLoader loader);

    @Override
    public Collection<Recette> getRecetteByCategory(String nom) {
        if( categories.containsKey(nom)){
            return categories.get(nom).getRecettesCat();
        }
        else {
            System.out.println("Catégorie inexistante");
            return null;
        }
    }
}
