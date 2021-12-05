package ch.heg.ig.sda.app.business;

import java.util.Date;

public class Personne {

    private Integer id;
    private String nom;
    private String prénom;
    private Date dateOfBirth;
    private String email;

    public Personne(Integer id, String nom, String prénom, Date dateOfBirth, String email) {
        this.id = id;
        this.nom = nom;
        this.prénom = prénom;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
