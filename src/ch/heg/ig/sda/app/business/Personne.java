package ch.heg.ig.sda.app.business;

import java.util.Date;

public class Personne {

    private String nom;
    private String prénom;

    public Personne(String nom, String prénom) {
        this.nom = nom;
        this.prénom = prénom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

}
