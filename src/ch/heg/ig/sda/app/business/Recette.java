package ch.heg.ig.sda.app.business;

import java.util.Collection;

public class Recette {

    private String nom;
    private Personne auteur;
    private Collection<Ingrédient> ingrédients;
    private Collection<Categorie> catégories;
    private Collection<Etape> étapes;

    public Recette(String nom, Personne auteur, Collection<Ingrédient> ingrédients, Collection<Categorie> catégories, Collection<Etape> étapes) {
        this.nom = nom;
        this.auteur = auteur;
        this.ingrédients = ingrédients;
        this.catégories = catégories;
        this.étapes = étapes;
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

    public Collection<Ingrédient> getIngrédients() {
        return ingrédients;
    }

    public void setIngrédients(Collection<Ingrédient> ingrédients) {
        this.ingrédients = ingrédients;
    }

    public Collection<Categorie> getCatégories() {
        return catégories;
    }

    public void setCatégories(Collection<Categorie> catégories) {
        this.catégories = catégories;
    }

    public Collection<Etape> getÉtapes() {
        return étapes;
    }

    public void setEtapes(Collection<Etape> étapes) {
        this.étapes = étapes;
    }

    @Override
    public String toString() {
        return "Recette{" +
                "nom='" + nom + '\'' +
                ", auteur=" + auteur +
                ", ingrédients=" + ingrédients +
                ", catégories=" + catégories +
                ", étapes=" + étapes +
                '}';
    }
}
