package ch.heg.ig.sda.app.business;

import ch.heg.ig.sda.app.io.RecettesCsvDatabaseLoader;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class EasyCookList extends EasyCook {

    private List<Recette> recettes = new ArrayList<>();

    @Override
    public void printRecipes() {
        for (Recette recette : recettes){
            System.out.println(recette.toString());
        }
    }

    @Override
    protected void doLoadRecipes(RecettesCsvDatabaseLoader loader) {
        List<Recette> listTemp = new ArrayList<>();

        for (Recette var : loader.getRecettes())
        {
            listTemp.add(var);
        }
        this.recettes = listTemp;
    }


    @Override
    public void add(Recette recette) {
        recettes.add(recette);
    }

    @Override
    public Boolean removeRecette(Recette recette) {
        if(recettes.contains(recette)){
            return recettes.remove(recette);
        }
        else{
            System.out.println("Recette inexistante");
            return null;
        }
    }

    @Override
    public Collection<Recette> getRecette() {
        return this.recettes;
    }

    @Override
    public Collection<Recette> getRecetteByName(String nom) {
        Collection<Recette> tempCol = recettes.stream()
                .filter(recette -> recette.getNom().equals(nom))
                .collect(Collectors.toList());
        return tempCol;

    }

    @Override
    public Collection<Recette> getRecetteByPerson(Personne personne) {
        Collection<Recette> tempCol = recettes.stream()
                .filter(recette -> recette.getAuteur().getNom().equals(personne.getNom()) &&
                        recette.getAuteur().getPrenom().equals(personne.getPrenom()))
                .collect(Collectors.toList());
        return tempCol;
    }

    @Override
    public Collection<Recette> getRecetteByIngredient(Ingredient ingredient) {

        Collection<Recette> tempCol = recettes.stream()
                .filter(recette -> recette.getIngredients().contains(ingredient))
                .collect(Collectors.toList());
        return tempCol;
    }

}
