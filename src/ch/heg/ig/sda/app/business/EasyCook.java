package ch.heg.ig.sda.app.business;

import ch.heg.ig.sda.app.io.RecettesCsvDatabaseLoader;

import java.util.Collection;

public class EasyCook implements IEasyCook {

    private Collection<Recette> recettes;

    @Override
    public void printRecipes() {
        for (Recette recette : recettes){
            System.out.println(recette.toString());
        }
    }

    @Override
    public void loadRecipes(String filepath) {
        RecettesCsvDatabaseLoader loader = new RecettesCsvDatabaseLoader(filepath);
        loader.process();
        this.recettes = loader.getRecettes();
    }

    @Override
    public void add(Recette recette) {

    }
    @Override
    public Recette remove() {
        return null;
    }

    @Override
    public Collection<Recette> getRecette(String nom) {
        return null;
    }

    @Override
    public Collection<Recette> getRecette(Categorie categorie) {
        return null;
    }

    @Override
    public Collection<Recette> getRecette(Personne personne) {
        return null;
    }

    @Override
    public Collection<Recette> getRecette(Ingrédient ingrédient) {
        return null;
    }
}
