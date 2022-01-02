package ch.heg.ig.sda.app.business;

import ch.heg.ig.sda.app.io.RecettesCsvDatabaseLoader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EasyCookMap extends EasyCook {

    private Map<String,Recette> recettes;

    @Override
    public void printRecipes() {
        for (Recette recette : recettes.values()){
            System.out.println(recette.toString());
        }
    }

    @Override
    protected void doLoadRecipes(RecettesCsvDatabaseLoader loader) {

        Map<String,Recette> mapTemp = new HashMap<>();

        for (Recette var : loader.getRecettes())
        {
            mapTemp.put(var.getNom(),var);
        }
        this.recettes = mapTemp;
    }

    @Override
    public void add(Recette recette) {

    }
    @Override
    public Recette remove(Recette recette) {
        return null;
    }

    @Override
    public Collection<Recette> getRecette() {
        return null; //this.recettes;
    }

    @Override
    public Collection<Recette> getRecetteByName(String nom) {
        if (this.recettes.containsKey(nom) == true){
            Collection<Recette> tempCol = new ArrayList<>();
            tempCol.add(this.recettes.get(nom));
                return tempCol ;
        }
        else{
            System.out.println("Aucune recette n'a ce nom");
            return null;
        }
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
}
