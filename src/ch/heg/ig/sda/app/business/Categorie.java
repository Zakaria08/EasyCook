package ch.heg.ig.sda.app.business;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

public class Categorie {

    private String nom;

    private Collection<Recette> recettesCat ;

    public Categorie(String nom) {
        this.nom = nom;
        this.recettesCat = new LinkedList<Recette>();
    }

    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<Recette> getRecettesCat() {
        return recettesCat;
    }

    public void addRecipe(Recette recette){
        recettesCat.add(recette);
    }

    @Override
    public String toString() {
        return this.nom;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return nom.equals(categorie.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
