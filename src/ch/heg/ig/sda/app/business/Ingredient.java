package ch.heg.ig.sda.app.business;

public class Ingredient {

    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Ingredient(String nom) {
        this.nom = nom;
    }


    @Override
    public String toString() {
        return this.nom;
    }
}
