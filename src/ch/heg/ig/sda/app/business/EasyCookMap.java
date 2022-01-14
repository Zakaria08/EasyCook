package ch.heg.ig.sda.app.business;

import ch.heg.ig.sda.app.io.RecettesCsvDatabaseLoader;

import java.util.*;

public class EasyCookMap extends EasyCook {

    private Map<String,Recette> recettes = new HashMap<>();

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
        recettes.put(recette.getNom(),recette);
    }

    @Override
    public Boolean removeRecette(Recette recette) {
        if(recettes.containsKey(recette.getNom())){
            return recettes.remove(recette.getNom(),recette);
        }
        else{
            System.out.println("Recette inexistante");
            return null;
        }
    }

    @Override
    public Collection<Recette> getRecette() {
        return recettes.values();
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
    public Collection<Recette> getRecetteByPerson(Personne personne) {
        Collection<Recette> tempCol = new LinkedList<>();
        for (Recette recette:recettes.values()) {
            if (recette.getAuteur().getNom().equals(personne.getNom()) && recette.getAuteur().getPrenom().equals(personne.getPrenom())){ // comparaison nom/prénom   n
                tempCol.add(recette);
            }
        }
        return tempCol;
    }

    @Override
    public Collection<Recette> getRecetteByIngredient(Ingredient ingredient) {
        Collection<Recette> tempCol = new LinkedList<>();
        for (Recette recette:recettes.values()) {
            for (Ingredient var:recette.getIngredients()) {
                if (var.getNom().equals(ingredient.getNom()) ){
                    tempCol.add(recette);
                }
            }
        }
        return tempCol;
    }
}
