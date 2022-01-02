package ch.heg.ig.sda.app.business;

import java.util.Collection;

public interface IEasyCook {
    void loadRecipes(String filepath);
    void printRecipes();
    void printCategories();
    void add(Recette recette);
    Recette remove(Recette recette);
    Collection<Recette> getRecette();
    Collection<Recette> getRecetteByName(String nom);
    Collection<Recette> getRecetteByCategorie(Categorie categorie);
    Collection<Recette> getRecetteByPerson(Personne personne);
    Collection<Recette> getRecette(Ingredient ingredient);

}
