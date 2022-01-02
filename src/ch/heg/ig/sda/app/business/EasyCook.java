package ch.heg.ig.sda.app.business;

import ch.heg.ig.sda.app.io.RecettesCsvDatabaseLoader;

import java.util.Collection;
import java.util.Set;

public abstract class EasyCook implements IEasyCook {

    private Collection<Recette> recettes;
    private Set<Categorie> categories;

    @Override
    public void printRecipes() {
        for (Recette recette : recettes){
            System.out.println(recette.toString());
        }
    }

    @Override
    public void printCategories() {
        for (Categorie categorie : categories){
            System.out.println(categorie.toString());
        }
    }

    @Override
    public void loadRecipes(String filepath) {
       RecettesCsvDatabaseLoader loader = new RecettesCsvDatabaseLoader(filepath);
        loader.process();
        this.categories  = loader.getCategories();
        doLoadRecipes(loader);
    }

    @Override
    public void add(Recette recette) {

    }
    @Override
    public Recette remove(Recette recette) {
        return null;
    }

   // @Override
    //public Collection<Recette> getRecette() {
      //  return this.recettes;
    //}

    @Override
    public Collection<Recette> getRecetteByName(String nom) {
        return null;
    }

    @Override
    public Collection<Recette> getRecetteByCategorie(Categorie categorie) {
        return null;
    }

    @Override
    public Collection<Recette> getRecetteByPerson(Personne personne) {
        return null;
    }

    @Override
    public Collection<Recette> getRecette(Ingredient ingredient) {

        return null;
    }

    protected abstract void doLoadRecipes(RecettesCsvDatabaseLoader loader);
}
