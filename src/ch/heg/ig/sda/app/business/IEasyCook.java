package ch.heg.ig.sda.app.business;

import java.util.Collection;

public interface IEasyCook {
    void loadRecipes(String filepath);
    void printRecipes();
    void add(Recette recette);
    Recette remove();
    Collection<Recette> getRecette(String nom);
    Collection<Recette> getRecette(Categorie categorie);
    Collection<Recette> getRecette(Personne personne);
    Collection<Recette> getRecette(Ingrédient ingrédient);

}
