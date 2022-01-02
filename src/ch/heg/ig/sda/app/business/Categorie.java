package ch.heg.ig.sda.app.business;

import java.util.Collection;

public class Categorie {

    private String nom;

    private Collection<Recette> recettes;

    public Categorie(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return this.nom;

    }
}
