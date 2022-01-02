package ch.heg.ig.sda.app.business;

import java.util.Collection;
import java.util.LinkedList;

public class Recette {

    private String nom;
    private Personne auteur;
    private LinkedList<Ingredient> ingredients;
    private Categorie categorie;
    private LinkedList<Etape> etapes;

    public Recette(String nom, Personne auteur, LinkedList<Ingredient> ingredients, Categorie categorie, LinkedList<Etape> etapes) {
        this.nom = nom;
        this.auteur = auteur;
        this.ingredients = ingredients;
        this.categorie = categorie;
        this.etapes = etapes;
    }
    public Recette(){

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Personne getAuteur() {
        return auteur;
    }

    public void setAuteur(Personne auteur) {
        this.auteur = auteur;
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(LinkedList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public LinkedList<Etape> getEtapes() {
        return etapes;
    }

    public void setEtapes(LinkedList<Etape> etapes) {
        this.etapes = etapes;
    }

    @Override
    public String toString() {
        return "Recette{" +
                "nom= " + nom + '\'' +
                ", auteur= " + auteur +
                ", ingrédients= " + ingredients +
                ", catégorie= " + categorie +
                ", étapes= " + etapes +
                '}';
    }
}
