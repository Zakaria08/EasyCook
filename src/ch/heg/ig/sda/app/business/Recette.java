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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
